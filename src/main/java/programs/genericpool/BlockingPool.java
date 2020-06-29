package programs.genericpool;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @param <T>
 * @author dean.jain
 * A Generic Object Pool which can maintain any types of objects
 * Its bounded pool so can define a Max configurable number of Objects that can be added in pool
 * It has a parallel Maintenence thread which handles expansion/Shrinkage based on usage
 */
public abstract class BlockingPool<T> {

    private LinkedBlockingQueue<T> blockingPool;


    //Stores count of used objects from pool
    private final AtomicInteger objectsUsed = new AtomicInteger(0);

    // Max objects in pool, default value 15
    private final int maxPoolSize;

    private final int minPoolSize;

    private int printInterval = 1;

    private int variablePoolSize;

    // ExecutorService that can schedule commands to run after a given delay, or to execute periodically
    private ScheduledExecutorService executorService;

    /**
     * Creates the default pool with minPoolSize number of objects
     * sets max objects allowed in the pool with maxPoolSize
     * It also runs a parallel maintanence thread every maintenenceTime seconds
     * and shrink/expand pool if the usage is >60% or <50%
     *
     * @param minPoolSize
     * @param maxPoolSize
     * @param maintenenceTime
     */
    public BlockingPool(int minPoolSize, int maxPoolSize, long maintenenceTime) {
        this.maxPoolSize = maxPoolSize;
        this.minPoolSize = minPoolSize;
        this.variablePoolSize = minPoolSize;


        try {
            // initialize pool with max size
            initializeBlockingPool(minPoolSize, maxPoolSize);

            // separate thread to run maintenance in the pool
            executorService = Executors.newSingleThreadScheduledExecutor();

            executorService.scheduleWithFixedDelay(() -> {
                int size = blockingPool.size();
                printInterval++;
                // prints the pool usage every maintenenceTime number of seconds
                System.out.println("Total Pool Size = " + size);

                // prints usage count every 15 seconds
                if (printInterval == 2) {
                    System.out.println("Objects Used Count =" + objectsUsed.get());
                    printInterval = 0;
                }

                // if usage is >=60% based on variablePoolSize then variablePoolSize++
                if ((objectsUsed.get() * 100 / variablePoolSize) >= 60) {
                    variablePoolSize += 1;
                } // if usage is <=50% based on variablePoolSize then variablePoolSize--
                else if (variablePoolSize > minPoolSize && (objectsUsed.get() * 100 / variablePoolSize) <= 50) {
                    variablePoolSize -= 1;
                }

                System.out.println("variablePoolSize = " + variablePoolSize);

                // real expansion / shrinking of the pool based on current pool size vs newly calculated variablePoolSize
                if (blockingPool.size() < variablePoolSize) {
                    if (objectsUsed.compareAndSet(BlockingPool.this.maxPoolSize, BlockingPool.this.maxPoolSize)) {
                        return;
                    }
                    int sizeToBeAdded = variablePoolSize - blockingPool.size();
                    // non blocking expansion / adding objects
                    for (int i = 0; i < sizeToBeAdded; i++) {
                        System.out.println("Adding Object");
                        blockingPool.offer(create());
                    }
                } else if (blockingPool.size() > minPoolSize && blockingPool.size() > variablePoolSize) {
                    int sizeToBeRemoved = blockingPool.size() - variablePoolSize;
                    // non blocking removal / shrinking
                    for (int i = 0; i < sizeToBeRemoved; i++) {
                        System.out.println("Removing Object");
                        blockingPool.poll();
                    }
                }
            }, maintenenceTime, maintenenceTime, TimeUnit.SECONDS);

        } catch (Exception e) {
            System.err.println(e);
        }
    }


    /**
     * Gets next free object from the pool else blocks the call
     *
     * @return T object
     */
    public T getResource() throws InterruptedException {

        T object = blockingPool.take();
        System.out.println("Took Object from Pool");
        objectsUsed.incrementAndGet();

        return object;
    }

    /**
     * Gets  next free object from the pool with a wait time out in seconds.
     * its a non blocking overloaded version
     *
     * @return T object
     */
    public T getResource(long waitTime) throws InterruptedException {

        T object = blockingPool.poll(waitTime, TimeUnit.SECONDS);
        System.out.println("Took Object from Pool");
        objectsUsed.incrementAndGet();

        return object;
    }

    /**
     * Returns object to the pool.
     *
     * @param object
     */
    public void putResource(T object) {
        if (object == null) {
            return;
        }

        blockingPool.offer(object);
        System.out.println("Returning Object to Pool");
        objectsUsed.decrementAndGet();
    }

    /**
     * Creates a new object, this can be extended by consumers and they can provide
     * their own implementation
     * based on the type of object they want to create and manage in pool.
     */
    protected abstract T create();

    /**
     * init the blocking pool with min number of objects in pool
     *
     * @param min
     */
    private void initializeBlockingPool(int min, int max) {

        // defining the Pool with max capacity / bounded
        blockingPool = new LinkedBlockingQueue<T>(max);

        System.out.println("pool max capacity = " + blockingPool.remainingCapacity());

        for (int i = 0; i < min; i++) {
            System.out.println("init adding object");
            // adding min number of object to pool and ensure its not going beyond max connections
            blockingPool.offer(create());
        }
    }


}

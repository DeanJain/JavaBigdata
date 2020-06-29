package programs.genericpool;

public class GenericPoolTest {

    public static void main(String[] args) {

        int min = 10, max = 30;

        BlockingPool<Object> op = new BlockingPool<Object>(min, max, 2) {
            @Override
            protected Object create() {

                return new Object();
            }
        };

        try {

            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {

                }
            });

            Thread t1 = new Thread(() -> {

                for (int i = 0; i < 20; i++) {
                    try {
                        op.getResource();

                    } catch (InterruptedException e) {
                        System.err.println(e);
                    }
                }
            });

            Thread t2 = new Thread(() -> {

                for (int i = 0; i < 20; i++) {
                    op.putResource(new Object());

                }
            });

            Thread t3 = new Thread(() -> {

                for (int i = 0; i < 20; i++) {
                    try {
                        op.getResource();

                    } catch (InterruptedException e) {
                        System.err.println(e);
                    }
                }
            });

            Thread t4 = new Thread(() -> {

                for (int i = 0; i < 6; i++) {
                    op.putResource(new Object());

                }
            });

            t1.start();
            t2.start();

            t3.start();
            t4.start();

        } catch (Exception e) {
            System.err.println(e);
        }
    }

}

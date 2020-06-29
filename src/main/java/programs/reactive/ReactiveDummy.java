package programs.reactive;

import reactor.core.publisher.Flux;

import java.util.Comparator;
import java.util.logging.Logger;


public class ReactiveDummy {

    private final static Logger log = Logger.getLogger(ReactiveDummy.class.getName());

    public static void main(String[] args) {

        log.info("ReactiveDummy Start");

        Flux<String> stream1 = Flux.just("Hello", "world");

        System.out.println(stream1.toStream().count());

        stream1.subscribe(
                data -> log.info("onNext: " + data),
                err -> { /* ignored  */ },
                () -> log.info("onComplete")
        );

        Flux.range(1, 100)                                                 // (1)
                .subscribe(                                                    // (2)
                        data -> log.info("onNext: " + data),
                        err -> { /* ignore */ },
                        () -> log.info("onComplete"),
                        subscription -> {                                          // (3)
                            subscription.request(4);                                // (3.1)
                            subscription.cancel();                                  // (3.2)
                        }
                );

        Flux.just(1, 6, 2, 8, 3, 1, 5, 1)
                .collectSortedList(Comparator.reverseOrder())
                .subscribe(System.out::println);

        Flux.range(1, 5)
                .reduce(0, (acc, elem) -> acc + elem)
                .subscribe(result -> log.info("Result: " + result));


    }
}

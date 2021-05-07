package countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchApp {

    public static void main(final String[] args) throws InterruptedException {

        CountDownLatch latch = new CountDownLatch(3);

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 4; i++) {
            executorService.submit(new Processor(latch));
        }

//        try {
            latch.await(); //here we make the main thread wait for the CountDownLatch to go to zero
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
       System.out.println("RDV point: 3 have completed");
        executorService.shutdown();
    }


}

class Processor implements Runnable {
    private CountDownLatch latch;

    public Processor(CountDownLatch latch) {
        this.latch = latch;
    }

    public void run() {
        System.out.println("Thread started");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        latch.countDown(); // CountDownLatch is thread safe class, so no need to put synchronized here
        System.out.println("Countdown: -1");
    }
}

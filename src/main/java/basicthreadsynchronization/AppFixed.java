package basicthreadsynchronization;

import java.util.Scanner;

class Processor1 extends Thread {
    private volatile boolean running = true;

    @Override
    public void run(){
        while (running) {
            System.out.println("Hello");


            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public void shutdown() {
        running = false;
    }
}

public class AppFixed {
    public static void main(String[] args) {
        Processor1 proc1 = new Processor1();
        proc1.start();

        System.out.println("Press return to stop...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        proc1.shutdown(); // calling in the main thread, not in the proc1 thread!!!

    }
}

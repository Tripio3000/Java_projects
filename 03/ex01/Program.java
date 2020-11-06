package ex01;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Program {
    private static Integer counter = 1;
    private static int oper;
    private static BlockingQueue<String> queue = new ArrayBlockingQueue<String>(10);

    public static void main (String[] args) throws InterruptedException {
        String [] pars;
        if (args.length <= 0) {
            System.exit(-1);
        }
        pars = args[0].split("=");
        oper = Integer.parseInt(pars[1]);
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    producer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    consumer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
    private static void producer () throws InterruptedException {
        String name;

        while (true) {
            if (counter % 2 == 0) {
                name = "Egg";
            }
            else {
                name = "Hen";
            }
            queue.put(name);
            counter++;
        }
    }
    private static void consumer () throws InterruptedException {
        for (int i = 0; i < oper; i++) {
            Thread.sleep(100);

            System.out.println(queue.take());
        }
        System.exit(-1);
    }
}

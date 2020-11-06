package ex00;

public class Program {
    public static void main (String[] args) {
        Thread mainThread = Thread.currentThread();
        String [] pars;
        if (args.length <= 0) {
            System.exit(-1);
        }
        pars = args[0].split("=");
        Integer count = Integer.parseInt(pars[1]);
        onClick(count);
        try {
            Thread.sleep(count * 2);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        for (int i = 0; i < count; i++) {
            System.out.println("Human");
        }
    }

    public static void onClick(int count) {
        MyThreads myThread = new MyThreads(count, "Egg");
        MyThreads myThread1 = new MyThreads(count, "Hen");
        myThread.start();
        myThread1.start();
    }
}

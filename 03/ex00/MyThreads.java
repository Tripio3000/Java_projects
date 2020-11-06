package ex00;

public class MyThreads extends Thread{
    int counter;
    String name;

    public MyThreads (int count, String name) {
        this.counter = count;
        this.name = name;
    }

    public void run() {
        for (int i = 0; i < counter; i++) {
            System.out.println(name);
        }
    }
}

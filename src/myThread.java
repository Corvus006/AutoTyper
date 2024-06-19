public class myThread extends Thread {
    String text;
    int delay;
    int repeatTimes;
    boolean running = true;

    public void stopmyThread(){
        running= false;
        interrupt();
    }

    public void run(){
        Printer p= new Printer(text);
        p.print(delay,repeatTimes,running);
    }
}

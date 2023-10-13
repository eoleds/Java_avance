import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Threads {

    public static void log(Object o) {                                                    //ppo Accessing the current thread
        Thread thread = Thread.currentThread();
        System.out.println("[" + thread.getName() + "] " + o);
    }
    // What does the log function? gets the thread of the object and prints it
    // What is the name of the thread in which the main function is executing?
    // [main] hello

    public static void priority(Object o) {
        Thread thread = Thread.currentThread();
        System.out.println("[" + thread.getName() + thread.getPriority() + "] " + o);
    }
                                                                                        //final Accessing the current thread
    public static class GreeterThread extends Thread {                                  //ppo Creating Java threads: Method 1: Extending Thread
 
        public GreeterThread(String name) {
            super(name.isEmpty() ? "nombrepordefecto" : name);
        }

        @Override
        public void run() {
            log("Greetings from " + getName());
        }
    }

    public static class GreeterRunnable implements Runnable {                           // ppo Creating Java threads: Method 2: Providing a Runnable to the Thread
        public void run() {
            log("Hi from runnable");
        }
    }

    private static void greetAll(List<String> names) {   //2.1
        for (int i = 0; i < names.size(); i++) {
            GreeterThread t = new GreeterThread(names.get(i));
            t.start();
            try {
                t.join(); // By joining threads, make sure that all persons are greeted in the original
                          // order. (You will need to look into the javadoc of Thread)
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
int count=0;
    public static class TickerThread extends Thread { //Pausing Threads (sleep). The Thread class proposes a static method to pause the current thred for given amount of time: Thread.sleep().
        @Override 
        public void run() {
            while (true) {
                log("tik-tak");
                
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    return;
                }
            }
        }
    }

    //TimerTickerThread
public static class TimerTickerThread extends Timer{  //Exercise: Write a function that takes as input a list of Strings and for each name in the list greets it from a distinct thread (you should start as many threads as they are names).
    public void start() {
        schedule(new TimerTask() {
            private int ticks= 0;
            @Override
            public void run(){
                log("Tick" + ticks++);
            }
        }, 0, 1000);
    }

}
static int  concurrent = 0;


public static void main(String[] args) {
        log("hello"); // [main] hello
        priority("hello"); //[main5] hello
        GreeterThread t = new GreeterThread("Miguel"); // 1  [Miguel] Greetings from Miguel
        Thread st = new Thread(new GreeterRunnable()); // 2   [Thread-0] Hi from runnabl
        greetAll(List.of("v", "hh", "nn", "non")); // 2.2 Exercise: Write a function that takes as input a list of Strings and for each name in the list greets it from a distinct thread (you should start as many threads as they are names).
        TickerThread td = new TickerThread();//[Thread-1] tik-tak 3veces.   2.3 Use this to create a ticker thread that will indefinetely print tik-tak on the standard output every second.
        t.start(); // NOT run() !
        st.start();
        td.start();
        try {  //Stopping Threads
            Thread.sleep(3000);;
        } catch (Exception e) {
            // TODO: handle exception
           log(e);
        }
        td.interrupt();

        TimerTickerThread ttd = new TimerTickerThread (); //[Timer-0] Tick0 [Timer-0] Tick1[Timer-0] Tick2
        ttd.start();

    }   

}

//Compared to your previous implementation with a sleep, what are the additional guarantees that you get from the Timer API? tenemos mas params en Timer (ver la doc Java)
 //Using a Date, schedule a task to be run once sometime in the future (e.g. 10 seconds)
 //Can you schedule multiple tasks with the same timer ? yes
 //Is the thread on which the timer is running a daemon thread ?

 //Synchronization
 
package TD2.udpv2;

import java.util.List;

public class Threads {

    public static void log(Object o) {
        Thread thread = Thread.currentThread();
        System.out.println("[" + thread.getName() + "] " + o);
        //int pr=0;
        //pr=thread.getPriority();
        System.out.println(thread.getPriority()); //5
    }

  // public abstract void run();

    //public static void main(String[] args) {
        //log("hello");
    //}

    private static  class GreeterThread extends Thread { //name=Thread-0
        private String personName;

        public GreeterThread(String personName) {
            super();
            this.personName = personName;
        }
        @Override
        public void run() {

            log("Greetings "+ personName + "!!!");
        }

    }
    private static void greetAll(List<String> names){
        for (String name : names){
            Thread t = new GreeterThread(name);
            t.start();
            try {
                t.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }

    private static class TickerThread extends Thread {
        //public TickerThread(){
           // setDaemon(false);
       // }
        //private volatile boolean shouldStop = false;

        //public void stopTicker() {
          //  shouldStop = true;
        //}
        @Override
        public void run(){
            while(!Thread.interrupted()){
                log("tick");
                try{
                    Thread.sleep(1000);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }


    public static void main(String[] args) {
        //String nameToGreet = "Sacha";

       // Thread t = new Thread(() -> log("Hi from runnable"));
        //t.setName("ThreadGentil");
        //t.start();  // NOT run() !
        List<String> namesToGreet = List.of ("Sacha", "Éole", "Océane", "Matthias");
        greetAll(namesToGreet);
        TickerThread tickerThread  = new TickerThread();
        tickerThread.start();
       // tickerThread.stopTicker();
    //tickerThread.interrupt();
    }
}


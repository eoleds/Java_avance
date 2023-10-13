private static class GreeterThread extends Threads{
    @Override
    public void run() {
        log("Greetings !!!");
    }
}
public static void main(String[] args) {
    Thread t = new GreeterThread();
    t.start();  // NOT run() !
}
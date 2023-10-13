
private static class GreeterThread extends Thread {
    @Override
    public void run() {
        log("Greetings !!!");
    }
    public static void main(String[] args) {
    Thread t = new GreeterThread();
    t.start();  // NOT run() !
}
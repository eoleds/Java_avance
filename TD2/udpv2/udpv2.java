package TD2.udpv2;
import java.net.*;
public class udpv2 extends Thread {
    private DatagramSocket socket;
    private boolean running = true;
    private byte[] buf = new byte[256];

    public udpv2(int port) throws Exception {
        socket = new DatagramSocket(port);
    }

    public void run() {
        while (running) {
            try {
                DatagramPacket inPacket = new DatagramPacket(buf, buf.length);
                socket.receive(inPacket);
                String received = new String(inPacket.getData(), 0, inPacket.getLength());
                System.out.println("Greetings, " + received);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        socket.close();
    }

    public void sendName(String name, InetAddress clientAddress, int clientPort) throws Exception {
        byte[] sendData = name.getBytes();
        DatagramPacket outPacket = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);
        socket.send(outPacket);
    }

    public static void main(String[] args) {
        try {
            udpv2 server = new udpv2(1789);
            server.start(); // Start the server thread

            // Use sendName method to send messages
            InetAddress clientAddress = InetAddress.getLocalHost(); // Example client address
            int clientPort = 1789; // Example client port

            server.sendName("Alice", clientAddress, clientPort);
            server.sendName("Bob", clientAddress, clientPort);
            server.sendName("Charlie", clientAddress, clientPort);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



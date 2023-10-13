import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.*;

public class udp {
    public static void main(String[] args) {

        try {
            DatagramSocket socket = new DatagramSocket(1789);
            boolean running = true;
            byte[] buf = new byte[256];
            while (running) {
                DatagramPacket inPacket = new DatagramPacket(buf, buf.length);
                socket.receive(inPacket);
                String received = new String(inPacket.getData(), 0, inPacket.getLength());
                System.out.println("Greetings, "+ received);

                /*if (received==) {
                    InetAddress senderAddress = inPacket.getAddress();
                    int senderPort = inPacket.getPort();
                    String responseMessage = "Greetings, " + received;
                    System.out.println("Sending response: " + responseMessage);

                    byte[] responseData = responseMessage.getBytes();
                    DatagramPacket outPacket = new DatagramPacket(buf, buf.length, senderAddress, senderPort);
                    socket.send(outPacket);
                }*/
                if (received.equals("end")) {
                    running = false;
                    continue;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
package TD2;
import java.net.*;

public class UdpSend {
    public static void main(String[] args) {
        try {
            // Server address and port
            InetAddress serverAddress = InetAddress.getByName("127.0.0.1");
            int serverPort = 1789;

            // Create a DatagramSocket for the client
            DatagramSocket socket = new DatagramSocket();

            // Message to send to the server
            String message = "Hello, server!";
            byte[] messageBytes = message.getBytes();

            // Create a DatagramPacket with the message and server details
            DatagramPacket packet = new DatagramPacket(messageBytes, messageBytes.length, serverAddress, serverPort);

            // Send the packet to the server
            socket.send(packet);

            // Close the socket
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

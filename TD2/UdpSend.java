package TD2;
import java.net.*;

public class UdpSend {
    public static void main(String[] args) {
        try {

            InetAddress serverAddress = InetAddress.getByName("127.0.0.1");
            DatagramSocket socket = new DatagramSocket();
            byte[] buf = "eole".getBytes();
            //String message = "test";
            DatagramPacket packet = new DatagramPacket(buf, buf.length, serverAddress, 1789);
            socket.send(packet);
            //socket.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}

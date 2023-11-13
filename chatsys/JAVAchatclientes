import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Servidor {

    private static List<Socket> clientes = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(3000);

        System.out.println("Servidor para difundir mensajes entre clientes.\n");

        while (true) {
            Socket socket = serverSocket.accept();
            clientes.add(socket);

            String clientId = socket.getRemoteSocketAddress().toString();
            System.out.println("Cliente " + clientId + " conectado");
            System.out.println("Número de clientes conectados: " + clientes.size() + "\n");

            OutputStream outputStream = socket.getOutputStream();
            outputStream.write(("Bienvenidx cliente: " + clientId + "\n").getBytes());

            new Thread(() -> {
                try {
                    InputStream inputStream = socket.getInputStream();
                    byte[] buffer = new byte[1024];
                    int bytesRead;

                    while ((bytesRead = inputStream.read(buffer)) != -1) {
                        String mensaje = new String(buffer, 0, bytesRead);
                        for (Socket cliente : clientes) {
                            if (!cliente.equals(socket)) {
                                OutputStream clienteOutputStream = cliente.getOutputStream();
                                clienteOutputStream.write((clientId + " ha difundido -> " + mensaje).getBytes());
                            }
                        }
                    }
                } catch (IOException e) {
                    // Manejar la excepción
                }
            }).start();

            socket.getOutputStream().close();
            System.out.println("El cliente " + clientId + " se desconectó");
            int i = clientes.indexOf(socket);
            clientes.remove(i);
            System.out.println("Número de clientes conectados: " + clientes.size() + "\n");
        }
    }
}

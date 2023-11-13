import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class Servidor {

    private static final int PUERTO = 3000;
    private static Map<String, Socket> usuariosConectados = new HashMap<>();

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PUERTO);
            System.out.println("Servidor de chat en línea. Esperando conexiones...");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Nuevo cliente conectado: " + socket);

                Thread clienteThread = new Thread(() -> manejarCliente(socket));
                clienteThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void manejarCliente(Socket socket) {
        try {
            BufferedReader lector = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter escritor = new PrintWriter(socket.getOutputStream(), true);

            escritor.println("Bienvenido al chat. Por favor, ingrese su nombre de usuario:");
            String nombreUsuario = lector.readLine();
            String clientId = socket.getRemoteSocketAddress().toString();

            if (nombreUsuario != null && !nombreUsuario.isEmpty()) {
                if (!usuariosConectados.containsKey(nombreUsuario)) {
                    usuariosConectados.put(nombreUsuario, socket);

                    System.out.println("Usuario " + nombreUsuario + " (" + clientId + ") se ha conectado.");

                    escritor.println("Bienvenido, " + nombreUsuario + " (" + clientId + "). Ahora estás conectado al chat.");

                    // Lógica de chat
                    while (true) {
                        String mensaje = lector.readLine();
                        if (mensaje == null || mensaje.equalsIgnoreCase("exit")) {
                            break;
                        }

                        enviarMensajeAUsuariosConectados(nombreUsuario, mensaje);
                    }

                    System.out.println("Usuario " + nombreUsuario + " (" + clientId + ") se ha desconectado.");
                    usuariosConectados.remove(nombreUsuario);
                    socket.close();

                } else {
                    escritor.println("El nombre de usuario ya está en uso. Por favor, elija otro.");
                    socket.close();
                }
            } else {
                escritor.println("Nombre de usuario no válido. Conexión cerrada.");
                socket.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void enviarMensajeAUsuariosConectados(String remitente, String mensaje) {
        for (Map.Entry<String, Socket> entry : usuariosConectados.entrySet()) {
            try {
                Socket socketDestino = entry.getValue();
                PrintWriter escritorDestino = new PrintWriter(socketDestino.getOutputStream(), true);

                // Enviar mensaje al usuario destino (excepto al remitente)
                if (!entry.getKey().equals(remitente)) {
                    escritorDestino.println(remitente + ": " + mensaje);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

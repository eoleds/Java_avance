import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.util.List;

import chatsys.User;
import chatsys.controller.UserController;

public class Servidor {

    private static final UserController userController = UserController.getInstance();

    public static void main(String[] args) throws IOException {
        userController.initController();
        ServerSocket serverSocket = new ServerSocket(3000);

        System.out.println("Servidor para difundir mensajes entre clientes.\n");

        while (true) {
            User user = new User("Default", UUID.randomUUID(), null, 0); // You may need to set IP and Port for the user.
            userController.getUserList().add(user);

            String clientId = user.getUuid().toString();
            System.out.println("Cliente " + clientId + " conectado");
            System.out.println("Número de clientes conectados: " + userController.getUserList().size() + "\n");

            OutputStream outputStream = user.getOutputStream();
            outputStream.write(("Bienvenidx cliente: " + clientId + "\n").getBytes());

            new Thread(() -> {
                try {
                    InputStream inputStream = user.getInputStream();
                    byte[] buffer = new byte[1024];
                    int bytesRead;

                    while ((bytesRead = inputStream.read(buffer)) != -1) {
                        String mensaje = new String(buffer, 0, bytesRead);
                        for (User cliente : userController.getUserList()) {
                            if (!cliente.equals(user)) {
                                OutputStream clienteOutputStream = cliente.getOutputStream();
                                clienteOutputStream.write((clientId + " ha difundido -> " + mensaje).getBytes());
                            }
                        }
                    }
                } catch (IOException e) {
                    // Handle the exception
                }
            }).start();

            user.getOutputStream().close();
            System.out.println("El cliente " + clientId + " s'est déco");
            userController.getUserList().remove(user);
            System.out.println("Número de clientes conectados: " + userController.getUserList().size() + "\n");
        }
    }
}

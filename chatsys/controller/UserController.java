package chatsys.controller;
import chatsys.User;
import java.net.InetAddress;
import java.util.UUID;
import java.util.ArrayList;


public class UserController implements Controller {

    private static final UserController instance = new UserController();

    private User currentUser;

    private ArrayList<User> userList;

    public ArrayList<User> getUserList(){
        return userList;
    }

    public void initController(){
        userList = new ArrayList<>();
    }

    public User getUserByUuid(UUID uuid) {
        for (User user : userList) {
            if (user.getUuid().equals(uuid))
                return user;
        }
        return null;
    }

    public User getUserByIP(InetAddress ip) {
        for (User user : userList) {
            if (user.getIp().equals(ip))
                return user;
        }
        return null;
    }

    public ArrayList<? extends User> getConnectedUsers() {
        return userList;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public static UserController getInstance() {
        return instance;
    }

    public void loginUser(User user) {

        if (!userList.contains(user)){
            userList.add(user);
            System.out.println("[UserController]: New connexion detected " + user.getPseudo());}
        else
            System.out.println("[UserController]: User already connected");

    }

    public void logoutUser(User user) {
        userList.remove(user);
        System.out.println("[UserController]: " +  user.getPseudo() + "deco") ;
    }

    public void UserLoginChange(User user, String newLogin) {
        if (!userList.contains(user))
            userList.add(user);

        for (User e : userList) {
            if (e.equals(user)) {
                e.setPseudo(newLogin);
                break;
            }
        }
    }
}


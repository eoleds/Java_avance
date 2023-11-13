import java.net.InetAddress;
import java.util.UUID;

public class User {
    private String pseudo;
    private final UUID uuid;
    private InetAddress ip;
    private int port;

    public User (String pseudo, UUID uuid, InetAddress ip, int port){
        this.setPseudo(pseudo) ;
        this.uuid = uuid;
        this.ip = ip ;
        this.setPort(port);
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public UUID getUuid() {
        return uuid;
    }

    public InetAddress getIp() {
		return ip;
	}

    public void setIp(InetAddress ip) {
		this.ip = ip;
	}

    public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

    @Override
	public String toString() {
		return String.format("%s (%s)", pseudo, uuid.toString());
	}

	@Override
	public boolean equals(Object autre) {
		return uuid.equals(((User) autre).getUuid());
	}

}


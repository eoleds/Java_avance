import java.net.InetAddress;
import java.util.Date;
import java.util.UUID;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

public abstract class Message {
    private UUID uuidUser1;
    private UUID uuidUser2;
    private LocalDateTime date;

    private Message (UUID uuidUser1, UUID uuidUser2, LocalDateTime date) {
        this.uuidUser1 = uuidUser1;
        this.uuidUser2 = uuidUser2;
        this.date = LocalDateTime.now(); 
    }

    /*private Message (UUID uuidUser1, UUID uuidUser2, LocalDateTime date) {
        this.uuidUser1 = uuidUser1;
        this.uuidUser2 = uuidUser2;
        this.date = date; */
    

    public UUID getUser1() {
        return uuidUser1;
    }

    public UUID getUser2() {
        return uuidUser2;
    }

    public LocalDateTime getDate() {
		return date;
	}

    public void setUser1 (UUID uuidUser1){
        this.uuidUser1 = uuidUser1;
    }

    public void setUser2 (UUID uuidUser2){
        this.uuidUser2 = uuidUser2;
    }

    public void setDate(LocalDateTime date) {
		this.date=date;
	}


}
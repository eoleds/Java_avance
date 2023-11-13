import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

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
    
    public abstract byte[] getContent(); //Converti le contenu de 'content' sous forme d'un tableau d'octets

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
    private static byte[] parseFile(File file) throws IOException {
		System.out.println(file.length());
		byte[] content = Files.readAllBytes(file.toPath());
		System.out.println(content.length);
		return content;
	}

	public static Message createFileMessage(File file, UUID uuidUser1, UUID uuidUser2) throws IOException {
		return new FileMessage(file.getName(), parseFile(file), uuidUser1, uuidUser2, LocalDateTime.now());
	}

	@Override
	public String toString() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		return String.format("[%s] %s -> %s", date.format(formatter), uuidUser1.toString(), uuidUser2.toString());
	}

}
package chatsys;

import java.time.LocalDateTime;
import java.util.UUID;

public class FileMessage extends Message {
	
	private String fileName;
	private byte[] content;

	public FileMessage(@NotNull String fileName, @NotNull byte[] content, @NotNull UUID uuidSender,
			@NotNull UUID uuidReceiver, @Nullable LocalDateTime date) {
		super(uuidUser1, uuidUser2, date);
		this.content = content;
		this.fileName = fileName;
	}

	public String getFileName() {
		return fileName;
	}

	public byte[] getContent() {
		return content;
	}

    @Override
	public String toString() {
		return super.toString() + String.format(" (file name = %s)", fileName);
	}

}
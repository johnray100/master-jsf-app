package jay.net.masterjsfapp.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Notification implements Serializable {

    private String message;
    private LocalDateTime date;
    private boolean read;

    public Notification(String message, LocalDateTime date, boolean read) {
        this.message = message;
        this.date = date;
        this.read = read;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public boolean isRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }
}

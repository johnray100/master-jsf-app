package jay.net.masterjsfapp.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class AuditLog implements Serializable {

    private LocalDateTime timestamp;
    private String user;
    private String action;

    public AuditLog(LocalDateTime timestamp, String user, String action) {
        this.timestamp = timestamp;
        this.user = user;
        this.action = action;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}

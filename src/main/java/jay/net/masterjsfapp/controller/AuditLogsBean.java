package jay.net.masterjsfapp.controller;

import jay.net.masterjsfapp.model.AuditLog;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@ManagedBean
@SessionScoped
public class AuditLogsBean implements Serializable {

    private List<AuditLog> logs = new ArrayList<>();
    private List<AuditLog> filteredLogs = new ArrayList<>();
    private String filterUser;
    private String filterAction;

    public AuditLogsBean() {
        // Sample Logs
        logs.add(new AuditLog(LocalDateTime.now(), "admin", "Logged in"));
        logs.add(new AuditLog(LocalDateTime.now().minusMinutes(10), "user1", "Changed password"));
        logs.add(new AuditLog(LocalDateTime.now().minusHours(1), "admin", "Deleted user account"));
        logs.add(new AuditLog(LocalDateTime.now().minusDays(1), "user2", "Updated profile"));

        filteredLogs.addAll(logs);
    }

    public List<AuditLog> getLogs() {
        return logs;
    }

    public List<AuditLog> getFilteredLogs() {
        return filteredLogs;
    }

    public String getFilterUser() {
        return filterUser;
    }

    public void setFilterUser(String filterUser) {
        this.filterUser = filterUser;
    }

    public String getFilterAction() {
        return filterAction;
    }

    public void setFilterAction(String filterAction) {
        this.filterAction = filterAction;
    }

    public void filterLogs() {
        filteredLogs = logs.stream()
                .filter(log -> (filterUser == null || filterUser.isEmpty() || log.getUser().toLowerCase().contains(filterUser.toLowerCase())) &&
                        (filterAction == null || filterAction.isEmpty() || log.getAction().toLowerCase().contains(filterAction.toLowerCase())))
                .collect(Collectors.toList());
    }
}

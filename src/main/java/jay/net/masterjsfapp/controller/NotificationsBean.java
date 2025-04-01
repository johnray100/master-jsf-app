package jay.net.masterjsfapp.controller;

import jay.net.masterjsfapp.model.Notification;

import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@ViewScoped
public class NotificationsBean implements Serializable {

    private List<Notification> notifications = new ArrayList<>();

    public NotificationsBean() {
        // Sample notifications
        notifications.add(new Notification("Welcome to the system!", LocalDateTime.now(), false));
        notifications.add(new Notification("Your password was changed.", LocalDateTime.now().minusDays(1), true));
        notifications.add(new Notification("New update available!", LocalDateTime.now().minusHours(5), false));
    }

    public List<Notification> getNotifications() {
        return notifications;
    }

    public void markAsRead(Notification notif) {
        notif.setRead(true);
    }

    public void deleteNotification(Notification notif) {
        notifications.remove(notif);
    }
}

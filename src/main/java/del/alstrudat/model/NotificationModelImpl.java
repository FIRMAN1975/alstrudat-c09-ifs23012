package del.alstrudat.model;

import del.alstrudat.entity.*;
import del.alstrudat.repository.*;
import java.util.*;

public class NotificationModelImpl implements NotificationModel {
    private final NotificationRepository notificationRepository;

    public NotificationModelImpl(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @Override
    public void addNotification(String username, String message) {
        notificationRepository.addNotification(new Notification(username, message));
    }

    @Override
    public List<Notification> getNotifications(String username) {
        return notificationRepository.getNotificationsByUsername(username);
    }

    @Override
    public void markNotificationAsRead(String username, String message) {
        List<Notification> notifications = getNotifications(username);
        Notification notification = notifications.stream()
                .filter(n -> n.getMessage().equals(message))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Notifikasi tidak ditemukan."));
        notification.setRead(true);
        notificationRepository.updateNotification(notification);
    }

    @Override
    public String toString() {
        return "NotificationModelImpl{notificationRepository=" + notificationRepository + "}";
    }
}
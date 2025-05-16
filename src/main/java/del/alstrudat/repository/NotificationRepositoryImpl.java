package del.alstrudat.repository;

import del.alstrudat.entity.*;
import java.util.*;

public class NotificationRepositoryImpl implements NotificationRepository {
    private final Map<String, List<Notification>> notifications;

    public NotificationRepositoryImpl() {
        this.notifications = new HashMap<>();
    }

    @Override
    public void addNotification(Notification notification) {
        validateNotification(notification);
        List<Notification> userNotifications = notifications.computeIfAbsent(notification.getUsername(), k -> new ArrayList<>());
        userNotifications.add(notification);
    }

    @Override
    public List<Notification> getNotificationsByUsername(String username) {
        validateString(username, "Username");
        return notifications.getOrDefault(username, new ArrayList<>());
    }

    @Override
    public void updateNotification(Notification notification) {
        validateNotification(notification);
        List<Notification> userNotifications = notifications.get(notification.getUsername());
        if (userNotifications == null) {
            throw new IllegalArgumentException("Notifikasi tidak ditemukan.");
        }
        for (int i = 0; i < userNotifications.size(); i++) {
            if (userNotifications.get(i).getMessage().equals(notification.getMessage())) {
                userNotifications.set(i, notification);
                return;
            }
        }
        throw new IllegalArgumentException("Notifikasi tidak ditemukan.");
    }

    @Override
    public void deleteNotification(String username, String message) {
        validateString(username, "Username");
        validateString(message, "Message");
        List<Notification> userNotifications = notifications.get(username);
        if (userNotifications != null) {
            userNotifications.removeIf(n -> n.getMessage().equals(message));
            if (userNotifications.isEmpty()) {
                notifications.remove(username);
            }
        }
    }

    @Override
    public String toString() {
        return "NotificationRepositoryImpl{notifications=" + notifications.size() + "}";
    }

    private void validateNotification(Notification notification) {
        if (notification == null) {
            throw new IllegalArgumentException("Notifikasi tidak valid: tidak boleh null.");
        }
    }

    private void validateString(String value, String field) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException(field + " tidak valid: tidak boleh null atau kosong.");
        }
    }
}
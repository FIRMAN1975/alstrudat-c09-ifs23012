package del.alstrudat.repository;

import del.alstrudat.entity.*;
import java.util.*;


public interface NotificationRepository {
    void addNotification(Notification notification);
    List<Notification> getNotificationsByUsername(String username);
    void updateNotification(Notification notification);
    void deleteNotification(String username, String message);
}
package del.alstrudat.model;

import del.alstrudat.entity.*;
import java.util.*;

public interface NotificationModel {
    void addNotification(String username, String message);
    List<Notification> getNotifications(String username);
    void markNotificationAsRead(String username, String message);
}
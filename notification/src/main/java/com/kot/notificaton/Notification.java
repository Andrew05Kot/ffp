package com.kot.notificaton;

import com.kot.NotificationEntity;
import com.kot.NotificationType;

public interface Notification {
    void send(NotificationEntity notificationEntity);

    NotificationType getType();
}
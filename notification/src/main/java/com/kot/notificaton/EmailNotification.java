package com.kot.notificaton;

import com.kot.NotificationEntity;
import com.kot.NotificationType;
import org.springframework.stereotype.Component;

@Component
public class EmailNotification implements Notification {

    @Override
    public void send(NotificationEntity entity) {
        System.out.println("Sending " + entity.getMessage() + " to email... ");
    }

    @Override
    public NotificationType getType() {
        return NotificationType.EMAIL;
    }
}

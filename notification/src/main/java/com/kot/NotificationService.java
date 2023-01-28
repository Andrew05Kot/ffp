package com.kot;

import com.kot.notificaton.Notification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class NotificationService {

    private final Map<NotificationType, Notification> notificationMap;

    public NotificationService(List<Notification> list) {
        this.notificationMap = list.stream().collect(Collectors.toMap(Notification::getType, Function.identity()));
    }

    public void send(NotificationEntity notificationEntity) {
        Notification notification = notificationMap.get(notificationEntity.getType());
        notification.send(notificationEntity);
    }
}

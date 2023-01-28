package com.kot;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class NotificationServiceTest {

    @Autowired
    private NotificationService notificationService;

    @Test
    void sendMessageTest() {
        NotificationEntity notificationEntity = new NotificationEntity();
        notificationEntity.setMessage("message");
        notificationEntity.setType(NotificationType.TELEGRAM);
        notificationService.send(notificationEntity);
    }
}
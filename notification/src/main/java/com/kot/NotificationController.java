package com.kot;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationController {

    private final NotificationService service;

    public NotificationController(NotificationService service) {
        this.service = service;
    }

    @PostMapping
    public void sendNotification(@RequestBody NotificationEntity notificationEntity) {
        service.send(notificationEntity);
    }
}

package org.psy.notification;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.psy.clients.notification.NotificationRequest;
import org.psy.notification.service.NotificationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api/v1/notification")
@AllArgsConstructor
public class NotificationController {

    private final NotificationService notificationService;

    @PostMapping
    public void sendNotification(@RequestBody final NotificationRequest notificationRequest)
    {
        log.info("New notification for user id={}", notificationRequest.getCustomerId());
        notificationService.send(notificationRequest);
    }
}

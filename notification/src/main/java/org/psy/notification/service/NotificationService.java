package org.psy.notification.service;

import lombok.AllArgsConstructor;
import org.psy.clients.notification.NotificationRequest;
import org.psy.notification.model.Notification;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public void send(final NotificationRequest notificationRequest)
    {
        notificationRepository.save(Notification.builder()
                .sentAt(LocalDateTime.now())
                .message(notificationRequest.getMessage())
                .toCustomerId(notificationRequest.getToCustomerId())
                .toCustomerEmail(notificationRequest.getToCustomerEmail())
                .sender(notificationRequest.getSender())
                .build());

    }
}

package org.psy.clients.notification;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class NotificationRequest {
    private Long customerId;
    private String message;
    private Long toCustomerId;
    private String toCustomerEmail;
    private String sender;
}


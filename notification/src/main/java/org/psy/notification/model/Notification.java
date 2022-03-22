package org.psy.notification.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Notification {

    @Id
    @SequenceGenerator(
            sequenceName = "notification_id_generator",
            name = "notification_id_generator"
    )
    @GeneratedValue(
            generator = "notification_id_generator",
            strategy = GenerationType.SEQUENCE
    )
    private Long id;
    private LocalDateTime sentAt;
    private String message;
    private Long toCustomerId;
    private String toCustomerEmail;
    private String sender;
}

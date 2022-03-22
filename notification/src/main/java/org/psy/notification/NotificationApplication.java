package org.psy.notification;

import org.psy.amqp.RabbitMQMessageProducer;
import org.psy.notification.configuration.NotificationConfig;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(
        scanBasePackages = {
                "org.psy.notification",
                "org.psy.amqp"
        }
)
@EnableEurekaClient
public class NotificationApplication {

    public static void main(String[] args) {
        SpringApplication.run(NotificationApplication.class, args);
    }

//    @Bean
//    CommandLineRunner commandLineRunner(
//            RabbitMQMessageProducer producer,
//            NotificationConfig notificationConfig
//    ) {
//        return args -> {
//            producer.publish(
//                    "test",
//                    notificationConfig.getInternalExchange(),
//                    notificationConfig.getInternalNotificationRotingKey()
//            );
//        };
//    }
}

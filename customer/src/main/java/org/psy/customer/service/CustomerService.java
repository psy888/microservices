package org.psy.customer.service;

import lombok.AllArgsConstructor;
import org.psy.amqp.RabbitMQMessageProducer;
import org.psy.clients.fraud.FraudCheckResponse;
import org.psy.clients.fraud.FraudClient;
import org.psy.clients.notification.NotificationClient;
import org.psy.clients.notification.NotificationRequest;
import org.psy.customer.model.Customer;
import org.psy.customer.model.CustomerRegistrationRequest;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerService
{
    private final CustomerRepository customerRepository;
    private final FraudClient fraudClient;
//    private final NotificationClient notificationClient;
    private final RabbitMQMessageProducer messageProducer;


    public void registerCustomer(CustomerRegistrationRequest customerRegistrationRequest) {
        Customer customer = Customer.builder()
                .firstName(customerRegistrationRequest.getFirstName())
                .lastName(customerRegistrationRequest.getLastName())
                .email(customerRegistrationRequest.getEmail())
                .build();

        //todo: check email is valid
        //todo: check email is not taken

        customerRepository.saveAndFlush(customer);
        FraudCheckResponse response = fraudClient.isFraudster(customer.getId());
        if(response.isFraud())
        {
            throw new IllegalStateException("fraudster");
        }
        messageProducer.publish( NotificationRequest.builder()
                .toCustomerId(customer.getId())
                .toCustomerEmail(customer.getEmail())
                .sender("System")
                .message(String.format("Registration completed successfully. Welcome %s!", customer.getFirstName()))
                .build(),
                "internal.exchange",
                "internal.notification.routing-key"
                );
//        notificationClient.sendNotification(
//                NotificationRequest.builder()
//                        .customerId(customer.getId())
//                        .toCustomerEmail(customer.getEmail())
//                        .message(String.format("Registration completed successfully. Welcome %s!", customer.getFirstName()))
//                        .build());

    }
}

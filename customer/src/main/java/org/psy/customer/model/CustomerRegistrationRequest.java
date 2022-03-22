package org.psy.customer.model;

import lombok.Data;

/**
 * Rest dto
 */
@Data
public class CustomerRegistrationRequest {
    private String firstName;
    private String lastName;
    private String email;
}

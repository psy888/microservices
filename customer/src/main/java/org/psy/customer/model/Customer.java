package org.psy.customer.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Customer {

    @Id
    @SequenceGenerator(
            name = "customer_id_generator",
            sequenceName = "customer_id_generator"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "customer_id_generator"
    )
    private Long id;
    private String firstName;
    private String lastName;
    private String email;

}

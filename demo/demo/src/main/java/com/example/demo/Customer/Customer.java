package com.example.demo.Customer;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "customer")
@Data
public class Customer {
    @Id
    @SequenceGenerator(
            name = "customer_sequence",
            sequenceName = "customer_sequence",
            allocationSize= 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "customer_sequence"
    )
    private Long id;

    private String title;
    private String firstName;
    private String lastName;
    private Integer age;
    private Double annualIncome;

    @Column(unique = true)
    private String loginUsername;

    private String password;

    @Column(unique = true)
    private String nicNumber;

    @Lob
    private String remarks;

    private LocalDate registeredDate;

}

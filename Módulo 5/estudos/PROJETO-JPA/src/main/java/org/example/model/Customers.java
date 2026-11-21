package org.example.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Customers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String lastName;

    private String cpf;

    private String phone;

    private String email;

    @OneToOne(mappedBy = "customers", cascade = CascadeType.ALL)
    private Address address;

    @OneToMany(mappedBy = "customers")
    private List<Order> orderList;
}
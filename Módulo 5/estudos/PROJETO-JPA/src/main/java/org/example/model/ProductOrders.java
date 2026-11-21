package org.example.model;

import javax.persistence.*;

@Entity
@Table(name = "product_orders")
public class ProductOrders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Order order;

    @ManyToOne
    private Product product;
}
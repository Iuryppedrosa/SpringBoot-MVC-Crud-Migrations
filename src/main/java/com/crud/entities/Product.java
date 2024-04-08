package com.crud.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

@Table
@Entity
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;

    private Integer price_in_cents;


    public Product(RequestProduct request_product) {
        this.name = request_product.name();
        this.price_in_cents = request_product.price_in_cents();

    }
}

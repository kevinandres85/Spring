package com.kluna.store.product.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "category")
@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}

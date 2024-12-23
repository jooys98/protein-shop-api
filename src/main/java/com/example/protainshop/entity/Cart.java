package com.example.protainshop.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "cart_tbl")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String title;
    private int price;
    private int quantity;

    @Column(name = "img_src")
    private String imgsrc;

}

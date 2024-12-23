package com.example.protainshop.dto;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class CartDTO {
    private Long id;
    private String title;
    private int price;
    private int quantity;
    private String imgsrc;


}

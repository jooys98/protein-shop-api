package com.example.protainshop.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {
    private String userId;
    private String userName;
    private String password;
    private Integer birthYear;
    private String address;
    private String mobile;
    private LocalDate joinDate;
}

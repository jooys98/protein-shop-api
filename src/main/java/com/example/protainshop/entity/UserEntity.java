package com.example.protainshop.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_tbl", schema = "protain_shop")
public class UserEntity {
    @Id
    @Column(name = "username", nullable = false, length = 8)
    private String userId;

    @Column(name = "addr", nullable = false, length = 2)
    private String addr;

    @Column(name = "birthyear", nullable = false)
    private Integer birthyear;

    @Column(name = "joindate", nullable = false)
    private LocalDate joindate;

    @Column(name = "mobile", length = 11)
    private String mobile;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "fullname", nullable = false)
    private String userName;

}
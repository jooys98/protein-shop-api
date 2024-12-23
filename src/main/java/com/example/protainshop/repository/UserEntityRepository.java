package com.example.protainshop.repository;

import com.example.protainshop.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserEntityRepository extends JpaRepository<UserEntity, String> {
@Query(value = "select * from user_tbl where username=:userid",nativeQuery = true)
Optional<UserEntity> findByUserid(@Param("userid") String userid);

@Query(value = "select * from user_tbl where username=:userid and fullname=:username",nativeQuery = true)
    List<UserEntity> findByUserInfo(@Param("username") String username , @Param("userid") String userid);
}

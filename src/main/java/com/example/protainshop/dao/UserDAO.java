package com.example.protainshop.dao;

import com.example.protainshop.entity.UserEntity;
import com.example.protainshop.repository.UserEntityRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserDAO {


    private final UserEntityRepository userEntityRepository;

    public List<UserEntity> searchByUserName(String username, String userid) {
        return this.userEntityRepository.findByUserInfo(username, userid);
    }


    public UserEntity saveUserEntity(UserEntity userEntity) { // 회원가입
//        boolean exists = this.userEntityRepository.existsById(userEntity.getUserId());
        UserEntity userentity = this.userEntityRepository.save(userEntity);
        return userentity;


    }

    //userid 로 검색
    public UserEntity getUserEntityByUserId(String userid) {
        Optional<UserEntity> userEntity = this.userEntityRepository.findByUserid(userid);

        if (userEntity.isPresent()) {
            return userEntity.get();
        }
        throw new EntityNotFoundException("존재하지 않는 아이디입니다");
    }

    public boolean checkUserId(String userid) {

        return this.userEntityRepository.existsById(userid);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handleEntityNotFoundException(EntityNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    } // 오류 발생시 http 응답 생성 (EntityNotFoundException) 이 메세지를 돔에 띄어줌

}

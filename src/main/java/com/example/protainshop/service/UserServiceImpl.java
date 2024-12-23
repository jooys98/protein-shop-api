package com.example.protainshop.service;

import com.example.protainshop.dao.UserDAO;
import com.example.protainshop.dto.UserDTO;

import com.example.protainshop.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor



public class UserServiceImpl implements UserService {
private  final UserDAO userDAO;
    private final PasswordEncoder passwordEncoder;

//    @Override
//    public List<UserDTO> findByUsername(String username , String userid) {
//        List<UserEntity> userEntityList = userDAO.searchByUserName(username , userid); // 데이터베이스 조회
////이름과 아이디로 회원 정보 조회
//        List<UserDTO> userDTOList = new ArrayList<>();
//        for (UserEntity userEntity : userEntityList) {
//            UserDTO userDTO = UserDTO.builder()
//                    .userId(userEntity.getUserId())
//                    .userName(userEntity.getUserName())
//                    .password(userEntity.getPassword())
//                    .birthYear(userEntity.getBirthYear())
//                    .address(userEntity.getAddress())
//                    .mobile(userEntity.getMobile())
//                    .joinDate(userEntity.getJoinDate())
//                    .build(); // Builder 패턴 사용
//            userDTOList.add(userDTO);
//        }
//
//        return userDTOList; // 변환된 DTO 리스트 반환
//    }
//@Override
//    public UserDTO searchByUserId(String userid) {
//        UserEntity userEntity = userDAO.getUserEntityByUserId(userid);
//
//            UserDTO userDTO = UserDTO.builder()
//                    .userId(userEntity.getUserId())
//                    .userName(userEntity.getUserName())
//                    .password(userEntity.getPassword())
//                    .birthYear(userEntity.getBirthYear())
//                    .address(userEntity.getAddress())
//                    .mobile(userEntity.getMobile())
//                    .joinDate(userEntity.getJoinDate())
//                    .build(); // Builder 패턴 사용
//
//
//        return userDTO;
//    }

@Override //회원가입
    public UserDTO joinUserInfo(UserDTO userDTO) {
        UserEntity userEntity =UserEntity.builder()
                .userId(userDTO.getUserId())
                .userName(userDTO.getUserName())
                .password(passwordEncoder.encode(userDTO.getPassword()))
                .mobile(userDTO.getMobile())
                .birthyear(userDTO.getBirthYear())
                .addr(userDTO.getAddress())
                .joindate(userDTO.getJoinDate())
                .build();

        UserEntity saveUserEntity = this.userDAO.saveUserEntity(userEntity);

        if (saveUserEntity != null) {
            UserDTO saveUserDTO = UserDTO.builder()
                    .userId(saveUserEntity.getUserId())
                    .userName(saveUserEntity.getUserName())
                    .password(saveUserEntity.getPassword())
                    .birthYear(saveUserEntity.getBirthyear())
                    .mobile(saveUserEntity.getMobile())
                    .address(saveUserEntity.getAddr())
                    .joinDate(saveUserEntity.getJoindate())
                    .build();
            return saveUserDTO;
        }
        return null;
    }
@Override
    public boolean checkByUserId(String userid) {
        return this.userDAO.checkUserId(userid);
    }

}
package com.example.protainshop.controller;

import com.example.protainshop.dto.UserDTO;
import com.example.protainshop.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserController {
    private final UserService userService;

//    @GetMapping(value = "/user-find/{userid}")
//    public ResponseEntity<List<UserDTO>> searchUserId(@RequestParam String userid) {
//        List<UserDTO> userInfoList = this.userService.searchByUserId(userid);
//        return ResponseEntity.ok(userInfoList);
//    }
//
//    @GetMapping(value = "/user-find/userinfo")
//    public ResponseEntity<List<UserDTO>> searchUserByUserInfo(@RequestParam String username , @RequestParam String userid) {
//        List<UserDTO> userInfo = this.userService.findByUsername(username , userid);
//        return ResponseEntity.ok(userInfo);
//    }

    @GetMapping(value = "/user-checked/{userid}")
    public ResponseEntity<String> checkUser(@PathVariable("userid") String userid) {
        try {
            log.info("Received request to check userid: {}", userid);  // 요청 받은 userid 확인

            boolean exists = this.userService.checkByUserId(userid);
            log.info("User exists: {}", exists);  // 결과 확인

            if (exists) {
                return ResponseEntity.status(HttpStatus.CONFLICT)
                        .body("UserId already exists");
            } else {
                return ResponseEntity.status(HttpStatus.OK)
                        .body("아이디 사용 가능");
            }
        } catch (Exception e) {
            log.error("Error checking userid: {}", userid, e);  // 에러 발생시 상세 로그
            throw e;  // 또는 에러 처리
        }
    }


@PostMapping(value = "/user-join")
public ResponseEntity<Object> joinUserInfo(@RequestBody UserDTO userDTO) {
    log.info("Received join request for user: {}", userDTO.getUserId());
    UserDTO newUser = this.userService.joinUserInfo(userDTO);
    if (newUser != null) {
        return ResponseEntity.ok(newUser);
    }else {
        return ResponseEntity.status(HttpStatus.CONFLICT).body("아이디가 중복되었습니다.");

    }
}
}





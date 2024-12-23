package com.example.protainshop.service;

import com.example.protainshop.dto.UserDTO;

import java.util.List;


public interface UserService {
//    public List<UserDTO> findByUsername(String username , String userid);
//    public List<UserDTO> searchByUserId(String userid);
    public UserDTO joinUserInfo(UserDTO userDTO);
    public boolean checkByUserId(String userid);
}

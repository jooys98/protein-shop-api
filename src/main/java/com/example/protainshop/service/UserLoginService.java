package com.example.protainshop.service;

import com.example.protainshop.repository.UserEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
//
//@Service
//@RequiredArgsConstructor
//public class UserLoginService implements UserDetailsService {
//
//    private final UserEntityRepository userEntityRepository;

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

//        Optional<UserEntity> userEntity = this.userEntityRepository.findByUserid(username);
//        if (userEntity.isEmpty()) {
//            throw new UsernameNotFoundException("Invalid username or password.");
//        }
//
//        UserEntity user = userEntity.get();
//        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
//        if (user.getUserId().equals("lo5er")) {
//            grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
//        } else {
//            grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));
//
//        }
//        return new User(user.getUserId(), user.getPassword(), grantedAuthorities);
//    }
//    }
//}
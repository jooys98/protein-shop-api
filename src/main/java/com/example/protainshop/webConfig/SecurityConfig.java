package com.example.protainshop.webConfig;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public AuthenticationSuccessHandler authenticationSuccessHandler() {
        return ((request, response, authentication) -> {
            Map<String, Object> responseData = new HashMap<>();
            responseData.put("result", "로그인성공");

            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(responseData);

            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json");
            response.getWriter().write(json);
            response.setStatus(200);
        });
    }

    @Bean
    public AuthenticationFailureHandler authenticationFailureHandler() {
        return ((request, response, exception) -> {
            Map<String, Object> responseData = new HashMap<>();
            responseData.put("error", "로그인 실패");
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(responseData);
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json");
            response.getWriter().write(json);
            response.setStatus(401);
        });
    }

    @Bean
    public LogoutSuccessHandler logoutSuccessHandler() {
        return ((request, response, authentication) -> {
            response.setStatus(200);
            response.getWriter().write("Logout successful");
        });
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowCredentials(true);
        configuration.addAllowedOrigin("http://localhost:3000");
        configuration.addAllowedOrigin("https://openapi.map.naver.com"); // 네이버지도 api
        configuration.addAllowedHeader("*");
        configuration.addAllowedMethod("*");
        configuration.addExposedHeader("Authorization");  // JWT를 사용할 경우 필요

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Bean
    public SecurityFilterChain springSecurityFilter(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .cors(cors -> cors.configurationSource(corsConfigurationSource()))
                .authorizeHttpRequests(authorize ->
                                authorize
//                                        .requestMatchers("/api/user-join").permitAll()
                                        .requestMatchers("/api/**").permitAll()
//                                        .requestMatchers("/api/auth/**").permitAll()  // 로그인/로그아웃 URL 허용


//                                .requestMatchers("/api/protain/**").permitAll()
//                                .requestMatchers("/login", "/register").permitAll()
//                                .requestMatchers("/api/main-category/**").permitAll()  // 카테고리 API 추가
//                                .requestMatchers("/api/sub-category/**").permitAll()
//                                .requestMatchers("/api/sub-category/**/product").permitAll()
//                                .requestMatchers("/api/protain/search").permitAll()
//                                .requestMatchers("/api/protain/cart").permitAll()
//                                .requestMatchers("/api/protain/cart/**").permitAll()
//                                .requestMatchers("/api/user-find/**").permitAll()
//                                .requestMatchers("/api/user-find/userinfo").permitAll()
//                                .requestMatchers("/api/user-checked/**").permitAll()
//                                .requestMatchers("/api/user-join").permitAll()
//                                .requestMatchers("/api/login", "/api/register" , "/api/user-join" , "api/user-checked/").permitAll()
                                        .anyRequest().authenticated()
                )

                .formLogin(form -> form
                        .loginProcessingUrl("/api/auth/login")
                        .successHandler(authenticationSuccessHandler())
                        .failureHandler(authenticationFailureHandler())
//                        .usernameParameter("userId")  // 클라이언트에서 보내는 필드명과 일치시킴
//                        .passwordParameter("password")
                )
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                );

        return http.build();
    }
}
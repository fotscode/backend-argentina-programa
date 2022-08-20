package com.fots.backendap;

import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.fots.backendap.model.AppUser;
import com.fots.backendap.model.Role;
import com.fots.backendap.repositories.ProfileRepo;
import com.fots.backendap.service.UserService;

@SpringBootApplication
public class BackendapApplication {

  public static void main(String[] args) {
    SpringApplication.run(BackendapApplication.class, args);
  }

  @Bean
  BCryptPasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  CommandLineRunner run(UserService userService, ProfileRepo profileRepo) {
    return args -> {
      userService.saveRole(new Role(null, "ROLE_USER"));
      userService.saveUser(new AppUser(null, "john", "1234", new ArrayList<>()));
      userService.addRoleToUser("john", "ROLE_USER");
    };
  }
}

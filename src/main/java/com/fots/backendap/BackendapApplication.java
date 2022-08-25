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
import com.fots.backendap.repositories.RoleRepo;
import com.fots.backendap.repositories.UserRepo;
import com.fots.backendap.service.UserService;

@SpringBootApplication()
public class BackendapApplication {

  public static void main(String[] args) {
    SpringApplication.run(BackendapApplication.class, args);
  }

  @Bean
  BCryptPasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  CommandLineRunner run(UserService userService, UserRepo userRepo, RoleRepo roleRepo,ProfileRepo profileRepo) {
    return args -> {
      userRepo.deleteAll();
      roleRepo.deleteAll();
      userService.saveRole(new Role(null, "ROLE_USER"));
      userService.saveUser(new AppUser(null, "admin", "1234", new ArrayList<>()));
      userService.addRoleToUser("admin", "ROLE_USER");
    };
  }
}

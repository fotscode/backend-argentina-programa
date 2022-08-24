package com.fots.backendap;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.fots.backendap.model.AppUser;
import com.fots.backendap.model.Role;
import com.fots.backendap.repositories.ProfileRepo;
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
  CommandLineRunner run(UserService userService, ProfileRepo profileRepo) {
    return args -> {
      //userService.addRoleToUser("admin", "ROLE_USER");
      //profileRepo.save(new Profile(null,"imagen1".getBytes(),"imagen2".getBytes(),"Nombre","Titulo","Descripcion"));
    };
  }
}

package com.fots.backendap.repositories;

import com.fots.backendap.model.AppUser;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<AppUser,Long>{
  AppUser findByUsername(String username);
}

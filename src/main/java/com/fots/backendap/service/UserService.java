package com.fots.backendap.service;

import java.util.List;

import com.fots.backendap.model.AppUser;
import com.fots.backendap.model.Role;

public interface UserService {
  AppUser saveUser(AppUser user);
  Role saveRole(Role role);
  void addRoleToUser(String username,String roleName);
  AppUser getUser(String username);
  List<AppUser> getUsers();
}

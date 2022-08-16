package com.fots.backendap.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import com.fots.backendap.model.AppUser;
import com.fots.backendap.model.Role;
import com.fots.backendap.repositories.RoleRepo;
import com.fots.backendap.repositories.UserRepo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * UserServiceImpl
 */
@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService, UserDetailsService {
  private final UserRepo userRepo;
  private final RoleRepo roleRepo;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    AppUser user = userRepo.findByUsername(username);
    if (user == null) {
      throw new UsernameNotFoundException("User not found");
    }
    System.out.println("User found: " + user.getUsername());
    Collection<SimpleGrantedAuthority> authorities=new ArrayList<>();
    user.getRoles().forEach(role->authorities.add(new SimpleGrantedAuthority(role.getName())));
    return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),authorities);
  }

  @Override
  public AppUser saveUser(AppUser user) {
    return userRepo.save(user);
  }

  @Override
  public Role saveRole(Role role) {
    return roleRepo.save(role);
  }

  @Override
  public void addRoleToUser(String username, String roleName) {
    AppUser user = userRepo.findByUsername(username);
    Role role = roleRepo.findByName(roleName);
    user.addRole(role);
  }

  @Override
  public AppUser getUser(String username) {
    return userRepo.findByUsername(username);
  }

  @Override
  public List<AppUser> getUsers() {
    return userRepo.findAll();
  }

}

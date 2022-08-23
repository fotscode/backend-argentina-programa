package com.fots.backendap.service.implementations;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import com.fots.backendap.model.AppUser;
import com.fots.backendap.model.Role;
import com.fots.backendap.repositories.RoleRepo;
import com.fots.backendap.repositories.UserRepo;
import com.fots.backendap.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * UserServiceImpl
 */
@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService, UserDetailsService {
  private final UserRepo userRepo;
  private final RoleRepo roleRepo;
  private final PasswordEncoder passwordEncoder;

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
    log.info("Saving user {}",user.getUsername());
    user.setPassword(passwordEncoder.encode(user.getPassword()));
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
    log.info("users: {}",userRepo.findAll());
    return userRepo.findAll();
  }

}

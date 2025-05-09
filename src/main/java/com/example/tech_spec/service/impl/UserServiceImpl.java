package com.example.tech_spec.service.impl;

import org.springframework.stereotype.Service;

import com.example.tech_spec.model.User;
import com.example.tech_spec.model.dto.UserDTO;
import com.example.tech_spec.repository.UserRepository;
import com.example.tech_spec.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService{
    private final UserRepository repository;
    @Override
     public  User save(User user){
      log.info("Saving user : {} " , user.getName());
    return repository.save(user);
    };
    @Override
    public User create(UserDTO userDetails){
      if (repository.existsByEmail(userDetails.getEmail())) {
        log.error("User with email: {} , already exist",userDetails.getEmail());
        throw new RuntimeException("User with email  "+  userDetails.getEmail() + " already exist");
      }
      log.info("Creating new user : {}" , userDetails.getName());
      User user = new User();
      user.setName(userDetails.getName());
      user.setEmail(userDetails.getEmail());
      return save(user);
    };
    @Override
    public User userInfo(Long id){
    log.info("Fetching user with id : " , id );
    return repository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    };
    @Override
    public User updateUser(Long id ,UserDTO userDetails){
    log.info("Updating user : " , userDetails.getName());
    User user = userInfo(id);
      user.setName(userDetails.getName());
      user.setEmail(userDetails.getEmail());
      return save(user);
    };
    @Override
   public  void deleteUser(Long id){
    log.info("Deleting user with id : {}",id);
    repository.deleteById(id);
    };
}

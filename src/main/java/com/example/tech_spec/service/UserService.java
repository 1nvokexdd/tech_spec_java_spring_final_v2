package com.example.tech_spec.service;

import com.example.tech_spec.model.User;
import com.example.tech_spec.model.dto.UserDTO;

public interface UserService {
    User save(User user);
    User create(UserDTO user);
    User userInfo(Long id);
    User updateUser(Long id ,UserDTO userDetails);
    void deleteUser(Long id);
}

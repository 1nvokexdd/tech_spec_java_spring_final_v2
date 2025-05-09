package com.example.tech_spec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tech_spec.model.User;

public interface UserRepository extends JpaRepository<User,Long> {
    boolean existsByEmail(String email);
}

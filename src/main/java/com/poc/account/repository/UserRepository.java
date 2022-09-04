package com.poc.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poc.account.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}

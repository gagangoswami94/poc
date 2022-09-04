package com.poc.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poc.account.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
}

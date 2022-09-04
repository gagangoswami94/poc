package com.poc.account.service;

import com.poc.account.model.User;
import com.poc.account.repository.RoleRepository;
import com.poc.account.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;

/** {@author waheedk}!*/
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    /** userRepository !*/
    private UserRepository userRepository;
    @Autowired
    /** roleRepository !*/
    private RoleRepository roleRepository;
    @Autowired
    /** bCryptPasswordEncoder !*/
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(final User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(new HashSet<>(roleRepository.findAll()));
        userRepository.save(user);
    }

    @Override
    public User findByUsername(final String username) {
        return userRepository.findByUsername(username);
    }
}

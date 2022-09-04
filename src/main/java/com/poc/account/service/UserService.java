package com.poc.account.service;

import com.poc.account.model.User;

/** {@author waheedk}!*/
public interface UserService {
	/** {@inheritDoc}} !*/
    void save(User user);
    /** {@inheritDoc}} !*/
    User findByUsername(String username);
}

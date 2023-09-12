package com.iohim.shopbook.service;

import com.iohim.shopbook.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findById(Long id);
    void save(User user);
    void update(Long id, User updatedUser);
    void delete(Long id);
}

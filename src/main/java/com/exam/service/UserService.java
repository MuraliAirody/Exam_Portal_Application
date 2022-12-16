package com.exam.service;

import com.exam.entity.User;
import com.exam.entity.UserRole;
import org.springframework.stereotype.Service;

import java.util.Set;


public interface UserService {
    public User createUser(User user, Set<UserRole> userRoles) throws Exception;
}

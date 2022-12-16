package com.exam.service.impl;

import com.exam.entity.User;
import com.exam.entity.UserRole;
import com.exam.repo.RoleRepository;
import com.exam.repo.UserRepository;
import com.exam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Override
    public User createUser(User user, Set<UserRole> userRoles) throws Exception {

        User local = this.userRepository.findByUsername(user.getUsername());
        if(local!=null){
            System.out.println("User already exist");
            throw new Exception("user already exist");
        }else{
             for(UserRole userRole:userRoles){
                 this.roleRepository.save(userRole.getRole());
             }
             //create a user
             user.getUserRoles().addAll(userRoles);
            local = this.userRepository.save(user);
        }
      return  local;
    }
}

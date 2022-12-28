package com.exam.service.impl;

import com.exam.entity.User;
import com.exam.entity.UserRole;
import com.exam.exceptions.UserFoundException;
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
            throw new UserFoundException();
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

    @Override
    public User getUser(String username) {
        return this.userRepository.findByUsername(username);
    }

    @Override
    public void deleteUser(int id) {
        this.userRepository.deleteById(id);
    }

    @Override
    public User updateUser(int id,User user) {
        User oldUser= this.userRepository.findById(id).get();

        if(oldUser!=null){
            oldUser.setUsername(user.getUsername());
            oldUser.setFirstname(user.getFirstname());
            oldUser.setLastname(user.getLastname());
            oldUser.setPhone(user.getPhone());
            oldUser.setEmail(user.getEmail());
            oldUser.setProfile(user.getProfile());

            this.userRepository.save(oldUser);

            return  this.userRepository.findByUsername(user.getUsername());
        }
        return  null;
    }
}

package com.exam;

import com.exam.entity.Role;
import com.exam.entity.User;
import com.exam.entity.UserRole;
import com.exam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class ExamServerApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;
	public static void main(String[] args) {
		SpringApplication.run(ExamServerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("starting code");

//		User user = new User();
//		user.setUsername("Mahesh00");
//		user.setEmail("m@gmail.com");
//		user.setFirstname("Mahesh");
//		user.setLastname("tyagi");
//		user.setPhone("787994393");
//		user.setProfile("pic.png");
//
//		Role role = new Role();
//		role.setRolename("user");
//		role.setRoleId(55);
//
//		Set< UserRole> userRoleSet = new HashSet<>();
//		UserRole userRole = new UserRole();
//		userRole.setRole(role);
//		userRole.setUser(user);
//
//		userRoleSet.add(userRole);
//
//        User user1 = userService.createUser(user,userRoleSet);
//		System.out.println(user1.getUsername());
	}
}

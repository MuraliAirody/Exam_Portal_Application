package com.exam;

import com.exam.entity.Role;
import com.exam.entity.User;
import com.exam.entity.UserRole;
import com.exam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class ExamServerApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	public static void main(String[] args) {
		SpringApplication.run(ExamServerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("starting code");

//		User user = new User();
//		user.setUsername("drtex");
//		user.setEmail("techtestingindia123@gmail.com");
//		user.setFirstname("Murali");
//		user.setLastname("s");
//		user.setPhone("987654321");
//		user.setProfile("deafult.png");
//
//		user.setPassword(passwordEncoder.encode("111"));
//
//		Role role = new Role();
//		role.setRolename("ADMIN");
//		role.setRoleId(44);
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

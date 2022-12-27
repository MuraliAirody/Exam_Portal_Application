package com.exam.controller;

import com.exam.config.JwtUtils;
import com.exam.config.impl.UserDetailServiceImpl;
import com.exam.entity.JwtRequest;
import com.exam.entity.JwtResponse;
import com.exam.entity.User;
import com.exam.entity.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin("*")
public class AuthenticationController {


    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private UserDetailServiceImpl userDetailService;

    @PostMapping("/generate-token")
    public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception {

        try{
            authenticate(jwtRequest.getUsername(),jwtRequest.getPassword());
        }catch (UsernameNotFoundException e){
            System.out.println("exception ->"+e.getMessage());
            e.printStackTrace();
            throw new Exception("User Not found");
        }

        UserDetails userDetails = this.userDetailService.loadUserByUsername(jwtRequest.getUsername());
        String token = this.jwtUtils.generateToken(userDetails);
        System.out.println(token);
        return ResponseEntity.ok(new JwtResponse(token));

    }
    private void authenticate(String username, String password) throws Exception {
         try{
            this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
         }catch (DisabledException e)
         {
             e.printStackTrace();
             throw new Exception("user disabled");
         }catch (BadCredentialsException e)
         {
             e.printStackTrace();
             throw new Exception("invalid user credentials"+e.getMessage());
         }
         catch (Exception e)
         {
             e.printStackTrace();
         }
    }

    @GetMapping("/current-user")
    public User getCurrentUserDetails(Principal principal){
//       User u1 = (User) this.userDetailService.loadUserByUsername(principal.getName());
//        List<UserRole> list = new ArrayList<>(u1.getUserRoles());
//        System.out.println("user roles ->"+ list.get(0).getRole().getRolename());
      return (User) this.userDetailService.loadUserByUsername(principal.getName());
    }
}

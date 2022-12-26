package com.exam.controller;

import com.exam.config.JwtUtils;
import com.exam.config.impl.UserDetailServiceImpl;
import com.exam.entity.JwtRequest;
import com.exam.entity.JwtResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {


    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private UserDetailServiceImpl userDetailService;

    @PostMapping("/generate-token")
    public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest){

        authenticate(jwtRequest.getUsername(),jwtRequest.getPassword());
        System.out.println(jwtRequest);

        UserDetails userDetails = this.userDetailService.loadUserByUsername(jwtRequest.getUsername());
        String token = this.jwtUtils.generateToken(userDetails);
        System.out.println(token);

        return ResponseEntity.ok(new JwtResponse(token));

    }
    private void authenticate(String username, String password){
         try{
            this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
         }catch (DisabledException e)
         {
             e.printStackTrace();
         }catch (BadCredentialsException e)
         {
             e.printStackTrace();
             System.out.println(e.getMessage());
         }
         catch (Exception e)
         {
             e.printStackTrace();
         }
    }
}

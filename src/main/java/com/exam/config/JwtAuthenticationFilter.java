package com.exam.config;

import com.exam.config.impl.UserDetailServiceImpl;
import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtils jwtUtils;
    @Autowired
    private UserDetailServiceImpl userDetailService;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String requestHeader = request.getHeader("Authorization");

        System.out.println("header ->"+requestHeader);

        String username = null;
        String jwtToken = null;

       if(requestHeader!=null && requestHeader.startsWith("Bearer "))
        {
            jwtToken = requestHeader.substring(7);

            try{
                username=this.jwtUtils.extractUsername(jwtToken);
            }catch (ExpiredJwtException e) {
               e.printStackTrace();
                System.out.println("Exception "+e.getMessage());
            }
            catch (Exception e)
            {
                e.printStackTrace();
                System.out.println("Exception "+e.getMessage());
            }
       }
       else{
            System.out.println("invalid Token, not start with Bearer String");
       }

       //validate
        if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null)
        {
         final    UserDetails userDetails = this.userDetailService.loadUserByUsername(username);

         //token is valid
            if(this.jwtUtils.validateToken(jwtToken,userDetails)){
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null,userDetails.getAuthorities());
                usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
        }
        else {
            System.out.println("token is not valid");
        }

        filterChain.doFilter(request,response);


    }
    }


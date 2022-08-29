package com.employee.io.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserService implements UserDetailsService {
    Map<String, String> employees = new HashMap<>();

    {
        // db mimic for user
        employees.put("admin", "password");
        employees.put("sdadmin", "password");
        employees.put("raushan", "password");
        employees.put("arun", "password");
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        // before next statement we can get user from DB, as of now using employees map
        if(employees.containsKey(userName)) {
            return new User(userName, employees.get(userName), new ArrayList<>());
        }
        else throw new UsernameNotFoundException("user not exist");
    }
}
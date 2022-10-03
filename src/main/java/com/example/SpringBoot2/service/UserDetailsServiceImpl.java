package com.example.SpringBoot2.service;

import com.example.SpringBoot2.model.User;
import com.example.SpringBoot2.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String firstName) throws UsernameNotFoundException {
        User user = userRepository.findByFirstName(firstName);
        if (user == null) {
            throw new UsernameNotFoundException("username " + firstName
                    + " not found");
        }
        return user;
    }
}

package com.example.SpringBoot2.service;

import com.example.SpringBoot2.model.Role;
import com.example.SpringBoot2.model.User;
import com.example.SpringBoot2.repository.RoleRepository;
import com.example.SpringBoot2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    @Autowired
    public UserServiceImp(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;

    }


    @Override
    @Transactional
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }


    @Override
    @Transactional
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    @Transactional
    public User getUserById(Long id) {
        return userRepository.getById(id);

    }

    @Override
    @Transactional
    public List<User> showAllUsers() {
        return userRepository.findAll();

    }

    public Role findByRoleName(String role) {
        return roleRepository.findByName(role);
    }

    @Override
    @Transactional
    public void updateUser(User user, String[] roles) {
        addAndCreate(user, roles);
    }

    @Override
    @Transactional
    public void createUser(User user, String[] roles) {
     addAndCreate(user, roles);
    }

    private void addAndCreate(User user,
                              String[] roles){
        String roleName = null;
        for (String s : roles) {
            roleName = s;
        }
        Role role = roleRepository.findByName(roleName);
        List<Role> roleList2 = new ArrayList<>();
        roleList2.add(role);

        user.setRoles(roleList2);

        userRepository.save(user);

    }
}



package com.example.SpringBoot2.service;

import com.example.SpringBoot2.model.Role;
import com.example.SpringBoot2.model.User;

import java.util.List;

public interface UserService {
    void createUser(User user, String[] roles); // добавление юзера

    void deleteUser(Long id); // удаление

    void updateUser(User user, String[] roles); // изменять

    User getUserById(Long id); // получение юзера по id

    List<User> showAllUsers(); // показать всех юзеров

    List<Role> getAllRoles();// показать все role

    Role findByRoleName(String role);


//    public List<Role> findRolesByName(String roleName);


}


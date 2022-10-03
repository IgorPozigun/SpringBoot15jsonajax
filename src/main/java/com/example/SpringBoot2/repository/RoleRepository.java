package com.example.SpringBoot2.repository;


import com.example.SpringBoot2.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;



public interface RoleRepository extends JpaRepository <Role,Long>{
  Role findByName(String name); // получение роли по имени
}

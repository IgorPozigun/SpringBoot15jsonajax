package com.example.SpringBoot2.repository;

import com.example.SpringBoot2.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//Нам не нужно использовать @Repository аннотацию при
// расширении JpaRepository,
// потому что Spring обнаруживает, что предопределенное JpaRepository было расширено,
// и распознает интерфейс, который расширяется JpaRepository как репозиторий.


public interface UserRepository extends JpaRepository<User,Long> {
    User findByFirstName(String firstName);//ищем юзера по имени
}

package com.sendEmailSpringBoot.demo.repository;


import com.sendEmailSpringBoot.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long > {
    boolean existsByName(String name);
    User findByName (String name);

    long count();
}

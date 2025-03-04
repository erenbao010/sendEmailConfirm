package com.sendEmailSpringBoot.demo.repository;


import com.sendEmailSpringBoot.demo.entity.User;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface UserRepository extends JpaRepository<User, Long > {
    boolean existsByName(String name);
}

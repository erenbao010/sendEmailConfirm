package com.sendEmailSpringBoot.demo.repository;


import com.sendEmailSpringBoot.demo.entity.User;
import com.sendEmailSpringBoot.demo.service.UserService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface UserRepository extends JpaRepository<User, Long > {
    boolean existsByName(String name);



    long count();
}

package com.example.CTGTDL.repository;

import com.example.CTGTDL.entity.User;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface UserRepository extends JpaRepository<User, Long > {
    boolean existsByName(String name);
}

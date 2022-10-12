package com.project.hareexpress.repositories;

import com.project.hareexpress.domain.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByLogin(String username);
}

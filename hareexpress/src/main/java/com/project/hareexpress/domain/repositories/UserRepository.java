package com.project.hareexpress.domain.repositories;

import com.project.hareexpress.domain.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByLogin(String username);
    User findFirstByLogin(String login);
    User findFirstByEmail(String email);
}

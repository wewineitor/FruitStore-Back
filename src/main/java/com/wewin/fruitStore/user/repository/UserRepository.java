package com.wewin.fruitStore.user.repository;

import com.wewin.fruitStore.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findUserById(Long id);
    User findUserByEmail(String email);
}

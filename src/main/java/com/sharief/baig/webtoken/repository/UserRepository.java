package com.sharief.baig.webtoken.repository;

import com.sharief.baig.webtoken.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findUserByUsername(String username);

    @Override
    User save(User user);
}

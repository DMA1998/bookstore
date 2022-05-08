package com.mykh.bookstore.login.repository;

import com.mykh.bookstore.user.model.User;
import com.mykh.bookstore.user.repository.AppUserRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface LoginRepository extends AppUserRepository {

    @Query("SELECT user FROM User user WHERE user.email =?1 AND user.password=?2")
    Optional<User> findUserByCredentials(String username, String password);
}

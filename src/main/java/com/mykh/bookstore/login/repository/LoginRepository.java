package com.mykh.bookstore.login.repository;

import com.mykh.bookstore.appuser.model.AppUser;
import com.mykh.bookstore.appuser.repository.AppUserRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface LoginRepository extends AppUserRepository {

    @Query("SELECT user FROM AppUser user WHERE user.email =?1 AND user.password=?2")
    Optional<AppUser> findUserByCredentials(String username, String password);
}

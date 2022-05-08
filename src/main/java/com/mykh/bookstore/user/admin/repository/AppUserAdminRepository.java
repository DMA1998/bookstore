package com.mykh.bookstore.user.admin.repository;

import com.mykh.bookstore.user.model.User;
import com.mykh.bookstore.user.repository.AppUserRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface AppUserAdminRepository extends AppUserRepository {

    @Query("SELECT admins FROM User admins WHERE admins.appUserRole = 'ADMIN'")
    Optional<List<User>> findAllAdmins();

    @Transactional
    @Modifying
    @Query("UPDATE User user SET user.appUserRole = 'ADMIN' WHERE user.email =?1")
    void enableAdminUser(String email);
}

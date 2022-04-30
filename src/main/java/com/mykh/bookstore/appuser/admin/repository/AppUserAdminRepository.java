package com.mykh.bookstore.appuser.admin.repository;

import com.mykh.bookstore.appuser.model.AppUser;
import com.mykh.bookstore.appuser.repository.AppUserRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface AppUserAdminRepository extends AppUserRepository {

    @Query("SELECT admins FROM AppUser admins WHERE admins.appUserRole = 'ADMIN'")
    Optional<List<AppUser>> findAllAdmins();

    @Transactional
    @Modifying
    @Query("UPDATE AppUser user SET user.appUserRole = 'ADMIN' WHERE user.email =?1")
    void enableAdminUser(String email);
}

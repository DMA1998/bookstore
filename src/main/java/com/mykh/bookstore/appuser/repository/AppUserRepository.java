package com.mykh.bookstore.appuser.repository;

import com.mykh.bookstore.appuser.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface AppUserRepository extends JpaRepository<AppUser, Long> {

    List<AppUser> findAll();

    Optional<AppUser> findByEmail(String email);
    
    @Transactional
    @Modifying
    @Query("UPDATE AppUser user SET user.enabled = TRUE WHERE user.email =?1")
    int enableAppUser(String email);
}

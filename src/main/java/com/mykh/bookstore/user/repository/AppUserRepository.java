package com.mykh.bookstore.user.repository;

import com.mykh.bookstore.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface AppUserRepository extends JpaRepository<User, Long> {

    List<User> findAll();

    Optional<User> findByEmail(String email);

    @Transactional
    @Modifying
    @Query("UPDATE User user SET user.enabled = TRUE WHERE user.email =?1")
    void enableAppUser(String email);
}

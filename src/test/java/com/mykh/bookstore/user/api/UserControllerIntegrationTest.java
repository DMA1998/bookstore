package com.mykh.bookstore.user.api;

import com.mykh.bookstore.user.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Description;

import java.util.List;

import static com.mykh.bookstore.user.enumeration.AppUserRole.*;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class UserControllerIntegrationTest {

    private static final String EMAIL = "AX5555AC@gmail.com";

    @Autowired
    private AppUserController appUserController;

    private List<User> users;

    @BeforeEach
    void setUp() {
        users = appUserController.getUsers();
    }

    @Test
    @Order(1)
    @Description("Test get list of all the retrieved users")
    void testRetrievingUsers() {
        assertThat(users)
                .isNotNull();
    }

    @Test
    @Order(2)
    @Description("Fetch an admin by list of users")
    void testRetrievingAdmin() {
        User admin = users.stream()
                .filter(user -> user.getAppUserRole().equals(ADMIN))
                .findAny()
                .orElseGet(null);

        assertThat(admin)
                .isNotNull()
                .extracting(User::getAppUserRole)
                .isEqualTo(ADMIN);
    }

    @Test
    @Order(3)
    @Description("Find user by specified ID")
    void findById() {
        User user = appUserController.getUser(1L);

        assertThat(user)
                .isNotNull()
                .extracting(User::getEmail)
                .isEqualTo(EMAIL);
    }
}
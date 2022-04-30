package com.mykh.bookstore.appuser.api;

import com.mykh.bookstore.appuser.model.AppUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Description;

import java.util.List;

import static com.mykh.bookstore.appuser.enumeration.AppUserRole.*;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class AppUserControllerIntegrationTest {

    private static final String EMAIL = "AX5555AC@gmail.com";

    @Autowired
    private AppUserController appUserController;

    private List<AppUser> users;

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
        AppUser admin = users.stream()
                .filter(user -> user.getAppUserRole().equals(ADMIN))
                .findAny()
                .orElseGet(null);

        assertThat(admin)
                .isNotNull()
                .extracting(AppUser::getAppUserRole)
                .isEqualTo(ADMIN);
    }

    @Test
    @Order(3)
    @Description("Find user by specified ID")
    void findById() {
        AppUser user = appUserController.getUser(1L);

        assertThat(user)
                .isNotNull()
                .extracting(AppUser::getEmail)
                .isEqualTo(EMAIL);
    }
}
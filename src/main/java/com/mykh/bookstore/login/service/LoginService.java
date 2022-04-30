package com.mykh.bookstore.login.service;

import com.mykh.bookstore.appuser.model.AppUser;
import com.mykh.bookstore.exception.login.UserNotFoundException;
import com.mykh.bookstore.login.model.LoginRequest;
import com.mykh.bookstore.login.repository.LoginRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class LoginService {

    private final static String USER_NOT_FOUND = "Credentials invalid";

    private final LoginRepository loginRepository;

    public void checkUser(LoginRequest request) {
        Optional<AppUser> user = loginRepository.findUserByCredentials(
                request.getUsername(),
                request.getPassword());

        boolean isCredentialsOk = loginRepository.findUserByCredentials(request.getUsername(), request.getPassword()).isPresent();

        if (Objects.isNull(user)) {
            throw new UserNotFoundException(USER_NOT_FOUND);
        }

        if (user.get().getLocked()) {
            throw new RuntimeException("User locked");
        }
    }
}

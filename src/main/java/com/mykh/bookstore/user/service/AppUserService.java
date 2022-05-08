package com.mykh.bookstore.user.service;

import com.mykh.bookstore.user.model.User;
import com.mykh.bookstore.user.repository.AppUserRepository;

import com.mykh.bookstore.exception.registration.UserPresentException;
import com.mykh.bookstore.token.model.ConfirmationToken;
import com.mykh.bookstore.token.service.ConfirmationTokenService;
import com.mykh.bookstore.util.AppUserConstants;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static java.text.MessageFormat.format;
import static java.time.LocalDateTime.now;

@Service
@Slf4j
@AllArgsConstructor
public class AppUserService implements UserDetailsService {

    private final AppUserRepository appUserRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ConfirmationTokenService confirmationTokenService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return appUserRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(format(AppUserConstants.USER_NOT_FOUND, email)));
    }

    public String signUpUser(User user) {
        boolean userExists = appUserRepository.findByEmail(user.getEmail()).isPresent();

        if (userExists) {
            throw new UserPresentException(format(AppUserConstants.USER_FOUND, user.getEmail()));
        }

        String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        appUserRepository.save(user);

        String token = UUID.randomUUID().toString();

        ConfirmationToken confirmationToken = new ConfirmationToken(
                token,
                now(),
                now().plusMinutes(15),
                user
        );

        confirmationTokenService.saveConfirmationToken(confirmationToken);

        return token;
    }

    public void enableAppUser(String email) {
        appUserRepository.enableAppUser(email);
    }

    public Optional<List<User>> getAllUsers() {
        log.info("Fetching all users");
        return Optional.of(appUserRepository.findAll());
    }

    public Optional<User> getUserById(Long id) {
        log.info("Finding user by id: {}", id);
        return appUserRepository.findById(id);
    }

}

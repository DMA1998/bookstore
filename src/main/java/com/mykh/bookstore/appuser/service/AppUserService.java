package com.mykh.bookstore.appuser.service;

import com.mykh.bookstore.appuser.model.AppUser;
import com.mykh.bookstore.appuser.repository.AppUserRepository;

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

import java.text.MessageFormat;
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
                .orElseThrow(() -> new UsernameNotFoundException(MessageFormat.format(AppUserConstants.USER_NOT_FOUND, email)));
    }

    public String signUpUser(AppUser appUser) {
        boolean userExists = appUserRepository.findByEmail(appUser.getEmail()).isPresent();

        if (userExists) {
            throw new UserPresentException(format(AppUserConstants.USER_FOUND, appUser.getEmail()));
        }

        String encodedPassword = bCryptPasswordEncoder.encode(appUser.getPassword());
        appUser.setPassword(encodedPassword);

        appUserRepository.save(appUser);

        String token = UUID.randomUUID().toString();

        ConfirmationToken confirmationToken = new ConfirmationToken(
                token,
                now(),
                now().plusMinutes(15),
                appUser
        );

        confirmationTokenService.saveConfirmationToken(confirmationToken);

        return token;
    }

    public int enableAppUser(String email) {
        return appUserRepository.enableAppUser(email);
    }

    public Optional<List<AppUser>> getAllUsers() {
        log.info("Fetching all users");
        return Optional.of(appUserRepository.findAll());
    }

    public Optional<AppUser> getUserById(Long id) {
        log.info("Finding user by id: {}", id);
        return appUserRepository.findById(id);
    }

}

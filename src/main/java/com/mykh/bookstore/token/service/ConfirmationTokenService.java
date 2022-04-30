package com.mykh.bookstore.token.service;

import com.mykh.bookstore.token.model.ConfirmationToken;
import com.mykh.bookstore.token.repository.ConfirmationTokenRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static java.text.MessageFormat.format;
import static java.time.LocalDateTime.now;

@Service
@AllArgsConstructor
@Slf4j
public class ConfirmationTokenService {

    private final ConfirmationTokenRepository confirmationTokenRepository;

    public void saveConfirmationToken(ConfirmationToken token) {
        log.info(format("Saving confirmation token: {0}", token));
        confirmationTokenRepository.save(token);
    }

    public Optional<ConfirmationToken> getToken(String token) {
        log.info(format("Retrieving confirmation token by token: {0}", token));
        return confirmationTokenRepository.findByToken(token);
    }

    public int setConfirmedAt(String token) {
        log.info(format("Set confirmation token {0} confirmed at", token));
        return confirmationTokenRepository.updateConfirmedAt(token, now());
    }
}

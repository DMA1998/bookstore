package com.mykh.bookstore.registration.service;

import com.mykh.bookstore.appuser.model.AppUser;
import com.mykh.bookstore.appuser.service.AppUserService;
import com.mykh.bookstore.registration.email.EmailSender;
import com.mykh.bookstore.exception.email.EmailConfirmationException;
import com.mykh.bookstore.exception.registration.token.TokenExpiredException;
import com.mykh.bookstore.exception.registration.token.TokenNotFoundException;
import com.mykh.bookstore.exception.email.EmailValidationException;
import com.mykh.bookstore.registration.model.RegistrationRequest;
import com.mykh.bookstore.registration.email.validation.EmailValidator;
import com.mykh.bookstore.registration.view.WelcomeView;
import com.mykh.bookstore.token.model.ConfirmationToken;
import com.mykh.bookstore.token.service.ConfirmationTokenService;
import com.mykh.bookstore.util.MessageProvider;
import com.mykh.bookstore.util.HtmlEmailPageBuilder;
import com.mykh.bookstore.util.RegistrationConstants;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.util.Objects;

import static com.mykh.bookstore.appuser.enumeration.AppUserRole.USER;
import static com.mykh.bookstore.util.RegistrationConstants.BAD_EMAIL;
import static java.text.MessageFormat.format;
import static java.time.LocalDateTime.now;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final EmailValidator emailValidator;
    private final EmailSender emailSender;
    private final AppUserService appUserService;
    private final ConfirmationTokenService confirmationTokenService;
    private final MessageProvider messageProvider;
    private final WelcomeView welcomeView;

    @Transactional
    public String register(RegistrationRequest request) {
        String email = request.getEmail();
        boolean isValidEmail = emailValidator.test(email);
        if (!isValidEmail) {
            throw new EmailValidationException(MessageFormat.format(BAD_EMAIL, email));
        }

        String token = appUserService.signUpUser(new AppUser(
                request.getFirstName(),
                request.getLastName(),
                request.getEmail(),
                request.getPassword(),
                USER
        ));

        String link = messageProvider.getTokenConfirmationLink() + token;
        emailSender.send(request.getEmail(), HtmlEmailPageBuilder.buildEmail(request.getFirstName(), link));

        return welcomeView.welcomePage();
    }

    @Transactional
    public String confirmToken(String token) {
        ConfirmationToken confirmationToken = confirmationTokenService.getToken(token)
                .orElseThrow(() -> new TokenNotFoundException(format("Token {0} was not found", token)));

        if (Objects.nonNull(confirmationToken.getConfirmedAt())) {
            throw new EmailConfirmationException(MessageFormat.format("Email {0} already confirmed", confirmationToken.getAppUser().getEmail()));
        }

        LocalDateTime expiredAt = confirmationToken.getExpiresAt();

        if (expiredAt.isBefore(now())) {
            throw new TokenExpiredException(format("Token {0} expired", token));
        }

        confirmationTokenService.setConfirmedAt(token);
        appUserService.enableAppUser(confirmationToken.getAppUser().getEmail());

        return "Confirmation token sent to email";
    }

}

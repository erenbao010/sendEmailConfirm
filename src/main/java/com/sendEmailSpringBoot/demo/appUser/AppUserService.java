package com.sendEmailSpringBoot.demo.appUser;

import com.sendEmailSpringBoot.demo.registration.EmailValidator;
import com.sendEmailSpringBoot.demo.registration.VerificationToken;
import com.sendEmailSpringBoot.demo.registration.token.VerificationTokenService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AppUserService implements UserDetailsService {
    private final static String USER_NOT_FOUND = "user with email %s not found";
    private final AppUserRepository appUserRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final VerificationTokenService verificationTokenService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return appUserRepository.findByEmail(email)
                .orElseThrow(() ->
                        new UsernameNotFoundException(String.format(USER_NOT_FOUND, email)));
    }
    public String singUpUser (AppUser appUser) {
        boolean userExists = appUserRepository
                .findByEmail(appUser.getEmail())
                .isPresent();
        // TODO: Confirm user's email again if email have confirmed.
        //  When server send email the very first time and user click on this link but not login, and then user click again what if to do ?
        if (userExists) {
            throw new IllegalStateException(" user's email exists");
        }
        String encode = bCryptPasswordEncoder.encode(appUser.getPassword());
        appUser.setPassword(encode);
        appUserRepository.save(appUser);
        String token = UUID.randomUUID().toString();
        // TODO : send confirmation token
        VerificationToken verificationToken = new VerificationToken(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(15),
                appUser
        );
        verificationTokenService.saveVerificationToken(verificationToken);

        //TODO: SEND EMAIL
        return token;
    }
    public int enableAppUser(String email) {
        return appUserRepository.enableAppUser(email);
    }
}


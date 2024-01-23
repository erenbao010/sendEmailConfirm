package com.sendEmailSpringBoot.demo.registration.token;

import com.sendEmailSpringBoot.demo.registration.VerificationToken;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class VerificationTokenService {
    private final VerificationTokenRepository verificationTokenRepository;

    public Optional <VerificationToken> getToken (String token){
        return verificationTokenRepository.findByToken(token);
    };
    public void saveVerificationToken (VerificationToken token) {
        verificationTokenRepository.save(token);
    }
    public int setConfirmedAt(String token) {
        return verificationTokenRepository.updateConfirmedAt(
                token, LocalDateTime.now());
    }
}

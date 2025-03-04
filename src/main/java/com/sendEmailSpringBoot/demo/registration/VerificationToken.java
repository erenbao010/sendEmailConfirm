package com.sendEmailSpringBoot.demo.registration;

import com.sendEmailSpringBoot.demo.appUser.AppUser;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.cglib.core.Local;
import org.springframework.security.core.token.TokenService;

import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor
@Entity
public class VerificationToken {

    @SequenceGenerator(
            name = "verify_sequence",
            sequenceName = "verify_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "verify_sequence"
    )
    private Long id;
    @Column(nullable = false)
    private String token;
    @Column(nullable = false)
    private LocalDateTime createdAt;
    @Column(nullable = false)
    private LocalDateTime expiredAt;
    private LocalDateTime confirmedAt;
    @ManyToOne
    @JoinColumn(
            nullable = false,
            name = "app_user_id"
    )
    private AppUser appUser;


    public VerificationToken(String token, LocalDateTime createdAt, LocalDateTime expiredAt,AppUser appUser) {
        this.token = token;
        this.createdAt = createdAt;
        this.expiredAt = expiredAt;
        this.appUser = appUser;
    }
}
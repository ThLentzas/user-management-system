package com.example.oauth2.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "password_reset_tokens")
@Setter
@Getter
@EqualsAndHashCode(of = "id")
public class PasswordResetToken {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
    @Column(nullable = false)
    private String tokenValue;
    @Column(nullable = false)
    private Instant expiryDate;

    public PasswordResetToken() {
    }

    public PasswordResetToken(User user, String tokenValue, Instant expiryDate) {
        this.user = user;
        this.tokenValue = tokenValue;
        this.expiryDate = expiryDate;
    }
}

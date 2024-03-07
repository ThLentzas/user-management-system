package com.example.oauth2.authprovider;

import com.example.oauth2.entity.AuthUserProvider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

interface AuthUserProviderRepository extends JpaRepository<AuthUserProvider, Long> {
    @Query("""
                SELECT aup
                FROM AuthUserProvider aup
                WHERE aup.authProvider = :authProvider
            """)
    Optional<AuthUserProvider> findByAuthProvider(@Param("authProvider") AuthProvider authProvider);
}

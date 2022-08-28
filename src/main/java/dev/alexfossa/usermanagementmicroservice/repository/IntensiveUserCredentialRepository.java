package dev.alexfossa.usermanagementmicroservice.repository;

import dev.alexfossa.usermanagementmicroservice.model.IntensiveUserCredential;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IntensiveUserCredentialRepository extends JpaRepository<IntensiveUserCredential, Long> {

    Optional<IntensiveUserCredential> findIntensiveUserCredentialByUsername(String username);

}

package dev.alexfossa.usermanagementmicroservice.repository;

import dev.alexfossa.usermanagementmicroservice.model.Credential;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CredentialRepository extends JpaRepository<Credential, Long> {
}

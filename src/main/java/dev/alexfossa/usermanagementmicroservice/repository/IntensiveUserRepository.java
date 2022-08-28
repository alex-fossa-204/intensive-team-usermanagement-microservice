package dev.alexfossa.usermanagementmicroservice.repository;

import dev.alexfossa.usermanagementmicroservice.model.IntensiveUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface IntensiveUserRepository extends JpaRepository <IntensiveUser, Long> {

    Optional<IntensiveUser> findIntensiveUserByUserUuid(UUID userUuid);

}

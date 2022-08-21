package dev.alexfossa.usermanagementmicroservice.repository;

import dev.alexfossa.usermanagementmicroservice.model.IntensiveUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IntensiveUserRepository extends JpaRepository <IntensiveUser, Long> {
}

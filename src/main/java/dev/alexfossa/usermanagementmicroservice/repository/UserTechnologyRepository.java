package dev.alexfossa.usermanagementmicroservice.repository;

import dev.alexfossa.usermanagementmicroservice.model.UserTechnology;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserTechnologyRepository extends JpaRepository<UserTechnology, Long> {
}

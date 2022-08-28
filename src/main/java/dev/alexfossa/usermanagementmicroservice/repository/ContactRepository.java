package dev.alexfossa.usermanagementmicroservice.repository;

import dev.alexfossa.usermanagementmicroservice.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

    Optional<Contact> findContactByEmail(String email);

}

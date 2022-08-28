package dev.alexfossa.usermanagementmicroservice.service.implementation;

import dev.alexfossa.usermanagementmicroservice.model.Contact;
import dev.alexfossa.usermanagementmicroservice.model.IntensiveUserCredential;
import dev.alexfossa.usermanagementmicroservice.repository.ContactRepository;
import dev.alexfossa.usermanagementmicroservice.repository.IntensiveUserCredentialRepository;
import dev.alexfossa.usermanagementmicroservice.service.IUserRegistrationManagementService;
import dev.alexfossa.usermanagementmicroservice.service.dto.RegistrationVerificationRequestDto;
import dev.alexfossa.usermanagementmicroservice.service.dto.RegistrationVerificationResponseDto;
import dev.alexfossa.usermanagementmicroservice.service.exception.ServiceException;
import dev.alexfossa.usermanagementmicroservice.service.exception.implementation.IntensiveUserAlreadyExistsServiceException;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.*;

@RequiredArgsConstructor
@Service
public class UserRegistrationManagementService implements IUserRegistrationManagementService {

    private final ContactRepository contactRepository;

    private final IntensiveUserCredentialRepository intensiveUserCredentialRepository;

    @Override
    public RegistrationVerificationResponseDto userRegistrationCredentialsVerification(RegistrationVerificationRequestDto verificationRequest) throws ServiceException {
        Optional<Contact> contactOptional = contactRepository.findContactByEmail(verificationRequest.getEmail());
        if(contactOptional.isPresent()) {
            throw new IntensiveUserAlreadyExistsServiceException(String.format("Registration Denied. User with such email = %s, already registered.", verificationRequest.getEmail()));
        }
        Optional<IntensiveUserCredential> credentialOptional = intensiveUserCredentialRepository.findIntensiveUserCredentialByUsername(verificationRequest.getUsername());
        if(credentialOptional.isPresent()) {
            throw new IntensiveUserAlreadyExistsServiceException(String.format("Registration Denied. User with such username = %s, already registered.", verificationRequest.getUsername()));
        }
        return RegistrationVerificationResponseDto.builder()
                .timeStamp(LocalDateTime.now())
                .httpStatus(ACCEPTED)
                .messages(List.of(String.format("Registration Accepted. There is no any registered users with such credentials: email = %s, username %s.", verificationRequest.getEmail(), verificationRequest.getUsername())))
                .build();
    }
}

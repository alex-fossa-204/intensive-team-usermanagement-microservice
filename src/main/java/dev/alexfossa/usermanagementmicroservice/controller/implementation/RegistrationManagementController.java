package dev.alexfossa.usermanagementmicroservice.controller.implementation;

import dev.alexfossa.usermanagementmicroservice.controller.IRegistrationManagementController;
import dev.alexfossa.usermanagementmicroservice.service.IUserRegistrationManagementService;
import dev.alexfossa.usermanagementmicroservice.service.dto.RegistrationVerificationRequestDto;
import dev.alexfossa.usermanagementmicroservice.service.dto.RegistrationVerificationResponseDto;
import dev.alexfossa.usermanagementmicroservice.service.exception.ServiceException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class RegistrationManagementController implements IRegistrationManagementController {

    private final IUserRegistrationManagementService iUserRegistrationManagementService;

    @Override
    public ResponseEntity<RegistrationVerificationResponseDto> registrationVerificationPostRequest(RegistrationVerificationRequestDto verificationRequest) throws ServiceException {
        RegistrationVerificationResponseDto responseDto = iUserRegistrationManagementService.userRegistrationCredentialsVerification(verificationRequest);
        return new ResponseEntity<>(responseDto, responseDto.getHttpStatus());
    }
}

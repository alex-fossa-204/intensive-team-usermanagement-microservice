package dev.alexfossa.usermanagementmicroservice.controller;

import dev.alexfossa.usermanagementmicroservice.service.dto.RegistrationVerificationRequestDto;
import dev.alexfossa.usermanagementmicroservice.service.dto.RegistrationVerificationResponseDto;
import dev.alexfossa.usermanagementmicroservice.service.exception.ServiceException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@RequestMapping("/registration-management/intensive-user")
public interface IRegistrationManagementController extends IRegistrationVerificationController<RegistrationVerificationResponseDto, RegistrationVerificationRequestDto> {

    @PostMapping("/verification/by-email-and-username")
    @Override
    ResponseEntity<RegistrationVerificationResponseDto> registrationVerificationPostRequest(@RequestBody @Valid RegistrationVerificationRequestDto verificationRequest) throws ServiceException;
}

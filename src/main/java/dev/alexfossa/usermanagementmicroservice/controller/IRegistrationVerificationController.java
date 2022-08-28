package dev.alexfossa.usermanagementmicroservice.controller;

import dev.alexfossa.usermanagementmicroservice.service.exception.ServiceException;
import org.springframework.http.ResponseEntity;

public interface IRegistrationVerificationController<RESPONSE_DTO, REQUEST_DTO> {

    ResponseEntity<RESPONSE_DTO> registrationVerificationPostRequest(REQUEST_DTO verificationRequest) throws ServiceException;

}

package dev.alexfossa.usermanagementmicroservice.service;

import dev.alexfossa.usermanagementmicroservice.service.exception.ServiceException;

public interface IRegistrationVerificationService<RESPONSE_DTO, REQUEST_DTO> {

    RESPONSE_DTO userRegistrationCredentialsVerification(REQUEST_DTO verificationRequest) throws ServiceException;

}

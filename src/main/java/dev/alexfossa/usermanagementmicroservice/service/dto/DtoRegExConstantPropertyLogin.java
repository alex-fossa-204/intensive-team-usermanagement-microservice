package dev.alexfossa.usermanagementmicroservice.service.dto;

interface DtoRegExConstantPropertyLogin {

    String LOGIN_VALIDATION_REGEX = "^[0-9A-Za-z]{2,30}$";

    String LOGIN_CHAR_VALIDATION_ERROR_MESSAGE = "The login field must contain 2-30 chars, only latin chars A-Z, a-z and numerics in range 0-9";

}

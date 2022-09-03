package dev.alexfossa.usermanagementmicroservice.service.dto;

interface DtoRegExConstantPropertySurname {

    String USER_SURNAME_VALIDATION_REGEX = "^[A-Za-z]{0,30}$";

    String USER_SURNAME_VALIDATION_REGEX_MESSAGE = "Surname must contain 0-30 characters: A-Z, a-z";

}

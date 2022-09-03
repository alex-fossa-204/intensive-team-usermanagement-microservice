package dev.alexfossa.usermanagementmicroservice.service.dto;

interface DtoRegExConstantPropertyEmail {

    String USER_EMAIL_VALIDATION_REGEX = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";

    String USER_EMAIL_VALIDATION_REGEX_MESSAGE = "Email field can contain characters: (a-z A-Z 0-9 _!#$%&'*+/=?`{|}~^.-)@(a-zA-Z0-9.-)";

}

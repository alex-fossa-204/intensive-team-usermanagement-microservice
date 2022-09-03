package dev.alexfossa.usermanagementmicroservice.service.dto;

public interface DtoRegExConstantPropertyUsername {

    String USERNAME_VALIDATION_REGEX = "^(?=.*[A-Za-z])(?=.*[\\[\\]\\/!\\?@#\\&$_\\*;%^()|<>,~`.=\\+}\\'{:\\-\\\\])[0-9A-Za-z\\[\\]\\/!\\?@#\\&$_\\*;%^()|<>,~`.=\\+}\\'{:\\-\\\\]{2,30}$";

    String USERNAME_VALIDATION_REGEX_MESSAGE = "Username must contain 2-30 characters: 0-9, A-Z, a-z";

}

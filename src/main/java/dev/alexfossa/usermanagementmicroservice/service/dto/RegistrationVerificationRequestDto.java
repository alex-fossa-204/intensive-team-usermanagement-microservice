package dev.alexfossa.usermanagementmicroservice.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Pattern;

import static dev.alexfossa.usermanagementmicroservice.service.dto.RegistrationVerificationRequestDto.RegistrationVerificationRequestDtoConstant.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class RegistrationVerificationRequestDto {

    @JsonProperty(USER_EMAIL_JSON_PROPERTY_NAME)
    @Pattern(regexp = USER_EMAIL_VALIDATION_REGEX, message = USER_EMAIL_VALIDATION_REGEX_MESSAGE)
    private String email;

    @JsonProperty(USERNAME_JSON_PROPERTY_NAME)
    @Pattern(regexp = USERNAME_VALIDATION_REGEX, message = USERNAME_VALIDATION_REGEX_MESSAGE)
    private String username;

    interface RegistrationVerificationRequestDtoConstant {

        String REGEX_SPECIAL_CHARS = "\\[\\]\\/!\\?@#\\&$_\\*;%^()|<>,~`.=\\+}\\'{:\\-\\\\";

        String USER_EMAIL_JSON_PROPERTY_NAME = "email";

        String USER_EMAIL_VALIDATION_REGEX = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";

        String USER_EMAIL_VALIDATION_REGEX_MESSAGE = "Email field can contain characters: (a-z A-Z 0-9 _!#$%&'*+/=?`{|}~^.-)@(a-zA-Z0-9.-)";

        String USERNAME_JSON_PROPERTY_NAME = "username";

        String USERNAME_VALIDATION_REGEX = "^(?=.*[A-Za-z])(?=.*[" + REGEX_SPECIAL_CHARS + "])[0-9A-Za-z" + REGEX_SPECIAL_CHARS + "]{2,30}$";

        String USERNAME_VALIDATION_REGEX_MESSAGE = "Username must contain 2-30 characters: 0-9, A-Z, a-z";

    }

}
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
public class RegistrationVerificationRequestDto implements
        DtoRegExConstantPropertyEmail,
        DtoRegExConstantPropertyUsername {

    @JsonProperty(USER_EMAIL_JSON_PROPERTY_NAME)
    @Pattern(regexp = USER_EMAIL_VALIDATION_REGEX, message = USER_EMAIL_VALIDATION_REGEX_MESSAGE)
    private String email;

    @JsonProperty(USERNAME_JSON_PROPERTY_NAME)
    @Pattern(regexp = USERNAME_VALIDATION_REGEX, message = USERNAME_VALIDATION_REGEX_MESSAGE)
    private String username;

    interface RegistrationVerificationRequestDtoConstant {

        String USER_EMAIL_JSON_PROPERTY_NAME = "email";

        String USERNAME_JSON_PROPERTY_NAME = "username";

    }

}
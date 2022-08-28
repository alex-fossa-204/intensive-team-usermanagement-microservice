package dev.alexfossa.usermanagementmicroservice.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import static dev.alexfossa.usermanagementmicroservice.service.dto.LoginRequestDto.LoginDtoConstant.*;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class LoginRequestDto {

    @Pattern(regexp = LOGIN_VALIDATION_REGEX, message = LOGIN_CHAR_VALIDATION_ERROR_MESSAGE)
    @JsonProperty(LOGIN_FIELD_JSON_PROPERTY_NAME)
    private String login;

    @NotBlank(message = PASSWORD_FIELD_NOT_BLANK_ERROR_MESSAGE)
    @JsonProperty(PASSWORD_FILED_JSON_PROPERTY_NAME)
    private String password;

    interface LoginDtoConstant {

        String LOGIN_FIELD_JSON_PROPERTY_NAME = "login";

        String LOGIN_VALIDATION_REGEX = "^[0-9A-Za-z]{2,30}$";

        String LOGIN_CHAR_VALIDATION_ERROR_MESSAGE = "The login field must contain 2-30 chars, only latin chars A-Z, a-z and numerics in range 0-9";

        String PASSWORD_FILED_JSON_PROPERTY_NAME = "password";

        String PASSWORD_FIELD_NOT_BLANK_ERROR_MESSAGE = "The password field must not be blank";
    }

}

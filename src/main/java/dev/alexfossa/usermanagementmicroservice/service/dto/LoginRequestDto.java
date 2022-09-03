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
public class LoginRequestDto implements
        DtoRegExConstantPropertyLogin,
        DtoRegExConstantPropertyPassword {


    @JsonProperty(LOGIN_FIELD_JSON_PROPERTY_NAME)
    @Pattern(regexp = LOGIN_VALIDATION_REGEX, message = LOGIN_CHAR_VALIDATION_ERROR_MESSAGE)
    private String login;


    @JsonProperty(PASSWORD_FILED_JSON_PROPERTY_NAME)
    @NotBlank(message = PASSWORD_FIELD_NOT_BLANK_ERROR_MESSAGE)
    private String password;

    interface LoginDtoConstant {

        String LOGIN_FIELD_JSON_PROPERTY_NAME = "login";

        String PASSWORD_FILED_JSON_PROPERTY_NAME = "password";

    }

}

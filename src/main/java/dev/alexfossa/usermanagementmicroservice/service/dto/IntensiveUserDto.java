package dev.alexfossa.usermanagementmicroservice.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.util.UUID;

import static dev.alexfossa.usermanagementmicroservice.service.dto.IntensiveUserDto.IntensiveUserDtoConstant.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class IntensiveUserDto {

    @JsonProperty(USER_UID_JSON_PROPERTY_NAME)
    private UUID userUuid;

    @JsonProperty(USERNAME_JSON_PROPERTY_NAME)
    @Pattern(regexp = USERNAME_VALIDATION_REGEX, message = USERNAME_VALIDATION_REGEX_MESSAGE)
    private String username;

    @JsonProperty(USER_FIRSTNAME_JSON_PROPERTY_NAME)
    @Pattern(regexp = USER_FIRSTNAME_VALIDATION_REGEX, message = USER_FIRSTNAME_VALIDATION_REGEX_MESSAGE)
    private String firstname;

    @JsonProperty(USER_SURNAME_JSON_PROPERTY_NAME)
    @Pattern(regexp = USER_SURNAME_VALIDATION_REGEX, message = USER_SURNAME_VALIDATION_REGEX_MESSAGE)
    private String surname;

    @JsonProperty(USER_LASTNAME_JSON_PROPERTY_NAME)
    @Pattern(regexp = USER_LASTNAME_VALIDATION_REGEX, message = USER_LASTNAME_VALIDATION_REGEX_MESSAGE)
    private String lastname;

    @JsonProperty(USER_DATE_OF_BIRTH_JSON_PROPERTY_NAME)
    @DateTimeFormat
    private LocalDate dateOfBirth;

    @JsonProperty(USER_LOCATION_JSON_PROPERTY_NAME)
    @Pattern(regexp = USER_LOCATION_VALIDATION_REGEX, message = USER_LOCATION_VALIDATION_REGEX_MESSAGE)
    private String location;

    interface IntensiveUserDtoConstant {

        String REGEX_SPECIAL_CHARS = "\\[\\]\\/!\\?@#\\&$_\\*;%^()|<>,~`.=\\+}\\'{:\\-\\\\";

        String USER_UID_JSON_PROPERTY_NAME = "userUuid";

        String USERNAME_JSON_PROPERTY_NAME = "username";

        String USERNAME_VALIDATION_REGEX = "^(?=.*[A-Za-z])(?=.*[" + REGEX_SPECIAL_CHARS + "])[0-9A-Za-z" + REGEX_SPECIAL_CHARS + "]{2,30}$";

        String USERNAME_VALIDATION_REGEX_MESSAGE = "Username must contain 2-30 characters: 0-9, A-Z, a-z";

        String USER_FIRSTNAME_JSON_PROPERTY_NAME = "firstname";

        String USER_FIRSTNAME_VALIDATION_REGEX = "^(?=.*[A-Za-z])[A-Za-z]{2,30}$";

        String USER_FIRSTNAME_VALIDATION_REGEX_MESSAGE = "Firstname must contain 2-30 characters: A-Z, a-z and at least 1 A-Z, a-z character";

        String USER_SURNAME_JSON_PROPERTY_NAME = "surname";

        String USER_SURNAME_VALIDATION_REGEX = "^[A-Za-z]{0,30}$";

        String USER_SURNAME_VALIDATION_REGEX_MESSAGE = "Surname must contain 0-30 characters: A-Z, a-z";

        String USER_LASTNAME_JSON_PROPERTY_NAME = "lastname";

        String USER_LASTNAME_VALIDATION_REGEX = "^(?=.*[A-Za-z])[A-Za-z]{2,30}$";

        String USER_LASTNAME_VALIDATION_REGEX_MESSAGE = "Lastname must contain 2-30 characters: A-Z, a-z and at least 1 A-Z, a-z character";

        String USER_DATE_OF_BIRTH_JSON_PROPERTY_NAME = "dateOfBirth";

        String USER_LOCATION_JSON_PROPERTY_NAME = "location";

        String USER_LOCATION_VALIDATION_REGEX = "^(?=.*[A-Za-z])[A-Za-z]{2,30}$";

        String USER_LOCATION_VALIDATION_REGEX_MESSAGE = "Location must contain 2-30 characters: A-Z, a-z and at least 1 A-Z, a-z character";

    }

}
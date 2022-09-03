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
public class IntensiveUserDto implements
        DtoRegExConstantPropertyUsername,
        DtoRegExConstantPropertyFirstname,
        DtoRegExConstantPropertySurname,
        DtoRegExConstantPropertyLastname,
        DtoRegExConstantPropertyLocation {

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

        String USER_UID_JSON_PROPERTY_NAME = "userUuid";

        String USERNAME_JSON_PROPERTY_NAME = "username";

        String USER_FIRSTNAME_JSON_PROPERTY_NAME = "firstname";

        String USER_SURNAME_JSON_PROPERTY_NAME = "surname";

        String USER_LASTNAME_JSON_PROPERTY_NAME = "lastname";

        String USER_DATE_OF_BIRTH_JSON_PROPERTY_NAME = "dateOfBirth";

        String USER_LOCATION_JSON_PROPERTY_NAME = "location";

    }

}
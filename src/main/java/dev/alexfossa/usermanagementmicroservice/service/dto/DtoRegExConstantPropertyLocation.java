package dev.alexfossa.usermanagementmicroservice.service.dto;

public interface DtoRegExConstantPropertyLocation {

    String USER_LOCATION_VALIDATION_REGEX = "^(?=.*[A-Za-z])[A-Za-z]{2,30}$";

    String USER_LOCATION_VALIDATION_REGEX_MESSAGE = "Location must contain 2-30 characters: A-Z, a-z and at least 1 A-Z, a-z character";

}

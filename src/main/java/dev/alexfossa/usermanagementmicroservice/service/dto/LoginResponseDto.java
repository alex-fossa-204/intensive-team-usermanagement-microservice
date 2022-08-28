package dev.alexfossa.usermanagementmicroservice.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Set;

import static dev.alexfossa.usermanagementmicroservice.service.dto.LoginResponseDto.LoginResponseDtoConstant.*;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data
public class LoginResponseDto extends BaseHttpResponseDto {

    @JsonProperty(JWT_TOKEN_JSON_PROPERTY_NAME)
    private String jwtToken;

    @JsonProperty(ROLE_JSON_PROPERTY_NAME)
    private Set<String> role;

    interface LoginResponseDtoConstant {

        String JWT_TOKEN_JSON_PROPERTY_NAME = "jwtToken";

        String ROLE_JSON_PROPERTY_NAME = "role";

    }

}

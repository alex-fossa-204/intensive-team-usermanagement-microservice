package dev.alexfossa.usermanagementmicroservice.service.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

import static dev.alexfossa.usermanagementmicroservice.service.dto.BaseHttpResponseDto.BaseHttpResponseDtoConstant.*;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data
public class BaseHttpResponseDto {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = TIMESTAMP_JSON_VALUE_FORMATTER_PATTERN, timezone = TIMESTAMP_TIMEZONE)
    @JsonProperty(TIME_STAMP_JSON_PROPERTY_NAME)
    private LocalDateTime timeStamp;

    @JsonProperty(HTTP_STATUS_JSON_PROPERTY_NAME)
    private HttpStatus httpStatus;

    @JsonProperty(MESSAGE_JSON_PROPERTY_NAME)
    private List<String> messages;

    interface BaseHttpResponseDtoConstant {

        String TIME_STAMP_JSON_PROPERTY_NAME = "timestamp";

        String TIMESTAMP_JSON_VALUE_FORMATTER_PATTERN = "dd-MM-yyyy HH:mm:ss";

        String TIMESTAMP_TIMEZONE = "Europe/Minsk";

        String HTTP_STATUS_JSON_PROPERTY_NAME = "httpStatus";

        String MESSAGE_JSON_PROPERTY_NAME = "message";

    }

}

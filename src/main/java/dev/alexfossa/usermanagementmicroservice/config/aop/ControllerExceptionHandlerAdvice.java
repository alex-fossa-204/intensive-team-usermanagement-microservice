package dev.alexfossa.usermanagementmicroservice.config.aop;

import dev.alexfossa.usermanagementmicroservice.service.dto.BaseHttpResponseDto;
import dev.alexfossa.usermanagementmicroservice.service.exception.ServiceException;
import dev.alexfossa.usermanagementmicroservice.service.exception.implementation.IntensiveUserAlreadyExistsServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.*;

@RestControllerAdvice
public class ControllerExceptionHandlerAdvice {

    @ExceptionHandler(value = IntensiveUserAlreadyExistsServiceException.class)
    public ResponseEntity<BaseHttpResponseDto> intensiveUserExistServiceExceptionHandler(IntensiveUserAlreadyExistsServiceException serviceException) {
        return createHttpResponse(CONFLICT, serviceException.getMessage());
    }

    @ExceptionHandler(value = ServiceException.class)
    public ResponseEntity<BaseHttpResponseDto> serviceExceptionHandler(ServiceException serviceException) {
        return createHttpResponse(BAD_REQUEST, serviceException.getMessage());
    }

    @ExceptionHandler(value = DateTimeParseException.class)
    public ResponseEntity<BaseHttpResponseDto> dateTimeExceptionHandler(DateTimeParseException serviceException) {
        return createHttpResponse(BAD_REQUEST, serviceException.getMessage());
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<BaseHttpResponseDto> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException methodArgumentNotValidException) {
        List<FieldError> fieldErrorList = methodArgumentNotValidException.getBindingResult().getFieldErrors();
        List<String> errorsList = fieldErrorList.stream()
                .map(fieldError -> fieldError.getDefaultMessage())
                .collect(Collectors.toList());
        return createHttpResponse(BAD_REQUEST, errorsList);
    }

    private ResponseEntity<BaseHttpResponseDto> createHttpResponse(HttpStatus httpStatus, String message) {
        return new ResponseEntity<>(BaseHttpResponseDto.builder()
                .timeStamp(LocalDateTime.now())
                .httpStatus(httpStatus)
                .messages(List.of(message))
                .build(), httpStatus);
    }

    private ResponseEntity<BaseHttpResponseDto> createHttpResponse(HttpStatus httpStatus, List<String> messages) {
        return new ResponseEntity<>(BaseHttpResponseDto.builder()
                .timeStamp(LocalDateTime.now())
                .httpStatus(httpStatus)
                .messages(messages)
                .build(), httpStatus);

    }
}

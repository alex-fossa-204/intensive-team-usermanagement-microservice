package dev.alexfossa.usermanagementmicroservice.config.aop;

import dev.alexfossa.usermanagementmicroservice.service.dto.BaseHttpResponseDto;
import dev.alexfossa.usermanagementmicroservice.service.exception.ServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.*;

@RestControllerAdvice
public class ControllerExceptionHandlerAdvice {

    @ExceptionHandler(value = ServiceException.class)
    public ResponseEntity<BaseHttpResponseDto> serviceExceptionHandler(ServiceException serviceException) {
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
                .message(message)
                .build(), httpStatus);
    }

    private ResponseEntity<BaseHttpResponseDto> createHttpResponse(HttpStatus httpStatus, List<String> messages) {
        return new ResponseEntity<>(BaseHttpResponseDto.builder()
                .timeStamp(LocalDateTime.now())
                .httpStatus(httpStatus)
                .message(Arrays.toString(messages.toArray()))
                .build(), httpStatus);

    }
}

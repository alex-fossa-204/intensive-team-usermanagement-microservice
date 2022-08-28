package dev.alexfossa.usermanagementmicroservice.service.exception.implementation;

import dev.alexfossa.usermanagementmicroservice.service.exception.ServiceException;

public class IntensiveUserAlreadyExistsServiceException extends ServiceException {

    public IntensiveUserAlreadyExistsServiceException() {
    }

    public IntensiveUserAlreadyExistsServiceException(String message) {
        super(message);
    }

    public IntensiveUserAlreadyExistsServiceException(Throwable cause) {
        super(cause);
    }
}

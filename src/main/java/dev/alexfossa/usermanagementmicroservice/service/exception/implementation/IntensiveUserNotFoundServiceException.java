package dev.alexfossa.usermanagementmicroservice.service.exception.implementation;

import dev.alexfossa.usermanagementmicroservice.service.exception.ServiceException;

public class IntensiveUserNotFoundServiceException extends ServiceException {

    public IntensiveUserNotFoundServiceException() {
    }

    public IntensiveUserNotFoundServiceException(String message) {
        super(message);
    }

    public IntensiveUserNotFoundServiceException(Throwable cause) {
        super(cause);
    }
}

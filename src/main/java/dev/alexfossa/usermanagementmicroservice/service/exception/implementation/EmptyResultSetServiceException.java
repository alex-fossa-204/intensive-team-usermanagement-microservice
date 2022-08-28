package dev.alexfossa.usermanagementmicroservice.service.exception.implementation;

import dev.alexfossa.usermanagementmicroservice.service.exception.ServiceException;

public class EmptyResultSetServiceException extends ServiceException {

    public EmptyResultSetServiceException() {
    }

    public EmptyResultSetServiceException(String message) {
        super(message);
    }

    public EmptyResultSetServiceException(Throwable cause) {
        super(cause);
    }
}

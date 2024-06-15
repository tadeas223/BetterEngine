package org.example.exceptions;

public class RequirementsMissingException extends RuntimeException {
    public RequirementsMissingException() {
    }

    public RequirementsMissingException(String message) {
        super(message);
    }

    public RequirementsMissingException(String message, Throwable cause) {
        super(message, cause);
    }

    public RequirementsMissingException(Throwable cause) {
        super(cause);
    }

    public RequirementsMissingException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}

package org.example.exceptions;

public class MissingComponent extends RuntimeException {
    public MissingComponent() {
    }

    public MissingComponent(String message) {
        super(message);
    }

    public MissingComponent(String message, Throwable cause) {
        super(message, cause);
    }

    public MissingComponent(Throwable cause) {
        super(cause);
    }

    public MissingComponent(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

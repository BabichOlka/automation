package com.solvd.automation.lab.transport;

public class SpeedExeption extends Exception {
    public SpeedExeption() {
    }

    public SpeedExeption(String message) {
        super(message);
    }

    public SpeedExeption(String message, Throwable cause) {
        super(message, cause);
    }

    public SpeedExeption(Throwable cause) {
        super(cause);
    }

    public SpeedExeption(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

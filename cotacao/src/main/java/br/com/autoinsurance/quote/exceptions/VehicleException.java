package br.com.autoinsurance.quote.exceptions;

public class VehicleException extends RuntimeException {
    public VehicleException() {
        super();
    }

    public VehicleException(String message) {
        super(message);
    }

    public VehicleException(String message, Throwable cause) {
        super(message, cause);
    }

    public VehicleException(Throwable cause) {
        super(cause);
    }
}

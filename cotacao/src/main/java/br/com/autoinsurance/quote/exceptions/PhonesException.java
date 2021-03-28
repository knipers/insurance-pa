package br.com.autoinsurance.quote.exceptions;

public class PhonesException extends RuntimeException {
    public PhonesException() {
        super();
    }

    public PhonesException(String message) {
        super(message);
    }

    public PhonesException(String message, Throwable cause) {
        super(message, cause);
    }

    public PhonesException(Throwable cause) {
        super(cause);
    }
}

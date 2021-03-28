package br.com.autoinsurance.quote.exceptions;

public class QuotationException extends RuntimeException {
    public QuotationException() {
        super();
    }

    public QuotationException(String message) {
        super(message);
    }

    public QuotationException(String message, Throwable cause) {
        super(message, cause);
    }

    public QuotationException(Throwable cause) {
        super(cause);
    }
}

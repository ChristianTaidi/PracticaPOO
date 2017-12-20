package Excepciones;

public class NotPremiumClientException extends Exception{
    public NotPremiumClientException() {
        super();
    }

    public NotPremiumClientException(String message) {
        super(message);
    }
}

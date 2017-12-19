package Excepciones;

public class NoSuchEnterpriseException extends Exception{
    public NoSuchEnterpriseException() {
        super();
    }

    public NoSuchEnterpriseException(String message) {
        super(message);
    }
}

package Excepciones;

public class InvalidBackupElementException extends Exception {

    public InvalidBackupElementException(){
        super();
    }

    public InvalidBackupElementException(String msg){
        super(msg);
    }
}

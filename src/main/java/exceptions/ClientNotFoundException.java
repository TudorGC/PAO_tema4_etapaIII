package exceptions;

public class ClientNotFoundException extends RuntimeException{

    public ClientNotFoundException(){
        super("Nu a fost gasit clientul.");
    }
}

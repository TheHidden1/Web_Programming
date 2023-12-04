package mk.finki.uki.mk.lab.model.exceptions;

public class InvalidCredentialsException extends RuntimeException{
    public InvalidCredentialsException() {
        super("Invalid Credentials");
    }
}

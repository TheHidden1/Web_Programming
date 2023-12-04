package mk.finki.uki.mk.lab.model.exceptions;

public class ShoppingCartEmptyException extends RuntimeException{
    public ShoppingCartEmptyException() {
        super("Shopping cart is EMPTY!");
    }
}

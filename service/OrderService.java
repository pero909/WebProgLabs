
import mk.finki.ukim.mk.lab.model.Exceptions.ColorNotChosenException;
import mk.finki.ukim.mk.lab.model.Order;

public interface OrderService {
    Order placeOrder(String balloonColor, String clientName, String address);
    Order placeOrder(String balloonColor) throws ColorNotChosenException;
}

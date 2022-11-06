import mk.finki.ukim.mk.lab.model.Exceptions.ColorNotChosenException;
import mk.finki.ukim.mk.lab.model.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    Order placeOrder(String balloonColor,String balloonSize, String clientName, String address);
    Optional<Order> findById(Long id);
    Optional<Order> save(String balloonColor,String balloonSize
            ,String clientName,String clientAdress,Long orderId);
    List<Order> findAll();
}

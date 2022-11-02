import mk.finki.ukim.mk.lab.bootstrap.DataHolder;
import mk.finki.ukim.mk.lab.model.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderRepository {
    public List<Order> findAll(){
        return DataHolder.orderList;
    }
    public Order createOrder(Order c){
        if(c==null||c.getClientName().isEmpty()){

        }
        DataHolder.orderList.add(c);
        return c;
    }
}

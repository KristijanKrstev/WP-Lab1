package mk.finki.ukim.mk.lab.repository.InMem;

import mk.finki.ukim.mk.lab.bootstrap.DataHolder;
import mk.finki.ukim.mk.lab.model.Order;
import mk.finki.ukim.mk.lab.repository.OrderRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class OrderImpl implements OrderRepository {
    @Override
    public Order placeOrder(String pizzaType, String clientName, String address, Long id) {
        Order order= new Order(id,pizzaType,clientName,address);
        DataHolder.orders.add(order);
        return order;
    }

    public Optional<Order> find(Long id)
    {
        return DataHolder.orders.stream()
                .filter(r -> r.getOrderId().equals(id))
                .findFirst();
    }
}

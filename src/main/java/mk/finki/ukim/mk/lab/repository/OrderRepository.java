package mk.finki.ukim.mk.lab.repository;

import mk.finki.ukim.mk.lab.model.Order;

public interface OrderRepository {
    Order placeOrder(String pizzaType, String clientName, String address, Long id);

}

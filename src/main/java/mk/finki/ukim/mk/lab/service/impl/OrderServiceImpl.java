package mk.finki.ukim.mk.lab.service.impl;

import mk.finki.ukim.mk.lab.listener.PlaceOrderEvent;
import mk.finki.ukim.mk.lab.model.Order;
import mk.finki.ukim.mk.lab.repository.OrderRepository;
import mk.finki.ukim.mk.lab.service.OrderService;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService, ApplicationEventPublisherAware {
    private final OrderRepository orderRepository;
    private ApplicationEventPublisher publisher;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


    @Override
    public Order placeOrder(String pizzaType, String clientName, String address, Long id) {
        PlaceOrderEvent event=new PlaceOrderEvent(this);
        publisher.publishEvent(event);

        return orderRepository.placeOrder(pizzaType,clientName,address,id);
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.publisher=applicationEventPublisher;
    }
}

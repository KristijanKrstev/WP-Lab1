package mk.finki.ukim.mk.lab.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.RequestHandledEvent;


public class PlaceOrderEvent extends ApplicationEvent {

    public PlaceOrderEvent(Object source) {
        super(source);
    }

    public String toString()
    {
        return "Place order method called";
    }
}

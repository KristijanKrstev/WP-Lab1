package mk.finki.ukim.mk.lab.listener;

import org.springframework.context.ApplicationEvent;

public class PizaaListEvent extends ApplicationEvent {
    public PizaaListEvent(Object source) {
        super(source);
    }

    public String toString()
    {
        return "List pizzas method called";
    }
}

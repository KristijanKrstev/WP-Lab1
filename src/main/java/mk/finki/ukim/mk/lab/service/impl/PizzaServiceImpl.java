package mk.finki.ukim.mk.lab.service.impl;

import mk.finki.ukim.mk.lab.bootstrap.DataHolder;
import mk.finki.ukim.mk.lab.exceptions.InvalidPizzaName;
import mk.finki.ukim.mk.lab.listener.PizaaListEvent;
import mk.finki.ukim.mk.lab.model.Pizza;
import mk.finki.ukim.mk.lab.repository.PizzaRepository;
import mk.finki.ukim.mk.lab.service.PizzaService;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PizzaServiceImpl implements PizzaService, ApplicationEventPublisherAware {

    private final PizzaRepository pizzaRepository;
    private ApplicationEventPublisher publisher;

    public PizzaServiceImpl(PizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }

    @Override
    public Pizza save(Pizza pizza) {
        return this.pizzaRepository.save(pizza);
    }

    @Override
    public List<Pizza> getAllPizzas() {
        PizaaListEvent event = new PizaaListEvent(this);
        publisher.publishEvent(event);

        return this.pizzaRepository.getAllPizzas();
    }

    @Override
    public List<Pizza> searchPizzas(String term) {
        return this.pizzaRepository.searchPizzas(term);
    }

    @Override
    public Optional<Pizza> findbyName(String name) {
        return this.pizzaRepository.findbyName(name);
    }

    @Override
    public Pizza updatePizza(String oldName, String newName, String description) {
        Pizza pizza=this.pizzaRepository.findbyName(oldName).orElseThrow(InvalidPizzaName::new);

        pizza.setName(newName);
        pizza.setDescription(description);

        return this.pizzaRepository.save(pizza);

    }

    @Override
    public void deleteByName(String name) {
            this.pizzaRepository.deleteByName(name);

    }


    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.publisher=applicationEventPublisher;
    }
}

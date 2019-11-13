package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.Pizza;

import java.util.List;
import java.util.Optional;

public interface PizzaService {

    Pizza save(Pizza pizza);

    List<Pizza> getAllPizzas();

    List<Pizza> searchPizzas(String term);

    Optional<Pizza> findbyName(String name);

    Pizza updatePizza(String oldName,String newName, String description);

    void deleteByName(String name);
}

package mk.finki.ukim.mk.lab.repository;

import mk.finki.ukim.mk.lab.bootstrap.DataHolder;
import mk.finki.ukim.mk.lab.model.Pizza;
import mk.finki.ukim.mk.lab.service.PizzaService;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface PizzaRepository {

    public Pizza save(Pizza pizza);


    public List<Pizza> getAllPizzas();


    public List<Pizza> searchPizzas(String term);

    public Optional<Pizza> findbyName(String name);

    public void deleteByName(String name);
}
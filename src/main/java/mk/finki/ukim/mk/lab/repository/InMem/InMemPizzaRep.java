package mk.finki.ukim.mk.lab.repository.InMem;

import mk.finki.ukim.mk.lab.bootstrap.DataHolder;
import mk.finki.ukim.mk.lab.model.Pizza;
import mk.finki.ukim.mk.lab.repository.PizzaRepository;
import mk.finki.ukim.mk.lab.service.PizzaService;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class InMemPizzaRep implements PizzaRepository {
    @Override
    public Pizza save(Pizza pizza) {
        this.findbyName(pizza.getName()).ifPresent(DataHolder.pizzas::remove);
        DataHolder.pizzas.add(pizza);
        return pizza;
    }

    @Override
    public List<Pizza> getAllPizzas() {
        return new ArrayList<>(DataHolder.pizzas);
    }

    @Override
    public List<Pizza> searchPizzas(String term) {
        return DataHolder.pizzas.stream()
                .filter(r -> r.matches(term))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Pizza> findbyName(String name) {
        return DataHolder.pizzas.stream()
                .filter(r -> r.getName().equals(name))
                .findFirst();
    }


    @Override
    public void deleteByName(String name) {
        this.findbyName(name).ifPresent(DataHolder.pizzas::remove);
    }
}

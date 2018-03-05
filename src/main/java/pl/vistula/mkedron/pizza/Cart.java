package pl.vistula.mkedron.pizza;

import org.springframework.stereotype.Component;
import pl.vistula.mkedron.pizza.model.Pizza;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class Cart {
    private List<Pizza> pizzas;

    public void addPizza(Pizza pizza) {
        if(pizzas == null) {
            pizzas = new ArrayList<>();
        }
        pizzas.add(pizza);
    }

    public List<Pizza> getPizzas() {
        return pizzas == null ? Collections.emptyList() : pizzas;
    }

    public void clearCart() {
        pizzas = new ArrayList<>();
    }

}

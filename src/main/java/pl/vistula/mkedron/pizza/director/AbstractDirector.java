package pl.vistula.mkedron.pizza.director;

import pl.vistula.mkedron.pizza.builder.AbstractPizzaBuilder;
import pl.vistula.mkedron.pizza.model.Pizza;

public abstract class AbstractDirector {
    protected AbstractPizzaBuilder pizzaBuilder;

    public AbstractDirector(AbstractPizzaBuilder pizzaBuilder) {
        this.pizzaBuilder = pizzaBuilder;
    }

    public abstract Pizza getProduct();
}

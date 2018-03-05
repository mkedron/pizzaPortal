package pl.vistula.mkedron.pizza.builder;

import pl.vistula.mkedron.pizza.model.Addition;
import pl.vistula.mkedron.pizza.model.Bread;
import pl.vistula.mkedron.pizza.model.Cheese;
import pl.vistula.mkedron.pizza.model.Pizza;

import java.util.List;
import java.util.Set;

public abstract class AbstractPizzaBuilder {

    protected Cheese cheese;
    protected Bread bread;
    protected List<Addition> additions;

    public abstract AbstractPizzaBuilder cheese(Cheese cheese);
    public abstract AbstractPizzaBuilder bread(Bread bread);
    public abstract AbstractPizzaBuilder addition(Addition addition);
    public abstract AbstractPizzaBuilder additions(Set<Addition> additions);
    public abstract Pizza build();

    public Cheese getCheese() {
        return cheese;
    }

    public Bread getBread() {
        return bread;
    }

    public List<Addition> getAdditions() {
        return additions;
    }
}

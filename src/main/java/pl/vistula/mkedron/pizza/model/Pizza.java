package pl.vistula.mkedron.pizza.model;

import pl.vistula.mkedron.pizza.builder.AbstractPizzaBuilder;

import java.util.List;

public class Pizza {
    private Cheese cheese;
    private Bread bread;
    private List<Addition> additions;

    public Pizza(AbstractPizzaBuilder builder) {

        this.cheese = builder.getCheese();
        this.bread = builder.getBread();
        this.additions = builder.getAdditions();

    }

    @Override
    public String toString() {
        return "Pizza{" +
                "cheese=" + cheese +
                ", bread=" + bread +
                ", additions=" + additions +
                '}';
    }
}

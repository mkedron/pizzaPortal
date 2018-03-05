package pl.vistula.mkedron.pizza.builder;

import pl.vistula.mkedron.pizza.model.Addition;
import pl.vistula.mkedron.pizza.model.Bread;
import pl.vistula.mkedron.pizza.model.Cheese;
import pl.vistula.mkedron.pizza.model.Pizza;

import java.util.ArrayList;
import java.util.Set;

public class PizzaBuilder extends AbstractPizzaBuilder {

    @Override
    public AbstractPizzaBuilder cheese(Cheese cheese) {
        this.cheese = cheese;
        return this;
    }

    @Override
    public AbstractPizzaBuilder bread(Bread bread) {
        this.bread = bread;
        return this;
    }

    @Override
    public AbstractPizzaBuilder addition(Addition addition) {
        if( this.additions == null ) {
            this.additions = new ArrayList<>();
        }
        this.additions.add(addition);
        return this;
    }

    @Override
    public AbstractPizzaBuilder additions(Set<Addition> additions) {
        for(Addition addition : additions) {
            addition(addition);
        }
        return this;
    }

    @Override
    public Pizza build() {

        return new Pizza(this);
    }
}

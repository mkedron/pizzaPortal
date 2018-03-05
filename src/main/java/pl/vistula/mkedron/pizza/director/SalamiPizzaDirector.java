package pl.vistula.mkedron.pizza.director;

import pl.vistula.mkedron.pizza.builder.AbstractPizzaBuilder;
import pl.vistula.mkedron.pizza.model.Addition;
import pl.vistula.mkedron.pizza.model.Bread;
import pl.vistula.mkedron.pizza.model.Cheese;
import pl.vistula.mkedron.pizza.model.Pizza;

public class SalamiPizzaDirector extends AbstractDirector {
    public SalamiPizzaDirector(AbstractPizzaBuilder pizzaBuilder) {
        super(pizzaBuilder);
    }

    @Override
    public Pizza getProduct() {
        return pizzaBuilder
                .cheese(Cheese.CHEDAR)
                .bread(Bread.NORMAL)
                .addition(Addition.SALAMI)
                .addition(Addition.TOMATOES)
                .build();
    }
}

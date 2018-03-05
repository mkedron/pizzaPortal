package pl.vistula.mkedron.pizza.director;

import pl.vistula.mkedron.pizza.builder.AbstractPizzaBuilder;
import pl.vistula.mkedron.pizza.model.Addition;
import pl.vistula.mkedron.pizza.model.Bread;
import pl.vistula.mkedron.pizza.model.Cheese;
import pl.vistula.mkedron.pizza.model.Pizza;

public class MushroomsPizzaDirector extends AbstractDirector {
    public MushroomsPizzaDirector(AbstractPizzaBuilder pizzaBuilder) {
        super(pizzaBuilder);
    }

    @Override
    public Pizza getProduct() {
        return pizzaBuilder
                .cheese(Cheese.GOUDA)
                .bread(Bread.FLAT)
                .addition(Addition.MUSHROOMS)
                .addition(Addition.TOMATOES)
                .build();
    }
}

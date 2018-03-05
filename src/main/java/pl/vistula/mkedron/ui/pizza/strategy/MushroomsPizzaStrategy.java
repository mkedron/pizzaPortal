package pl.vistula.mkedron.ui.pizza.strategy;

import com.vaadin.ui.UI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.vistula.mkedron.pizza.Cart;
import pl.vistula.mkedron.pizza.builder.PizzaBuilder;
import pl.vistula.mkedron.pizza.director.MushroomsPizzaDirector;

@Component
public class MushroomsPizzaStrategy extends AbstractStrategy {

    @Autowired
    private Cart cart;

    @Override
    public void execute() {
        PizzaBuilder builder = new PizzaBuilder();
        MushroomsPizzaDirector director = new MushroomsPizzaDirector(builder);
        cart.addPizza(director.getProduct());
        UI.getCurrent().getNavigator().navigateTo("summaryPizza");
    }
}

package pl.vistula.mkedron.ui.pizza.strategy;

import com.vaadin.ui.UI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.vistula.mkedron.pizza.Cart;
import pl.vistula.mkedron.pizza.builder.PizzaBuilder;
import pl.vistula.mkedron.pizza.director.SalamiPizzaDirector;

@Component
public class SalamiPizzaStrategy extends AbstractStrategy {

    @Autowired
    private Cart cart;

    @Override
    public void execute() {
        PizzaBuilder builder = new PizzaBuilder();
        SalamiPizzaDirector director = new SalamiPizzaDirector(builder);
        cart.addPizza(director.getProduct());
        UI.getCurrent().getNavigator().navigateTo("summaryPizza");
    }
}

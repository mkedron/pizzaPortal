package pl.vistula.mkedron.ui.pizza.strategy;

import com.vaadin.ui.UI;
import org.springframework.stereotype.Component;

@Component
public class CustomPizzaStrategy extends AbstractStrategy {
    @Override
    public void execute() {
        UI.getCurrent().getNavigator().navigateTo("customPizza");
    }
}

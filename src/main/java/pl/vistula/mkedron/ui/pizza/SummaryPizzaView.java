package pl.vistula.mkedron.ui.pizza;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;
import pl.vistula.mkedron.pizza.Cart;
import pl.vistula.mkedron.pizza.model.Pizza;

@SpringView(name = "summaryPizza")
public class SummaryPizzaView extends VerticalLayout implements View {

    @Autowired
    private Cart cart;

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        Label label = new Label("Your cart :");
        addComponent(label);
        for(Pizza pizza : cart.getPizzas()) {
            addComponent(new Label(pizza.toString()));
        }
        addComponent(prepareAddPizzaButton());
        addComponent(prepareClearCartButton());
    }

    private Button prepareAddPizzaButton() {
        Button button = new Button("Add new pizza to the cart");
        button.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                UI.getCurrent().getNavigator().navigateTo("pizza");
            }
        });
        return button;

    }

    private Button prepareClearCartButton() {
        Button button = new Button("End session, back to main MENU");
        button.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                cart.clearCart();
                UI.getCurrent().getNavigator().navigateTo("mainView");
            }
        });
        return button;
    }
}

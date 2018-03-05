package pl.vistula.mkedron.ui;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;
import pl.vistula.mkedron.ui.pizza.strategy.AbstractStrategy;
import pl.vistula.mkedron.ui.pizza.strategy.CustomPizzaStrategy;
import pl.vistula.mkedron.ui.pizza.strategy.MushroomsPizzaStrategy;
import pl.vistula.mkedron.ui.pizza.strategy.SalamiPizzaStrategy;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@SpringView(name = "pizza")
public class PizzaMaker extends VerticalLayout implements View {

    private Map<String, AbstractStrategy> strategyList;

    @Autowired
    private SalamiPizzaStrategy salamiPizzaStrategy;

    @Autowired
    private MushroomsPizzaStrategy mushroomsPizzaStrategy;

    @Autowired
    private CustomPizzaStrategy customPizzaStrategy;

    @PostConstruct
    private void init() {
        strategyList = new HashMap<>();
        strategyList.put("salami", salamiPizzaStrategy);
        strategyList.put("mushrooms", mushroomsPizzaStrategy);
        strategyList.put("custom", customPizzaStrategy);

        addButtonToView("mainView");

        Label label = new Label("Choose your pizza : ");
        addComponent(label);
        addComponent(createPizzaButton("salami"));
        addComponent(createPizzaButton("mushrooms"));
        addComponent(createPizzaButton("custom"));
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {

    }

    private void addButtonToView(String viewName) {
        Button mainViewButton = new Button(viewName);
        mainViewButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                UI.getCurrent().getNavigator().navigateTo(viewName);
            }
        });
        addComponent(mainViewButton);
    }

    private Button createPizzaButton(String pizzaType) {
        Button pizzaButton = new Button(pizzaType);
        pizzaButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                AbstractStrategy strategy = strategyList.get(pizzaType);
                if(strategy != null) {
                    strategy.execute();
                }
            }
        });
        return pizzaButton;

    }
}

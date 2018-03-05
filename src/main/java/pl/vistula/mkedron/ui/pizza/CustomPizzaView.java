package pl.vistula.mkedron.ui.pizza;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;
import pl.vistula.mkedron.pizza.Cart;
import pl.vistula.mkedron.pizza.builder.PizzaBuilder;
import pl.vistula.mkedron.pizza.model.Addition;
import pl.vistula.mkedron.pizza.model.Bread;
import pl.vistula.mkedron.pizza.model.Cheese;
import pl.vistula.mkedron.pizza.model.Pizza;

@SpringView(name = "customPizza")
public class CustomPizzaView extends VerticalLayout implements View {

    @Autowired
    private Cart cart;

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        Button button = new Button("mainView");
        button.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                UI.getCurrent().getNavigator().navigateTo("mainView");
            }
        });
        addComponent(button);

        Label tittle = new Label("Wybierz składniki : ");
        addComponent(tittle);
        ComboBox<Cheese> cheeseComboBox = new ComboBox<>();
        cheeseComboBox.setItems(Cheese.values());
        cheeseComboBox.setSelectedItem(Cheese.GOUDA);
        addComponent(cheeseComboBox);
        ComboBox<Bread> breadComboBox = new ComboBox<>();
        breadComboBox.setItems(Bread.values());
        breadComboBox.setSelectedItem(Bread.FLAT);
        addComponent(breadComboBox);
        ListSelect<Addition> additionListSelect = new ListSelect<>();
        additionListSelect.setItems(Addition.values());
        addComponent(additionListSelect);

        Button makePizzaButton = new Button("get the Pizza !");
        makePizzaButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                PizzaBuilder pizzaBuilder = new PizzaBuilder();
                Pizza pizza = pizzaBuilder
                        .cheese(cheeseComboBox.getValue())
                        .bread(breadComboBox.getValue())
                        .additions(additionListSelect.getValue())
                        .build();
                cart.addPizza(pizza);
                UI.getCurrent().getNavigator().navigateTo("summaryPizza");

            }
        });
        addComponent(makePizzaButton);
    }
}

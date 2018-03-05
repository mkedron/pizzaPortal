package pl.vistula.mkedron.ui;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SpringView(name="mainView")
public class MainView extends VerticalLayout implements View {

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        VerticalLayout layout = new VerticalLayout();
        Label label = new Label("What do you want to buy? :");
        layout.addComponent(label);
        layout.addComponent(provideButton("pizza"));
        addComponent(layout);
    }

    private Button provideButton(String navigationName) {
        Button button1 = new Button(navigationName);
        button1.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                UI.getCurrent().getNavigator().navigateTo(navigationName);
            }
        });
        return button1;
    }

}

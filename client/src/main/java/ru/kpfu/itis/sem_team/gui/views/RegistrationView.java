package ru.kpfu.itis.sem_team.gui.views;

import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import ru.kpfu.itis.sem_team.gui.controllers.RegistrationController;
import ru.kpfu.itis.sem_team.entities.players.UnoPlayer;
import ru.kpfu.itis.sem_team.event.IEvent;
import ru.kpfu.itis.sem_team.protocol.UnoProtocol;
import ru.kpfu.itis.sem_team.util.Observable;

public class RegistrationView implements IView {
    private Boolean isValid = true;
    private RegistrationController registrationController;
    private Parent view;

    public RegistrationView(RegistrationController registrationController) {
        this.registrationController = registrationController;
        buildView();
    }

    private void buildView() {
        VBox box = new VBox();

        Label nameLabel = new Label("Enter name:");
        TextField nameField = new TextField();
        Button submitButton = new Button("Register");
        submitButton.setOnAction(event -> {
            UnoPlayer player = new UnoPlayer(nameField.getText());
            registrationController.register(player);
        });
        box.getChildren().addAll(nameLabel ,nameField, submitButton);
        if (!isValid) {
            Label errorLabel = new Label("Such name already exists");
            box.getChildren().add(errorLabel);
        }
        view = box;
    }

    @Override
    public Parent asParent() {
        return view;
    }

    @Override
    public void update(Observable o, IEvent event) {
        Integer type = (Integer) event.getParameter("type");
        String action = (String) event.getParameter("action");
        if(!(type == UnoProtocol.MESSAGE_PLAYER && action.equals("create"))) {
            return;
        }
        isValid = (Boolean) event.getParameter("valid");

        if (isValid) {
            registrationController.displayMenu();
        }
        buildView();
    }
}

package sample;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.Accounts;
import java.sql.BatchUpdateException;
import java.util.ArrayList;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        ArrayList<Accounts> accounts = new ArrayList<>();

        BorderPane login = new BorderPane();
        Scene loginScene = new Scene(login, 400, 400);

        BorderPane signupScreen = new BorderPane();
        Scene signupScene = new Scene(signupScreen, 400, 400);

        BorderPane homePage = new BorderPane();
        Scene homeScene = new Scene(homePage, 400, 400);

        VBox loginCenter = new VBox();
        VBox signupCenter = new VBox();
        loginCenter.setAlignment(Pos.CENTER);

        TextField usernameTF = new TextField();
        usernameTF.setPromptText("Enter Username");
        TextField passwordTF = new TextField();
        passwordTF.setPromptText("Enter Password");

        TextField suLastNameTF = new TextField();
        suLastNameTF.setPromptText("Enter LastName");
        TextField suUsernameTF = new TextField();
        suUsernameTF.setPromptText("Enter Username");
        TextField suPasswordTF = new TextField();
        suPasswordTF.setPromptText("Enter Password");
        TextField suPasswordConfirmTF = new TextField();
        suPasswordConfirmTF.setPromptText("Confim Password");

        Button signupButton = new Button("Sign Up");
        Button loginButton = new Button("Log In");

        Button suRegister = new Button("Register");

        Label matching = new Label();
        Label retry = new Label();

        loginCenter.getChildren().addAll(usernameTF, passwordTF, loginButton, signupButton);
        signupCenter.getChildren().addAll(suLastNameTF,suUsernameTF,suPasswordTF,suPasswordConfirmTF, matching, suRegister,retry);

        signupButton.setOnAction( event ->  primaryStage.setScene(signupScene) );

        suPasswordConfirmTF.textProperty().addListener( (temp, test, test1) -> {
            matching.setText( (suPasswordConfirmTF.getText().equals(suPasswordTF.getText()))? "Passwords Match" : "Passwords Do Not Match");
        } );

        loginButton.setOnAction( event -> {
            System.out.println();
            String usernameInput = usernameTF.getText();
            String passwordInput = passwordTF.getText();
            for( Accounts account : accounts)
            {
                if(account.getUsername().equals(usernameInput) && account.getPassword().equals(passwordInput))
                {
                    primaryStage.setScene(homeScene);
                }
            }
        } );

        suRegister.setOnAction( event -> {
            boolean userExists = false;
            Accounts tempAccount = new Accounts(suUsernameTF.getText(), suPasswordTF.getText(), suLastNameTF.getText());
            for(Accounts account : accounts)
            {
                System.out.println(account.equals(tempAccount));
                System.out.println(tempAccount.toString());
                if(account.equals(new Accounts(suUsernameTF.getText(), suPasswordTF.getText(), suLastNameTF.getText())))
                {
                    retry.setText("This account already exists");
                    userExists = true;
                    break;
                }
            }

            if(matching.getText().equals("Passwords Match") && !userExists)
            {
                accounts.add(new Accounts(suUsernameTF.getText(), suPasswordTF.getText(), suLastNameTF.getText()));
                System.out.println("working" + userExists + accounts.toString());

            }
        });

        signupScreen.setCenter(signupCenter);
        login.setCenter(loginCenter);
        primaryStage.setTitle("Login System 2");
        primaryStage.setScene(loginScene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

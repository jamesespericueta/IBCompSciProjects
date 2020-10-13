package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import sample.Student;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Main extends Application {
    /*
    store the usernames and the passwords with the student objects
     */
    String filename = "students.ser";
    ArrayList<Student> studentList = new ArrayList<>();
    BorderPane root = createLogin();

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane root = createLogin();

        Scene login = new Scene(root);
        //Scene interact = new Scene();
        primaryStage.setScene(login);
        primaryStage.show();

    }

    public void storeStudent(Student student)
    {
        try
        {
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);

            out.writeObject(student);

            out.close();
            file.close();
            System.out.println("Object serialized");
        }
        catch (IOException ex)
        {
            System.out.println("IO Exception has been caught bc you're trash");
        }
    }


    public BorderPane createLogin()
    {
        BorderPane root = new BorderPane();
        VBox center = new VBox();
        center.setAlignment(Pos.CENTER);

        // creating the components
        TextField usernameInput = new TextField();
        PasswordField passwordInput = new PasswordField();
        usernameInput.setMaxWidth(200);
        passwordInput.setMaxWidth(200);
        usernameInput.setPromptText("Enter Your Username");
        passwordInput.setPromptText("Enter your password");

        Label warning = new Label();

        Button loginButton = new Button("Log in");
        Button addUser = new Button("Add User");

        loginButton.setOnAction( event -> {
            for (int i = 0; i < studentList.size(); i++)
            {
                String username = studentList.get(i).getUsername();
                String password = studentList.get(i).getPassword();
                if( usernameInput.getText().equals(username) && passwordInput.getText().equals(password) )
                {
                    warning.setText("success");
                }
                else
                {
                    warning.setText("you are a failure");
                }
            }
        });
        addUser.setOnAction( event -> {

        });

        center.getChildren().addAll(usernameInput, passwordInput, warning, addUser, loginButton);
        root.setCenter(center);


        return root;
    }
    public BorderPane createDataFetch()
    {
        BorderPane DataBaseUX = new BorderPane();

        return DataBaseUX;
    }

    public static void main(String[] args) {
        launch(args);
    }
}

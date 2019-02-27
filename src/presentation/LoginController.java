/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import com.jfoenix.controls.JFXDecorator;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Oliver
 */
public class LoginController implements Initializable
{

    private double xOffset = 0;
    private double yOffset = 0;

    @FXML
    private Label message;
    @FXML
    private JFXTextField username;
    @FXML
    private JFXPasswordField password;

    private InteractionCommunicatior interactionCommunicatior = new InteractionCommunicatior();

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        username.textProperty().addListener((observable, oldValue, newValue) ->
        {
            if (!newValue.isEmpty() && username.getStyleClass().contains("wrong-credentials"))
            {
                username.getStyleClass().remove("wrong-credentials");
                message.setText("");
            } 
        });

        password.textProperty().addListener((observable, oldValue, newValue) ->
        {
            if (!newValue.isEmpty()&& password.getStyleClass().contains("wrong-credentials"))
            {
                password.getStyleClass().remove("wrong-credentials");
                message.setText("");
            }
        });
    }

    @FXML
    private void handleLoginButtonAction(ActionEvent event)
    {
        List<String[]> sqlReturn = interactionCommunicatior.sendLogin(username.getText(), password.getText());

        if (!sqlReturn.isEmpty())
        {
            Iterator<String[]> it = sqlReturn.iterator();
            while (it.hasNext())
            {
                for (String s : it.next())
                {
                    System.out.println(s);
                }
            }
            loadMain();
            closeStage();
        } else if (username.getText().isEmpty() || password.getText().isEmpty())
        {
            System.err.println("Please enter a username and a password!");
            message.setText("Please enter a username and a password!");
            username.getStyleClass().add("wrong-credentials");
            password.getStyleClass().add("wrong-credentials");
        } else
        {
            System.err.println("Wrong username or password!");
            message.setText("Wrong username or password!");
            username.setText("");
            password.setText("");
            username.getStyleClass().add("wrong-credentials");
            password.getStyleClass().add("wrong-credentials");

        }
    }

    @FXML
    private void handleCancelButtonAction(ActionEvent event)
    {
        System.exit(0);
    }

    private void closeStage()
    {
        ((Stage) username.getScene().getWindow()).close();
    }

    void loadMain()
    {
        try
        {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

            stage.setTitle("Sanitas Overview");
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }

    }

}

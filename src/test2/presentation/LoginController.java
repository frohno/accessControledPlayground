/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test2.presentation;

import com.jfoenix.controls.JFXDecorator;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
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
    
    private InteractionCommunicatior interactionCommunicatior;


    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        interactionCommunicatior = new InteractionCommunicatior();
    }
    
    @FXML
    private void handleLoginButtonAction(ActionEvent event)
    {
        List<String[]> sqlReturn = interactionCommunicatior.sendLogin(username.getText(), password.getText());
        if (!sqlReturn.isEmpty())
        {
            try
            {
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.hide();
                Parent root = FXMLLoader.load(getClass().getResource("admin.fxml"));
                JFXDecorator decorator = new JFXDecorator(stage, root);
                decorator.setCustomMaximize(true);
                //decorator.setGraphic(new SVGGlyph());

                stage.setTitle("Sanitas Overview | Administation");

                Scene scene = new Scene(decorator, 1297, 829);
                scene.getStylesheets().add(getClass().getResource("mainWindow.css").toExternalForm());
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex)
            {
                ex.printStackTrace();
            }

        } else if (username.getText().isEmpty() || password.getText().isEmpty())
        {
            System.err.println("Please enter a username and a password!");
            message.setText("Please enter a username and a password!");
        } else
        {
            System.err.println("Wrong username or password!");
            message.setText("Wrong username or password!");
            username.setText("");
            password.setText("");

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
            Parent root = FXMLLoader.load(getClass().getResource("/library/assistant/ui/main/main.fxml"));
            root.setOnMousePressed(new EventHandler<MouseEvent>()
            {
                @Override
                public void handle(MouseEvent event)
                {
                    xOffset = event.getSceneX();
                    yOffset = event.getSceneY();
                }
            });
            root.setOnMouseDragged(new EventHandler<MouseEvent>()
            {
                @Override
                public void handle(MouseEvent event)
                {
                    stage.setX(event.getScreenX() - xOffset);
                    stage.setY(event.getScreenY() - yOffset);
                }
            });
            Scene scene = new Scene(root);
            stage.initStyle(StageStyle.UNDECORATED);

            stage.setScene(scene);
            stage.show();

            stage.setTitle("Library Assistant");
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }

}

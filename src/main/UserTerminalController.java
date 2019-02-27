/*This is code written by Frederik Alexander Hounsvad
 * The use of this code in a non commercial and non exam environment is permitted
 */
package main;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Pinnacle F
 */
public class UserTerminalController implements Initializable {

    @FXML
    private Button testButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        testButton.setOnAction((event) -> {
            System.out.println("Button pressed");
        });
    }

    public void resize() {
        ((Stage) testButton.getScene().getWindow()).setMinWidth(1200);
        ((Stage) testButton.getScene().getWindow()).setMinHeight(800);
    }

}

/*This is code written by Frederik Alexander Hounsvad
 * The use of this code in a non commercial and non exam environment is permitted
 */
package main;

import com.google.common.hash.Hashing;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author Pinnacle F
 */
public class LoginTerminalController implements Initializable {

    @FXML
    private JFXTextField username;
    @FXML
    private JFXPasswordField password;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    //53a6868467a74b499b33a861c4e5f35f9b55774f83f3c5d33cf469c656a95253 = Admin Administrator
    @FXML
    private void pressLogIn(ActionEvent event) throws IOException {
        String cleanUsername = scrubString(username.getText());
        String hash = hashString(cleanUsername + password.getText());
        if (verifyCredentials(cleanUsername, hash)) {
            username.getScene().setRoot(FXMLLoader.load(getClass().getResource("UserTerminal.fxml")));

        }
    }

    private String scrubString(String input) {
        return input.replaceAll("[^ABCDEFGHIJKLMNOPQRSTUVXYZÆØÅabcdefghijklmnopqrstuvxyzæøå1234567890]", "");
    }

    private String hashString(String input) {
        return Hashing.sha256().hashString(input, StandardCharsets.UTF_8).toString();
    }

    private boolean verifyCredentials(String username, String hash) {
        return username.equalsIgnoreCase("Admin") && hash.equalsIgnoreCase("53a6868467a74b499b33a861c4e5f35f9b55774f83f3c5d33cf469c656a95253");
    }

}

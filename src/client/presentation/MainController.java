/*This is code written by Frederik Alexander Hounsvad
 * The use of this code in a non commercial and non exam environment is permitted
 */
package client.presentation;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.SubScene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

/**
 * FXML Controller class
 *
 * @author Pinnacle F
 */
public class MainController implements Initializable {

    @FXML
    private Label labelProgress;
    @FXML
    public SubScene ss;

    private TestController tc1;

    private double originalX = 1200;
    private double originalY = 800 - (25 + 17);

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ((StackPane) labelProgress.getParent()).widthProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                ss.setWidth((Double) newValue);

                //System.out.println("Width: " + (Double)newValue + "Scale: " + (ss.getWidth()/originalX));
            }
        });
        ((StackPane) labelProgress.getParent()).heightProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                ss.setHeight(((Double) newValue) - (25 + 17));
                //System.out.println("Height: " + (((Double)newValue)-(25+17)) + "Scale: " + (ss.getHeight()/originalY));
            }
        });

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML1.fxml"));
            Parent root = loader.load();
            ss.setRoot(root);
            /*
            tc1 = loader.getController();
            tc1.setsss(ss);*/
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    @FXML
    private void loadOne() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML1.fxml"));
            Parent root = loader.load();
            ss.setRoot(root);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void loadTwo() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML2.fxml"));
            Parent root = loader.load();
            ss.setRoot(root);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}

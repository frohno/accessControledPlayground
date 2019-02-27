/*This is code written by Frederik Alexander Hounsvad
 * The use of this code in a non commercial and non exam environment is permitted
 */
package presentation;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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
    private SubScene ss;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ((StackPane)labelProgress.getParent()).widthProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                ss.setWidth((Double)newValue);
                System.out.println("Width: " + (Double)newValue);
            }
        });
        ((StackPane)labelProgress.getParent()).heightProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                ss.setHeight(((Double)newValue)-(25+17));
                System.out.println("Height: " + (((Double)newValue)-(25+17)));
            }
        });
        
        try
        {
            ss.setRoot(FXMLLoader.load(getClass().getResource("test.fxml")));
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }
        
    }
    
}

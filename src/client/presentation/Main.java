
/*This is code written by Frederik Alexander Hounsvad
 * The use of this code in a non commercial and non exam environment is permitted
 */
package client.presentation;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Pinnacle F
 */
public class Main extends Application {
    
    public double xOffset = 0;
    public double yOffset = 0;
    
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
        Parent root = loader.load();
        root.setOnMousePressed(event -> {
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        });
        root.setOnMouseDragged(event -> {
            stage.setX(event.getScreenX() - xOffset);
            stage.setY(event.getScreenY() - yOffset);
        });
        stage.initStyle(StageStyle.UNDECORATED);
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("css/dark-theme.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

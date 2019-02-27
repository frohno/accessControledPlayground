/*
 * Copyright (C) 2019 Oliver.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301  USA
 */
package presentation;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.SubScene;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Oliver
 */
public class TestController implements Initializable
{

    @FXML
    private Label message;
    
    private SubScene ss = null;

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {

    }

    public void setsss(SubScene ss) {
        this.ss = ss;
    }
    
    

    @FXML
    private void accept()
    {
        try
        {
            ss.setRoot(FXMLLoader.load(getClass().getResource("test2.fxml")));
            
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }
    
    @FXML
    private void decline()
    {
        message.setVisible(true);
    }

}

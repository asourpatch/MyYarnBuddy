/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package myyarnbuddy;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Amanda
 */
public class MyYarnBuddy extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Main.fxml"));
        Parent root = (Parent) loader.load();
        
        SceneController sc = loader.getController();
        
        Model model = new Model();
        sc.initModel(model);
        
        Scene scene = new Scene(root);

        String css = getClass().getResource("stylesheet1.css").toExternalForm();
        scene.getStylesheets().add(css);

        stage.setTitle("MyYarnBuddy");

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

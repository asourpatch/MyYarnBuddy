package myyarnbuddy.java.main;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */


import myyarnbuddy.java.model.Model;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import myyarnbuddy.java.controllers.SceneController;

/**
 *
 * @author Amanda
 */
public class MyYarnBuddy extends Application implements Serializable{

    public Model deserialize() throws FileNotFoundException, IOException{
        Model model = new Model();
        try {
            System.out.println("DESERIALIZING...");
            File file = new File("Projects.ser");
            // Don't deserialize empty file
            if(file.length() <= 1){
                System.out.println("Empty file.");
                return model;
            }
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            model = (Model) ois.readObject();
            ois.close();
            fis.close();
            System.out.println("Done.");
	} catch(EOFException e){
            e.printStackTrace();
        } catch(ClassNotFoundException ex) {
            ex.printStackTrace();
	}
        return model;
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        URL fxmlURL = getClass().getResource("/myyarnbuddy/resources/view/Main.fxml");
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(fxmlURL);
        Parent root = (Parent) loader.load();
        
        SceneController sc = loader.getController();
        
        Model model = deserialize();
        sc.initModel(model);
        
        Scene scene = new Scene(root);

        String css = getClass().getResource("/myyarnbuddy/resources/css/stylesheet.css").toExternalForm();
        scene.getStylesheets().add(css);

        stage.setTitle("MyYarnBuddy");

        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    

}

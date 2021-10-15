/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myyarnbuddy;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Amanda
 */
public class SceneController {
    // @FXML
    
    private Stage stage;
    private Scene scene;
    private Parent root;
    
    public void switchToMain(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
        
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    public void switchToNewProject(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("NewProject.fxml"));
        
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    public void switchToCurrProj(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("CurrProject.fxml"));
        
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    public void switchToWIPPage(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("WIPPage.fxml"));
        
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    public void switchToCompProjPage(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("CompProjPage.fxml"));
        
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    public void switchToCompProjDetails(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("CompProjDetails.fxml"));
        
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    public void quitBtn(){
        System.exit(0);
    }
}

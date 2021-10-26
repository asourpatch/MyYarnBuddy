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
    private Stage stage;
    private Scene scene;
    private Parent root;
    private Model model;
    
    public void initModel(Model m){
        if(this.model != null){
            throw new IllegalStateException("Mdoel can only be initialized once");
        }
        this.model = m;
    }
    
    public void switchToMain(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("Main.fxml"));
        
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("stylesheet1.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }
    
    public void switchToNewProject(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("NewProject.fxml"));
        root = loader.load();
        
        NewProjectController npc = loader.getController();
        npc.initModel(model);
        npc.getSC(this);
        
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        //scene.getStylesheets().add(getClass().getResource("stylesheet2.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }
    
    public void switchToCurrProj(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("CurrProject.fxml"));
        root = loader.load();
        
        CurrProjectController cpc = loader.getController();
        cpc.initModel(model);
        cpc.getSC(this);
        
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        //scene.getStylesheets().add(getClass().getResource("stylesheet3.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }
    
    public void switchToWIPPage(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("WIPPage.fxml"));
        
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        //scene.getStylesheets().add(getClass().getResource("stylesheet4.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }
    
    public void switchToCompProjPage(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("CompProjPage.fxml"));
        
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        //scene.getStylesheets().add(getClass().getResource("stylesheet5.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }
    
    public void switchToCompProjDetails(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("CompProjDetails.fxml"));
        
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        //scene.getStylesheets().add(getClass().getResource("stylesheet6.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }
    
    public void quitBtn(){
        System.exit(0);
    }
}

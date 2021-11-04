/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myyarnbuddy.java.controllers;

import myyarnbuddy.java.controllers.NewProjectController;
import myyarnbuddy.java.model.Model;
import myyarnbuddy.java.controllers.CurrProjectController;
import myyarnbuddy.java.controllers.CompProjPageController;
import myyarnbuddy.java.controllers.CompProjDetailsController;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.URL;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Amanda
 */
public class SceneController implements Serializable{
    private Stage stage;
    private Scene scene;
    private Parent root;
    private Model model;
    private final String filename = "Projects.ser";
    
    public void initModel(Model m) throws IOException{
        if(this.model != null){
            throw new IllegalStateException("Model can only be initialized once");
        }
        this.model = m;
    }
    
    public void serialize(){
        try {
            System.out.println("SERIALIZING...");
            File file = new File(filename);
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(model);
            oos.close();
            fos.close();
            System.out.println("Done.");

        } catch(IOException ex) {
            System.out.println("IOException is caught");
        }
    }
    
    @FXML
    public void switchToMain(ActionEvent event) throws IOException{
        URL fxmlURL = getClass().getResource("/myyarnbuddy/resources/view/Main.fxml");
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(fxmlURL);
        root = (Parent) loader.load();
        
        SceneController sc = loader.getController();
        sc.initModel(model);
        
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/myyarnbuddy/resources/css/stylesheet1.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    public void switchToNewProject(ActionEvent event) throws IOException{
        URL fxmlURL = getClass().getResource("/myyarnbuddy/resources/view/NewProject.fxml");
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(fxmlURL);
        root = (Parent) loader.load();
        
        NewProjectController npc = loader.getController();
        npc.initModel(model);
        npc.getSC(this);
        
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        //scene.getStylesheets().add(getClass().getResource("stylesheet2.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    public void switchToCurrProj(ActionEvent event) throws IOException{
        URL fxmlURL = getClass().getResource("/myyarnbuddy/resources/view/CurrProject.fxml");
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(fxmlURL);
        root = (Parent) loader.load();
        
        CurrProjectController cpc = loader.getController();
        cpc.initModel(model);
        cpc.getSC(this);
        
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        //scene.getStylesheets().add(getClass().getResource("stylesheet3.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    public void switchToWIPPage(ActionEvent event) throws IOException{
        URL fxmlURL = getClass().getResource("/myyarnbuddy/resources/view/WIPPage.fxml");
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(fxmlURL);
        root = (Parent) loader.load();
        
        WIPController wc = loader.getController();
        wc.initModel(model);
        wc.getSC(this);
        
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        //scene.getStylesheets().add(getClass().getResource("stylesheet4.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    public void switchToCompProjPage(ActionEvent event) throws IOException{
        URL fxmlURL = getClass().getResource("/myyarnbuddy/resources/view/CompProjPage.fxml");
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(fxmlURL);
        root = (Parent) loader.load();
        
        CompProjPageController cppc = loader.getController();
        cppc.iniModel(model);
        cppc.getSC(this);
        
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        //scene.getStylesheets().add(getClass().getResource("stylesheet5.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    public void switchToCompProjDetails(ActionEvent event) throws IOException{
        URL fxmlURL = getClass().getResource("/myyarnbuddy/resources/view/CompProjDetails.fxml");
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(fxmlURL);
        root = (Parent) loader.load();
        
        CompProjDetailsController cpdc = loader.getController();
        cpdc.initModel(model);
        cpdc.getSC(this);
        
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        //scene.getStylesheets().add(getClass().getResource("stylesheet6.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    public void quitBtn(){
        serialize();
        System.exit(0);
    }
}

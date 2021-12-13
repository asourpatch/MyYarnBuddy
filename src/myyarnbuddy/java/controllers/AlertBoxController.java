/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myyarnbuddy.java.controllers;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Amanda
 */
public class AlertBoxController {
    private Stage stage;
    private boolean ays;
    
    @FXML
    private Label errorLabel;
    @FXML
    private Button okBtn;

    public void display(boolean name, boolean yarn, boolean size) throws IOException{
        stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/myyarnbuddy/resources/view/AlertBox.fxml"));
        Parent root = loader.load();
        
        AlertBoxController abc = loader.getController();
        abc.setLabel(name, yarn, size);
        
        Scene scene = new Scene(root);
        
        scene.getStylesheets().add(getClass().getResource("/myyarnbuddy/resources/css/stylesheetpopout.css").toExternalForm());

        
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Error");
        
        stage.setScene(scene);
        stage.setResizable(false);
        stage.showAndWait();
    }
    
    public boolean display() throws IOException {
        stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/myyarnbuddy/resources/view/AreYouSureAlertBox.fxml"));
        Parent root = loader.load();
        
        AlertBoxController abc = loader.getController();
        
        Scene scene = new Scene(root);
        
        scene.getStylesheets().add(getClass().getResource("/myyarnbuddy/resources/css/stylesheetpopout.css").toExternalForm());

        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Are You Sure?");
        
        stage.setScene(scene);
        stage.setResizable(false);
        stage.showAndWait();
        
        return abc.getStatus();
    }

    public void setLabel(boolean n, boolean y, boolean s){
        String errorMessage = "";
        if(n) {
            errorMessage += "Project name is empty.\n";
        }if(y){
            errorMessage += "Yarn list is empty.\n";
        }if(s){
            errorMessage += "Hook/Needle size is empty.\n";
        }
        
        errorLabel.setText(errorMessage);
    }
    
    @FXML
    void okBtn(ActionEvent event) {
        stage = (Stage) okBtn.getScene().getWindow();
        stage.close();
    }
    
    // AreYouSureBox
    
    @FXML
    private Button noBtn;
    @FXML
    private Button yesBtn;

    @FXML
    void no(ActionEvent event) {
        ays = false;
        stage = (Stage) noBtn.getScene().getWindow();
        stage.close();
    }

    @FXML
    void yes(ActionEvent event) {
        ays = true;
        stage = (Stage) yesBtn.getScene().getWindow();
        stage.close();
    }
    
    public boolean getStatus(){
        return ays;
    }
}

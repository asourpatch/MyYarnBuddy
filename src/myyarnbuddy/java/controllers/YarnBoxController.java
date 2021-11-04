/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myyarnbuddy.java.controllers;

import myyarnbuddy.java.model.Yarn;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Amanda
 */
public class YarnBoxController {
    private Stage yarnStage;
    private Yarn newYarn;
    
    @FXML private TextField ycolor;
    @FXML private TextField ycontent;
    @FXML private TextField yname;
    @FXML private TextField yweight;
    @FXML private Button addBtn;
    @FXML private Button yCancelBtn;
    
    public Yarn getYarn(){
        return newYarn;
    }
    
    @FXML
    public void savingYarnToBox(){
        String name = yname.getText();
        String color = ycolor.getText();
        String weight = yweight.getText();
        String content = ycontent.getText();  
        
        this.newYarn = new Yarn(name, color, weight, content);
        
        yarnStage = (Stage) addBtn.getScene().getWindow();
        yarnStage.close();
    }
    
    @FXML
     public void closeBox(){
        this.newYarn = null;
        yarnStage = (Stage) yCancelBtn.getScene().getWindow();
        yarnStage.close();
    }
    
}

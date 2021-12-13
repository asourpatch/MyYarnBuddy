/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myyarnbuddy.java.controllers;

import myyarnbuddy.java.model.Component;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import myyarnbuddy.java.model.Model;
import myyarnbuddy.java.model.Project;

/**
 *
 * @author Amanda
 */
public class CurrProjectController {
    private Model model;
    private Project project;
    private Component component;
    private SceneController sc;
    private int counter;
    
    @FXML
    private Label count;
    @FXML
    private TextArea notesBox;
    @FXML
    private Label pName;
    @FXML
    private Button typeBtn;
    @FXML
    private Label typeLabel;
    
    public void initModel(Model m){
        if(this.model != null){
            throw new IllegalStateException("Model can only be initialized once");
        }
        this.model = m;
        
        project = model.getCurrProject();
        component = project.getComponent();
        counter = component.getCount();
        pName.setText(project.getName());
        typeBtn.setText(component.oppType());
        typeLabel.setText(component.getType());
        count.setText(Integer.toString(component.getCount()));
        notesBox.setText(component.getNotes());
    }
    
    public void getSC(SceneController sc){
        this.sc = sc;
    }
    
    @FXML
    public void changeTypeBtn(ActionEvent event) {
        component.setType(component.oppType());
        typeBtn.setText(component.oppType());
        typeLabel.setText(component.getType());
    }

    @FXML
    public void completeBtn(ActionEvent event) throws IOException {
        component.setNotes(notesBox.getText());
        project.done();
        model.getCompProjectList().add(project);
        model.getProjectList().remove(project);
        model.setCurrProject(null);
        sc.switchToMain(event);
    }

    @FXML
    public void decrementBtn(ActionEvent event) {
        decrement();
    }
    
    private void decrement(){
        if(counter == 0){
            return;
        } else{
            counter--;
            count.setText(Integer.toString(counter));
            component.setCount(counter);
        }
    }
 
    private Stage editStage;
    @FXML
    public void editBtn(ActionEvent event) throws IOException{
        editStage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/myyarnbuddy/resources/view/EditCurrProj.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        
        EditCurrProjController ecpc = loader.getController();
        ecpc.setProject(project);
        
        scene.getStylesheets().add(getClass().getResource("/myyarnbuddy/resources/css/stylesheet.css").toExternalForm());

        editStage.initModality(Modality.APPLICATION_MODAL);
        editStage.setTitle("Editing Project Details");
        
        editStage.setScene(scene);
        editStage.setResizable(false);
        editStage.showAndWait();
        
        if(ecpc.getProject() == null){
            return;
        }
        
        Project ecpcProject = ecpc.getProject();
        project.setName(ecpcProject.getName());
        pName.setText(ecpcProject.getName());
        project.setYarnList(ecpcProject.getYarnList());
        project.setCraft(ecpcProject.getCraft());
        project.setSize(ecpcProject.getSize());
        project.setStartDate(ecpcProject.getStartDate());
    }
    
    @FXML
    public void incrementBtn(ActionEvent event) {
        increment();
    }
    
    private void increment(){
        counter++;
        count.setText(Integer.toString(counter));
        component.setCount(counter);
    }

    @FXML
    public void resetBtn(ActionEvent event) {
        counter = 0;
        count.setText("0");
        component.setCount(0);
    }
    
    @FXML
    public void saveQuitBtn(ActionEvent event) throws IOException{
        if(!model.getProjectList().contains(project)){
            model.getProjectList().add(project);
        }
        component.setNotes(notesBox.getText());
        model.setCurrProject(null);
        sc.switchToMain(event);
    }
  
}

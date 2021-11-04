/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myyarnbuddy.java.controllers;

import myyarnbuddy.java.controllers.AlertBoxController;
import java.io.IOException;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import myyarnbuddy.java.model.Model;
import myyarnbuddy.java.model.Project;

/**
 *
 * @author Amanda
 */
public class CompProjPageController {
    private Model model;
    private ArrayList<Project> projList;
    private ObservableList<Project> oProjList;
    private SceneController sc;
    private int selectedIndex = -1;
    
    @FXML
    private Button backBtn, deleteBtn, viewBtn;
    @FXML
    private ListView<Project> projectListView;
    
    public void iniModel(Model m){
        this.model = m;
        
        this.projList = m.getCompProjectList();
        this.oProjList = FXCollections.observableArrayList(this.projList);
        projectListView.setItems(oProjList);
    }
    
    public void getSC(SceneController s){
        this.sc = s;
    }
    
    @FXML
    void backToMain(ActionEvent event) throws IOException {
        sc.switchToMain(event);
    }

    @FXML
    void deleteProject(ActionEvent event) throws IOException {
        selectedIndex = projectListView.getSelectionModel().getSelectedIndex();
        
        if(selectedIndex < 0){
            return;
        }
        
        AlertBoxController abc = new AlertBoxController();
        boolean status = abc.display();

        if(status){
            projList.remove(selectedIndex);
            projectListView.getItems().remove(selectedIndex);
        }
    }

    @FXML
    void viewProject(ActionEvent event) throws IOException {
        selectedIndex = projectListView.getSelectionModel().getSelectedIndex();
        
        if(selectedIndex < 0){
            return;
        }
        model.setCurrProject(projList.get(selectedIndex));
        
        sc.switchToCompProjDetails(event);
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myyarnbuddy.java.controllers;

import myyarnbuddy.java.controllers.AlertBoxController;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Modality;
import javafx.stage.Stage;
import myyarnbuddy.java.model.Project;
import myyarnbuddy.java.model.Yarn;

/**
 *
 * @author Amanda
 */
public class EditCurrProjController {
    private Project project;
    private ArrayList<Yarn> yarnList;
    private ObservableList<Yarn> oYarnList;
    private String craftType;
    private Stage editStage;
    
    @FXML
    private Button addYarnBtn, removeYarnBtn,saveBtn, cancelBtn;
    @FXML
    private ToggleGroup craft;
    @FXML
    private RadioButton crochet, knitting;
    @FXML
    private TextField projName, size;
    @FXML
    private DatePicker sDate;
    @FXML
    private Label startNewTitle;
    @FXML
    private ListView<Yarn> yarnListView;
    
    public void setProject(Project p){
        this.project = p;
        setYarnList();
        
        projName.setText(this.project.getName());
        oYarnList = FXCollections.observableArrayList(this.yarnList);
        yarnListView.setItems(oYarnList);
        if(this.project.getCraft().equals("CROCHET")){
            crochet.setSelected(true);
        } else {
            knitting.setSelected(true);
        }
        size.setText(this.project.getSize());
        sDate.setValue(this.project.getStartDate());
        
    };
    
    public Project getProject(){
        return this.project;
    }
    
    public void setYarnList(){
        this.yarnList = this.project.getYarnList();
    }
    
    @FXML
    void addYarn(ActionEvent event) throws IOException {
        Stage yarnStage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/myyarnbuddy/resources/view/YarnBox.fxml"));
        Parent yarnRoot = loader.load();
        Scene yarnScene = new Scene(yarnRoot);
        
        YarnBoxController ybc = loader.getController();

        yarnStage.initModality(Modality.APPLICATION_MODAL);
        yarnStage.setTitle("Adding to Yarn List");
        
        yarnStage.setScene(yarnScene);
        yarnStage.showAndWait();
        
        Yarn newYarn = ybc.getYarn();
        
        if(newYarn != null){
            yarnList.add(newYarn);
            oYarnList = FXCollections.observableArrayList(yarnList);
            yarnListView.setItems(oYarnList);
        }
    }

    @FXML
    void cancelBtn(ActionEvent event) {
        editStage = (Stage) cancelBtn.getScene().getWindow();
        editStage.close();
    }

    @FXML
    void getCraftType(ActionEvent event) {
        if(crochet.isSelected()){
            craftType = "CROCHET";
        } else if (knitting.isSelected()){
            craftType = "KNITTING";
        }
    }

    // For index of yarnListView
    private int selectedIndex = -1;
    
    @FXML
    void removeYarn(ActionEvent event) {
        selectedIndex = yarnListView.getSelectionModel().getSelectedIndex();
        
        if(selectedIndex < 0){
            return;
        }
        
        yarnList.remove(selectedIndex);
        yarnListView.getItems().remove(selectedIndex);
    }

    @FXML
    void save(ActionEvent event) throws IOException {
        String name = projName.getText();
        String sizeS = size.getText();
        LocalDate date = sDate.getValue();
        
        // true is empty
        boolean nbool = false;
        boolean ybool = yarnList.isEmpty();
        boolean sbool = false;
        if(name.equals("")){
            nbool = true;
        } if(sizeS.equals("")){
            sbool = true;
        }
        
        if(nbool == true || ybool == true || sbool == true){
            AlertBoxController abc = new AlertBoxController();
            abc.display(nbool, ybool, sbool);
            return;
        }
        
        this.project.setName(name);
        this.project.setCraft(craftType);
        this.project.setSize(sizeS);
        this.project.setStartDate(date);
        
        editStage = (Stage) cancelBtn.getScene().getWindow();
        editStage.close();
    }
}

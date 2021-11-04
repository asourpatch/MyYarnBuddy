/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myyarnbuddy.java.controllers;

import java.io.IOException;
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
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Modality;
import javafx.stage.Stage;
import myyarnbuddy.java.model.Model;
import myyarnbuddy.java.model.Project;
import myyarnbuddy.java.model.Yarn;

/**
 *
 * @author Amanda
 */
public class CompProjDetailsController {
    private Model model;
    private Project project;
    private String craftType;
    private ArrayList<Yarn> yarnList;
    private ObservableList<Yarn> oYarnList;
    private SceneController sc;
    private int selectedIndex = -1;
    
    @FXML
    private Button addYarnBtn, doneBtn, removeYarnBtn, saveBtn;
    @FXML
    private ToggleGroup craft;
    @FXML
    private RadioButton crochetBtn, knittingBtn;
    @FXML
    private DatePicker fDate, sDate;
    @FXML
    private TextField pName, size;
    @FXML
    private ListView<Yarn> yarnListView;

    public void initModel(Model m){
        this.model = m;
        
        this.project = m.getCurrProject();
        this.yarnList = project.getYarnList();
        
        pName.setText(project.getName());
        oYarnList = FXCollections.observableArrayList(yarnList);
        yarnListView.setItems(oYarnList);
        craftType = project.getCraft();
        if(craftType.equals("CROCHET")){
            crochetBtn.setSelected(true);
        } else {
            knittingBtn.setSelected(true);
        }
        size.setText(project.getSize());
        sDate.setValue(project.getStartDate());
        fDate.setValue(project.getFinishDate());
    }
    
    public void getSC(SceneController s){
        this.sc = s;
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
    void done(ActionEvent event) throws IOException {
        // Doesn't save
        model.setCurrProject(null);
        sc.switchToCompProjPage(event);
    }
    
    @FXML
    void getCraftType(ActionEvent event) {
        if(crochetBtn.isSelected()){
            craftType = "CROCHET";
        } else if (knittingBtn.isSelected()){
            craftType = "KNITTING";
        }
    }

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
    void saveProject(ActionEvent event) throws IOException {
        project.setName(pName.getText());
        project.setYarnList(yarnList);
        project.setCraft(craftType);
        project.setSize(size.getText());
        project.setStartDate(sDate.getValue());
        project.setFinishDate(fDate.getValue());
        
        sc.switchToCompProjPage(event);
    }
}

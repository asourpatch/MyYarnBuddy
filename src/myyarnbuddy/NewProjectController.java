/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myyarnbuddy;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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

/**
 *
 * @author Amanda
 */
public class NewProjectController implements Initializable{
    private Project newProject;
    private ArrayList<Yarn> yarnList;
    private ObservableList<Yarn> oYarnList;
    private Yarn yarn;
    private String craftType;
    private SceneController sc;
    private Model model;
    
    @FXML
    private Button addYarnBtn, beginBtn, cancelBtn, removeYarnBtn;
    @FXML
    private ToggleGroup craft;
    @FXML
    private RadioButton crochet, knitting;
    @FXML
    private TextField newProjName, newSize;
    @FXML
    private DatePicker sDate;
    @FXML
    private Label startNewTitle;
    @FXML 
    private ListView<Yarn> yarnListView;

    public NewProjectController() {
        this.yarnList = new ArrayList<>();
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
    }
    
    public void initModel(Model m){
        if(this.model != null){
            throw new IllegalStateException("Mdoel can only be initialized once");
        }
        this.model = m;
    }
    
    public void getSC(SceneController sc){
        this.sc = sc;
    }
    
    @FXML
    public void startProject(ActionEvent event) throws IOException{
        String name = newProjName.getText();
        String size = newSize.getText();
        LocalDate date = sDate.getValue();
        this.newProject = new Project(name, yarnList, size, craftType);
        this.newProject.setStartDate(date);
        model.getProjectList().add(newProject);
        model.setCurProject(newProject);
        sc.switchToCurrProj(event);
    }
    
    @FXML
    public void addingYarnToList() throws IOException{
        Stage yarnStage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("YarnBox.fxml"));
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

    // For index of yarnListView
    private int selectedIndex = -1;
    
    @FXML
    public void removeYarn(){
        selectedIndex = yarnListView.getSelectionModel().getSelectedIndex();
        
        if(selectedIndex < 0){
            return;
        }
        
        yarnList.remove(selectedIndex);
        yarnListView.getItems().remove(selectedIndex);
    }
    
    public void getCraftType(ActionEvent event){
        if(crochet.isSelected()){
            craftType = "CROCHET";
        } else if (knitting.isSelected()){
            craftType = "KNITTING";
        }
    }

    @FXML
    public void cancelBtn(ActionEvent event) throws IOException{
        newProject = null;
        sc.switchToMain(event);
    }
    
}

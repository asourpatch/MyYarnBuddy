/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myyarnbuddy;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleButton;

/**
 *
 * @author Amanda
 */
public class CurrProjectController implements Initializable{
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
    private ToggleButton typeBtn;
    @FXML
    private Label typeLabel;
    
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
    }
    
    public void initModel(Model m){
        if(this.model != null){
            throw new IllegalStateException("Mdoel can only be initialized once");
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
    void changeTypeBtn(ActionEvent event) {
        component.setType(component.oppType());
        typeBtn.setText(component.oppType());
        typeLabel.setText(component.getType());
    }

    @FXML
    void completeBtn(ActionEvent event) throws IOException {
        component.setNotes(notesBox.getText());
        project.done();
        model.getCompProjectList().add(project);
        model.getProjectList().remove(project);
        model.setCurProject(null);
        sc.switchToMain(event);
    }

    @FXML
    void decrementBtn(ActionEvent event) {
        if(counter == 0){
            return;
        } else{
            counter--;
            count.setText(Integer.toString(counter));
            component.setCount(counter);
        }
    }

    @FXML
    void incrementBtn(ActionEvent event) {
        counter++;
        count.setText(Integer.toString(counter));
        component.setCount(counter);
    }

    @FXML
    void resetBtn(ActionEvent event) {
        counter = 0;
        count.setText("0");
        component.setCount(0);
    }
    
}

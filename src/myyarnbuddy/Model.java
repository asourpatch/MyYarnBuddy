package myyarnbuddy;

import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Amanda
 */
public class Model {
    private ArrayList<Project> projectList;
    private ArrayList<Project> completeProjectList;
    private ArrayList<Yarn> newYarnList;
    private Project currentProject;
    private Yarn newYarn;
    
    public Model(){
        this.projectList = new ArrayList<Project>();
        this.completeProjectList = new ArrayList<Project>();
        this.newYarnList = new ArrayList<Yarn>();
        this.currentProject = null;
    }
    
    public ArrayList<Project> getProjectList(){
        return this.projectList;
    }
    
    public void addToProjectList(Project p){
        this.projectList.add(p);
    }
    
    public void removeFromProjectList(Project p){
        this.projectList.remove(p);
    }
    
    public ArrayList<Project> getCompProjectList(){
        return this.completeProjectList;
    }
    
    public void addToCompProjList(Project p){
        this.completeProjectList.add(p);
    }
    
    public void removeFromCompProjList(Project p){
        this.completeProjectList.remove(p);
    }
    
    public ArrayList<Yarn> getNewYarnList(){
        return this.newYarnList;
    }
    
    public void addYarnToList(Yarn y){
        this.newYarnList.add(y);
    }
    
    public void removeYarnFromList(Yarn y){
        this.newYarnList.remove(y);
    }
    
    public Project getCurrProject(){
       return this.currentProject;
    }
    
    public void setCurProject(Project p) {
       this.currentProject = p;
    }
    
    public Yarn getNewYarn(){
        return this.newYarn;
    }
    
    public void setNewYarn(Yarn y){
        this.newYarn = y;
    }
}

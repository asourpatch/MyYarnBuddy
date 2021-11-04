package myyarnbuddy.java.model;

import java.io.Serializable;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Amanda
 */
public class Model implements Serializable{
    private ArrayList<Project> projectList;
    private ArrayList<Project> completeProjectList;
    private Project currentProject;
    
    public Model(){
        this.projectList = new ArrayList<Project>();
        this.completeProjectList = new ArrayList<Project>();
        this.currentProject = null;
    }
    
    public void setProjList(ArrayList<Project> p){
        this.projectList = p;
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
    
    public void setCompProjList(ArrayList<Project> p){
        this.completeProjectList = p;
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
    
    public Project getCurrProject(){
       return this.currentProject;
    }
    
    public void setCurrProject(Project p) {
       this.currentProject = p;
    }
}

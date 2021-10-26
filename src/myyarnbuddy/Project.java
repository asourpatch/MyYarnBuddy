/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myyarnbuddy;

import java.time.LocalDate;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Amanda
 */
public class Project {
    /*
     * name = project name
     * yarnList = list of yarn used
     * size = size of hook/needles
     * craft = crochet/knitting
     * start/finish = starting/finish date of project
     * 
     */
    private String name, size, progress, craft;
    private final static String WIP = "WIP";
    private final static String COMPLETE = "COMPLETE";
    private ArrayList<Yarn> yarnList;
    private LocalDate start, finish;
    private Component component;
    
    public Project(){
        this.name = null;
        this.yarnList = new ArrayList<Yarn>();
        this.size = null;
        this.craft = null;
        this.start = LocalDate.now();
        this.finish = null;
        this.component = null;
    }
    
    public Project(String name, ArrayList<Yarn> yarnList, String size, String craft) {
        this.name = name;
        this.yarnList = yarnList;
        this.size = size;
        this.progress = WIP;
        this.craft = craft;
        this.start = LocalDate.now();
        this.finish = null;
        this.component = new Component();
    }

    // Duplicate project
    public Project(Project p) {
        this.name = p.getName();
        this.yarnList = p.getYarnList();
        this.size = p.getSize();
        this.progress = p.getProgress();
        this.craft = p.getCraft();
        this.start = p.getStartDate();
        this.finish = p.getFinishDate();
        this.component = p.getComponent();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String x) {
        this.name = x;
    }

    public ArrayList<Yarn> getYarnList(){
        return this.yarnList;
    }

    public void setYarnList(ArrayList<Yarn> yl) {
        this.yarnList = yl;
    }

    public void addToYarnList(Yarn y) {
        this.yarnList.add(y);
    }

    public void removeFromYarnList(int index) {
        this.yarnList.remove(index);
    }

    public String getSize() {
        return this.size;
    }

    public void setSize(String x) {
        this.size = x;
    }

    public String getProgress() {
        return this.progress;
    }

    public void setProgress(String p) {
        this.progress = p;
    }

    public String getCraft() {
        return this.craft;
    }

    public void setCraft(String s) {
        this.craft = s;
    }

    public LocalDate getStartDate() {
        return this.start;
    }

    public void setStartDate(LocalDate d) {
        this.start = d;
    }

    public LocalDate getFinishDate() {
        return this.finish;
    }

    public void setFinishDate(LocalDate d) {
        this.finish = d;
    }

    public Component getComponent() {
        return this.component;
    }

    public void setComponent(Component c) {
        this.component = c;
    }

    @Override
    public String toString() {
        return this.name;
    }

    public void done() {
        setProgress(COMPLETE);
        setFinishDate(LocalDate.now());
    }
}

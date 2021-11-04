/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myyarnbuddy.java.model;

import java.io.Serializable;

/**
 *
 * @author Amanda
 */
public class Yarn implements Serializable{
    /*
     * name = yarn name
     * color = yarn color
     * weight = yarn weight
     * contents = yarn material
     */
    private String name, color, weight, contents;

    public Yarn(){
        this.name = null;
        this.color = null;
        this.weight = null;
        this.contents = null;
    }
    
    public Yarn (String name, String color, String weight, String contents) {
        this.name = name;
        this.color = color;
        this.weight = weight;
        this.contents = contents;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String s) {
        this.name = s;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String s) {
        this.color = s;
    }

    public String getWeight() {
        return this.weight;
    }

    public void setWeight(String s) {
        this.weight = s;
    }

    public String getContents() {
        return this.contents;
    }

    public void setContents(String s) {
        this.contents = s;
    }
    
    @Override
    public String toString(){
        return this.name + ", " + this.color + ", " + this.weight + ", " + this.contents;
    }

}

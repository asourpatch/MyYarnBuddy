/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myyarnbuddy;

/**
 *
 * @author Amanda
 */
public class Component {
    /*
     * name = name of component (Example: Head, Arm, Leg, etc)
     * row = row user is currently on
     * notes = any notes user types in notes box
     */
    private String type, notes;
    private final static String ROW = "ROW";
    private final static String SQUARE = "SQUARE";
    private final static String ROUND = "ROUND";
    private int count;

    public Component() {
        this.type = ROW;
        this.count = 0;
        this.notes = null;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String s) {
        this.type = s;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int c) {
        this.count = c;
    }

    public String getNotes() {
        return this.notes;
    }

    public void setNotes(String s) {
        this.notes = s;
    }

    public String oppType() {
        if(this.type.equals(ROW)) {
            return SQUARE;
        } else if(this.type.equals(SQUARE)){
            return ROUND;
        } else {
            return ROW;
        }
    }
}

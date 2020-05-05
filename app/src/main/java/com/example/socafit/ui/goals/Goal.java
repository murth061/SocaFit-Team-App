package com.example.socafit.ui.goals;

// Created by Bergen Thomson on 4/2/2020

import android.widget.Button;

import java.io.Serializable;

public class Goal {
    private int id;
    private String name;
    private String description;
    private String length;  // estimated time to achieve goal (in weeks)
    private String actionplan;
    private int image;
    private String startdate;
    private android.widget.Button btn;

    public Goal(int id, String name, String description, String length, String actionplan, int image, String startdate, android.widget.Button btn) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.length = length;
        this.actionplan = actionplan;
        this.image = image;
        this.startdate = startdate;
        this.btn = btn;
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getLength() {
        return length;
    }

    public String getActionPlan() { return actionplan; }

    public int getImage() {
        return image;
    }

    public String getStartDate() { return startdate; }

    public android.widget.Button getButton() { return btn; }

    public void setId(int id) { this.id = id; }

    public void setName(String name) { this.name = name; }

    public void setDescription(String desc) { this.description = desc; }

    public void setLength(String length) { this.length = length; }

    public void setActionPlan(String actionplan) { this.actionplan = actionplan; }

    public void setImage(int image) { this.image = image; }

    public void setStartDate(String startdate) { this.startdate = startdate; }

    public void setButton(Button btn) { this.btn = btn; }
}

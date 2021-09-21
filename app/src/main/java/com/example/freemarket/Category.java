package com.example.freemarket;

import org.json.JSONException;
import org.json.JSONObject;

public class Category {
    private String name;
    private String color;

    public Category(String name) {
        this.name = name;
    }

    public Category(String name, String color){ this.name = name; this.color = color;}

    public Category() {

    }

    String getName() {
        return this.name;
    }

    void setName(String name) {
        this.name = name;
    }

    String getColor(){ return this.color;}
    void setColor(String color){
        this.color = color;
    }

    public void loadFromJson(JSONObject row){
        try{
            this.setName(row.getString("name"));

            this.setColor(row.getString("color"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


}

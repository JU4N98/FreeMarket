package com.example.freemarket;

import android.content.Context;
import android.content.res.AssetFileDescriptor;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CategoryDao {
    String FILENAME = "Categories.json";
    Context ctx;
    private List<Category> categories = new ArrayList<>();

    public CategoryDao(Context applicationContext) {
        ctx = applicationContext;
    }

    public List<Category> list() {

        try {
            JSONArray data =
                    (JSONArray) new JSONTokener(this.readFromFile()).nextValue();
            for(int i=0; i<data.length(); i++){
                JSONObject row = data.getJSONObject(i);
                Category aCategory = new Category();
                aCategory.loadFromJson(row);
                categories.add(aCategory);

            }

        }
        catch(JSONException e){ e.printStackTrace(); }
        return categories;
    }

    private String readFromFile(){
        FileInputStream fis = null;
        StringBuilder sb = new StringBuilder();
        try{

            AssetFileDescriptor afd = ctx.getAssets().openFd(FILENAME);
            fis = afd.createInputStream();
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader buffRdr = new BufferedReader(isr);
            String line;
            while ((line = buffRdr.readLine()) != null) {
                sb.append(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

}

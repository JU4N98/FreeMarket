package com.example.freemarket;

import java.util.ArrayList;
import java.util.List;

public class CategoryDao {
    private List<Category> categories = new ArrayList<>();

    public List<Category> list() {

        categories.add(new Category("ELECTRONICA"));
        categories.add(new Category("JARDIN"));
        categories.add(new Category("INDUMENTARIA"));

        return categories;
    }


}

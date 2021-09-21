package com.example.freemarket;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CategoriesActivity extends Activity {
    CategoryDao categoryDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        categoryDao = new CategoryDao();
        RecyclerView recyclerView = findViewById(R.id.categoryRecycler);
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        RecyclerView.Adapter adapter = new CategoryRecyclerAdapter(categoryDao.list(), this);
        recyclerView.setAdapter(adapter);
    }
}
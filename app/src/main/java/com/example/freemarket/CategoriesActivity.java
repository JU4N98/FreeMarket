package com.example.freemarket;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


public class CategoriesActivity extends AppCompatActivity {
    CategoryDao categoryDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        categoryDao = new CategoryDao(this.getApplicationContext());
        RecyclerView recyclerView = findViewById(R.id.categoryRecycler);
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        RecyclerView.Adapter adapter = new CategoryRecyclerAdapter(categoryDao.list(), this);
        recyclerView.setAdapter(adapter);
    }
}
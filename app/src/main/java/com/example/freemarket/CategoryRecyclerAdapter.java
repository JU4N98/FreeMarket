package com.example.freemarket;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.util.List;

public class CategoryRecyclerAdapter extends RecyclerView.Adapter<CategoryRecyclerAdapter.CategoryViewHolder>{
    private List<Category> dataset;
    private CategoriesActivity mParent;

    public CategoryRecyclerAdapter(List<Category> dataset, CategoriesActivity categoryRecyclerView){
        mParent = categoryRecyclerView;
        this.dataset = dataset;
    }

    @Override
    public CategoryViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cat_row,parent,false);
        CategoryViewHolder cvh = new CategoryViewHolder(v);
        return cvh;
    }

    @Override
    public void onBindViewHolder(CategoryViewHolder holder, int position) {
        holder.categoryName.setTag(position);
        Category category = dataset.get(position);
        System.out.println(category.getColor());
        holder.categoryName.setText(category.getName());
    //    holder.cardView.setBackgroundColor();
        holder.cardView.findViewById(R.id.linearLayout).setBackgroundColor(Color.parseColor(category.getColor()));
        holder.cardView.setOnClickListener(e->{
            Intent intent = new Intent(mParent,MainActivity.class);
            intent.putExtra("categoria",category.getName());
            mParent.setResult(Activity.RESULT_OK,intent);
            mParent.finish();
        });
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public static class CategoryViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        TextView categoryName;

        public CategoryViewHolder(View v){
            super(v);
            this.cardView = v.findViewById(R.id.categoryCard);
            this.categoryName = v.findViewById(R.id.categoryName);
        }
    }
}

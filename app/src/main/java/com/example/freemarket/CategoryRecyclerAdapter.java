package com.example.freemarket;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CategoryRecyclerAdapter extends RecyclerView.Adapter<CategoryRecyclerAdapter.CategoryViewHolder>{
    private List<Category> dataset;

    public CategoryRecyclerAdapter(List<Category> dataset, CategoriesActivity categoryRecyclerView){
        this.dataset = dataset;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cat_row,parent,false);
        CategoryViewHolder cvh = new CategoryViewHolder(v);
        return cvh;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        holder.categoryName.setTag(position);
        Category category = dataset.get(position);

        holder.categoryName.setText(category.getName());
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

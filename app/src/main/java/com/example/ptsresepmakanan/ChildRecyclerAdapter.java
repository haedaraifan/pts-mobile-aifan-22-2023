package com.example.ptsresepmakanan;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ChildRecyclerAdapter extends RecyclerView.Adapter<ChildRecyclerAdapter.CategoryItemViewHolder> {

    private Context context;
    private List<ChildItemModel> localdataset;

    public ChildRecyclerAdapter(Context context, List<ChildItemModel> localdataset) {
        this.context = context;
        this.localdataset = localdataset;
    }

    // Get xml layout file
    @NonNull
    @Override
    public CategoryItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CategoryItemViewHolder(LayoutInflater.from(context).inflate(R.layout.rv_child_item, parent, false));
    }

    // Get id item on xml file
    public static final class CategoryItemViewHolder extends RecyclerView.ViewHolder{
        ImageView itemImage;
        TextView textView;

        public CategoryItemViewHolder(@NonNull View itemView) {
            super(itemView);
            // Define click listener for the ViewHolder's View
            itemImage = itemView.findViewById(R.id.iv_item_rv_child);
            textView = itemView.findViewById(R.id.tv_item_rv_child);
        }
    }

    // Set rv content
    @Override
    public void onBindViewHolder(@NonNull CategoryItemViewHolder holder, int position) {
        // Get localdataset element
        int imageUrl = localdataset.get(position).getImageUrl();
        String itemName = localdataset.get(position).getItemName();
        String itemDesc = localdataset.get(position).getItemDesc();
        String itemIngredients = localdataset.get(position).getItemIngredients();
        String itemSteps = localdataset.get(position).getItemSteps();

        holder.itemImage.setImageResource(imageUrl);
        holder.textView.setText(itemName);

        // Add onclick event
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext(), DetailActivity.class);
                intent.putExtra("name", itemName);
                intent.putExtra("poster", imageUrl);
                intent.putExtra("desc", itemDesc);
                intent.putExtra("ingredients", itemIngredients);
                intent.putExtra("steps", itemSteps);
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return localdataset.size();
    }
}

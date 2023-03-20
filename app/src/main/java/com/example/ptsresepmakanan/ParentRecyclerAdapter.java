package com.example.ptsresepmakanan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ParentRecyclerAdapter extends RecyclerView.Adapter<ParentRecyclerAdapter.MainViewHolder> {
    private Context context;
    private ArrayList<ParentItemModel> localDataSet;

    /**
     * Initialize the dataset of the Adapter.
     *
     * @param dataSet String[] containing the data to populate views to be used
     * by RecyclerView.
     */
    public ParentRecyclerAdapter(Context context,ArrayList<ParentItemModel> dataSet) {
        this.context = context;
        this.localDataSet = dataSet;
    }

    // Create new views (invoked by the layout manager)
    // Get xml layout file
    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Create a new view, which defines the UI of the list item
        return new MainViewHolder(LayoutInflater.from(context).inflate(R.layout.rv_parent_item, parent, false));
    }

    // Get id item on xml file
    public static final class MainViewHolder extends RecyclerView.ViewHolder{
        TextView categoryTitle;
        RecyclerView itemRecycler;

        public MainViewHolder(@NonNull View itemView) {
            super(itemView);
            // Define click listener for the ViewHolder's View
            categoryTitle = itemView.findViewById(R.id.tv_category_rv_parent);
            itemRecycler = itemView.findViewById(R.id.rv_child_container);
        }
    }

    // Set rv content
    @Override
    public void onBindViewHolder(@NonNull ParentRecyclerAdapter.MainViewHolder holder, int position) {
        holder.categoryTitle.setText(localDataSet.get(position).getCategoryTitle());
        setChildItemRecycler(holder.itemRecycler, localDataSet.get(position).getChildItemModelList());
    }

    @Override
    public int getItemCount() {
        return localDataSet.size();
    }

    // Method to set Child rv
    private void setChildItemRecycler(RecyclerView recyclerView, List<ChildItemModel> parentItemModelList) {
        ChildRecyclerAdapter childRecyclerAdapter = new ChildRecyclerAdapter(context, parentItemModelList);
        recyclerView.setLayoutManager(new LinearLayoutManager(context, RecyclerView.HORIZONTAL, false));
        recyclerView.setAdapter(childRecyclerAdapter);
    }
}

package com.example.ptsresepmakanan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;

import com.example.ptsresepmakanan.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        ArrayList<ParentItemModel> parentItemList = getListParents();
        ParentRecyclerAdapter adapter = new ParentRecyclerAdapter(this, parentItemList);
        binding.rvParentContainer.setLayoutManager(new LinearLayoutManager(this));
        binding.rvParentContainer.setAdapter(adapter);
    }

    private ArrayList<ParentItemModel> getListParents() {
        TypedArray childFoodImage;
        String[] childFoodName, childFoodDesc, childFoodIngredients, childFoodSteps;

        childFoodName = getResources().getStringArray(R.array.indonesia_food_name_list_array);
        childFoodImage = getResources().obtainTypedArray(R.array.indonesia_food_image_list_array);
        childFoodDesc = getResources().getStringArray(R.array.indonesia_food_desc_list_array);
        childFoodIngredients = getResources().getStringArray(R.array.indonesia_food_ingredients_list_array);
        childFoodSteps = getResources().getStringArray(R.array.indonesia_food_steps_list_array);
        List<ChildItemModel> indonesiaList = getListChilds(childFoodImage, childFoodName, childFoodDesc, childFoodIngredients, childFoodSteps);

        childFoodName = getResources().getStringArray(R.array.malaysia_food_name_list_array);
        childFoodImage = getResources().obtainTypedArray(R.array.malaysia_food_image_list_array);
        childFoodDesc = getResources().getStringArray(R.array.malaysia_food_desc_list_array);
        childFoodIngredients = getResources().getStringArray(R.array.malaysia_food_ingredients_list_array);
        childFoodSteps = getResources().getStringArray(R.array.malaysia_food_steps_list_array);
        List<ChildItemModel> malaysiaList = getListChilds(childFoodImage, childFoodName, childFoodDesc, childFoodIngredients, childFoodSteps);

        childFoodName = getResources().getStringArray(R.array.korea_food_name_list_array);
        childFoodImage = getResources().obtainTypedArray(R.array.korea_food_image_list_array);
        childFoodDesc = getResources().getStringArray(R.array.korea_food_desc_list_array);
        childFoodIngredients = getResources().getStringArray(R.array.korea_food_ingredients_list_array);
        childFoodSteps = getResources().getStringArray(R.array.korea_food_steps_list_array);
        List<ChildItemModel> koreaList = getListChilds(childFoodImage, childFoodName, childFoodDesc, childFoodIngredients, childFoodSteps);

        childFoodName = getResources().getStringArray(R.array.jepang_food_name_list_array);
        childFoodImage = getResources().obtainTypedArray(R.array.jepang_food_image_list_array);
        childFoodDesc = getResources().getStringArray(R.array.jepang_food_desc_list_array);
        childFoodIngredients = getResources().getStringArray(R.array.jepang_food_ingredients_list_array);
        childFoodSteps = getResources().getStringArray(R.array.jepang_food_steps_list_array);
        List<ChildItemModel> jepangList = getListChilds(childFoodImage, childFoodName, childFoodDesc, childFoodIngredients, childFoodSteps);

        ArrayList<ParentItemModel> parents = new ArrayList<>();
        String[] categoryTitle = getResources().getStringArray(R.array.food_category_array);
        parents.add(new ParentItemModel(categoryTitle[0], indonesiaList));
        parents.add(new ParentItemModel(categoryTitle[1], malaysiaList));
        parents.add(new ParentItemModel(categoryTitle[2], koreaList));
        parents.add(new ParentItemModel(categoryTitle[3], jepangList));

        return parents;
    }

    private List<ChildItemModel> getListChilds(TypedArray childFoodImage, String[] childFoodName, String[] childFoodDesc, String[] childFoodIngredients, String[] childFoodSteps) {
        List<ChildItemModel> childs = new ArrayList<>();

        for(int i = 0; i < childFoodName.length; i++) {
            childs.add(new ChildItemModel(childFoodName[i], childFoodImage.getResourceId(i, -1), childFoodDesc[i], childFoodIngredients[i], childFoodSteps[i]));
        }

        return childs;
    }
}
package com.example.ptsresepmakanan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.ptsresepmakanan.databinding.ActivityDetailBinding;

public class DetailActivity extends AppCompatActivity {
    private ActivityDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        int poster = intent.getIntExtra("poster", 0);
        String desc = intent.getStringExtra("desc");
        String ingredients = intent.getStringExtra("ingredients");
        String steps = intent.getStringExtra("steps");

        binding.tvNameDetailActivity.setText(name);
        binding.ivDetailActivity.setImageResource(poster);
        binding.tvDescDetailActivity.setText(desc);
        binding.tvIngredientsDetailActivity.setText(ingredients);
        binding.tvStepsDetailActivity.setText(steps);
    }
}
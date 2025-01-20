package com.example.myandroidapp

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class RecipeDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recipe_details)

        val recipeId = intent.getIntExtra("RECIPE_ID", -1)
        val recipeTitle = intent.getStringExtra("RECIPE_TITLE")
        val recipeImageResId = intent.getIntExtra("RECIPE_IMAGE", -1)

        val recipeDetailText: TextView = findViewById(R.id.recipeDetailText)
        val recipeImage: ImageView = findViewById(R.id.recipeImage)

        recipeDetailText.text = "Recipe ID: $recipeId\nRecipe Title: $recipeTitle"

        if (recipeImageResId != -1) {
            recipeImage.setImageResource(recipeImageResId)
        }
    }
}
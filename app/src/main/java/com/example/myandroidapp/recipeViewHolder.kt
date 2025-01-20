package com.example.myandroidapp

import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecipeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val titleTextView: TextView = itemView.findViewById(R.id.title)
    private val descriptionTextView: TextView = itemView.findViewById(R.id.description)
    private val imageView: ImageView = itemView.findViewById(R.id.image)
    private val likeButton: ImageButton = itemView.findViewById(R.id.btn_like)
    private val shareButton: ImageButton = itemView.findViewById(R.id.btn_share)

    fun bind(
        recipe: Recipe,
        itemClickListener: (Recipe) -> Unit,
        likeClickListener: (Recipe) -> Unit,
        shareClickListener: (Recipe) -> Unit
    ) {
        titleTextView.text = recipe.title
        descriptionTextView.text = recipe.description  // Set the description dynamically
        imageView.setImageResource(recipe.imageResId)

        itemView.setOnClickListener { itemClickListener(recipe) }
        likeButton.setOnClickListener { likeClickListener(recipe) }
        shareButton.setOnClickListener { shareClickListener(recipe) }
    }
}

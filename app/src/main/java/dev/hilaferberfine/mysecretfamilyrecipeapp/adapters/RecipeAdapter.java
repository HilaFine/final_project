package dev.hilaferberfine.mysecretfamilyrecipeapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import dev.hilaferberfine.mysecretfamilyrecipeapp.R;
import dev.hilaferberfine.mysecretfamilyrecipeapp.databinding.ItemRecipeBinding;
import dev.hilaferberfine.mysecretfamilyrecipeapp.models.Recipe;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.RecipeHolder> {
    List<Recipe> recipeList;

    public void setRecipeList(List<Recipe> recipeList){
        this.recipeList = recipeList;
    }
    @NonNull
    @Override
    public RecipeAdapter.RecipeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemRecipeBinding binding = ItemRecipeBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new RecipeHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeAdapter.RecipeHolder holder, int position) {
        Recipe recipe = recipeList.get(position);
        holder.onBind(recipe);
    }

    @Override
    public int getItemCount() {
        return recipeList.size();
    }
    public static class RecipeHolder extends RecyclerView.ViewHolder {
        ItemRecipeBinding bindind;
        public RecipeHolder (@NonNull ItemRecipeBinding itemView){
            super(itemView.getRoot());
            bindind = itemView;
        }
        public void onBind(Recipe recipe){
            if(recipe.getImage().equalsIgnoreCase("recipe1")) {
                bindind.imRecipe.setImageResource(R.drawable.recipe1);
            }else {
                bindind.imRecipe.setImageResource(R.drawable.recipe2);
            }

        }
    }
}

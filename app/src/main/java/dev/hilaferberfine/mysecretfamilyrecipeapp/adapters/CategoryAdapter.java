package dev.hilaferberfine.mysecretfamilyrecipeapp.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import dev.hilaferberfine.mysecretfamilyrecipeapp.R;
import dev.hilaferberfine.mysecretfamilyrecipeapp.databinding.ItemCategoryBinding;
import dev.hilaferberfine.mysecretfamilyrecipeapp.databinding.ItemRecipeBinding;
import dev.hilaferberfine.mysecretfamilyrecipeapp.models.Category;
import dev.hilaferberfine.mysecretfamilyrecipeapp.models.Recipe;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryHolder>{
    List<Category> categoryList;

    public void setCategoryList(List<Category> categoryList){
        this.categoryList = categoryList;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public CategoryAdapter.CategoryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemCategoryBinding binding = ItemCategoryBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new CategoryAdapter.CategoryHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.CategoryHolder holder, int position) {
        Category category = categoryList.get(position);
        holder.onBind(category);
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }
    public static class CategoryHolder extends RecyclerView.ViewHolder {
        ItemCategoryBinding binding;

        public CategoryHolder(@NonNull ItemCategoryBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }

        public void onBind(Category category) {

            binding.textViewCategoryName.setText(category.getName());
            if (category.getId().equalsIgnoreCase("1")) {
                binding.imCategory.setImageResource(R.drawable.salads);
            } else if (category.getId().equalsIgnoreCase("2")) {
                binding.imCategory.setImageResource(R.drawable.starters);
            } else if (category.getId().equalsIgnoreCase("3")) {
                binding.imCategory.setImageResource(R.drawable.main);
            } else if (category.getId().equalsIgnoreCase("4")) {
                binding.imCategory.setImageResource(R.drawable.cake);
            } else if (category.getId().equalsIgnoreCase("5")) {
                binding.imCategory.setImageResource(R.drawable.cookies);
            }
        }
    }

}

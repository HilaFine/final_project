package dev.hilaferberfine.mysecretfamilyrecipeapp.ui.categories;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import java.util.ArrayList;
import java.util.List;

import dev.hilaferberfine.mysecretfamilyrecipeapp.adapters.CategoryAdapter;
import dev.hilaferberfine.mysecretfamilyrecipeapp.databinding.FragmentCategoryBinding;
import dev.hilaferberfine.mysecretfamilyrecipeapp.models.Category;

public class CategoriesFragment extends Fragment {

    private FragmentCategoryBinding binding;
    List <Category> categoryList;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        CategoriesViewModel slideshowViewModel =
                new ViewModelProvider(this).get(CategoriesViewModel.class);

        binding = FragmentCategoryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textCategory;
        slideshowViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loadCategories();
    }

    private void loadCategories() {

        categoryList = new ArrayList<>();
        categoryList.add(new Category("1", "Salads", ""));
        categoryList.add(new Category("2", "Starters", ""));
        categoryList.add(new Category("3", "Main Course", ""));
        categoryList.add(new Category("4", "Cakes", ""));
        categoryList.add(new Category("5", "Cookies", ""));
        binding.rcCategories.setAdapter(new CategoryAdapter());
        CategoryAdapter adapter = (CategoryAdapter) binding.rcCategories.getAdapter();
        if (adapter != null){
            adapter.setCategoryList(categoryList);
            adapter.notifyDataSetChanged();
        }


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
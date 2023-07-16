package dev.hilaferberfine.mysecretfamilyrecipeapp.ui.home;

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

import dev.hilaferberfine.mysecretfamilyrecipeapp.adapters.RecipeAdapter;
import dev.hilaferberfine.mysecretfamilyrecipeapp.databinding.FragmentHomeBinding;
import dev.hilaferberfine.mysecretfamilyrecipeapp.models.Recipe;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    List<Recipe> favRecipeList;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textHome;
        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loadFavRecipes();

    }

    private void loadFavRecipes() {
        favRecipeList = new ArrayList<>();
        favRecipeList.add(new Recipe("1", "Choclate chip cookies","recipe1" ,"Amazing cookies", "Cookies", "1. mix the ingrients", "sugar, choclate", "30 min", "5"));
        favRecipeList.add(new Recipe("2", "Choclate chip cookies"," " ,"Amazing cookies", "Cookies", "1. mix the ingrients", "sugar, choclate", "30 min", "5"));
        favRecipeList.add(new Recipe("3", "Choclate chip cookies","recipe1" ,"Amazing cookies", "Cookies", "1. mix the ingrients", "sugar, choclate", "30 min", "5"));
        favRecipeList.add(new Recipe("4", "Choclate chip cookies"," " ,"Amazing cookies", "Cookies", "1. mix the ingrients", "sugar, choclate", "30 min", "5"));
        binding.recycleViewFavourite.setAdapter(new RecipeAdapter());
        RecipeAdapter adapter = (RecipeAdapter) binding.recycleViewFavourite.getAdapter();
        if(adapter != null) {
            adapter.setRecipeList(favRecipeList);
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
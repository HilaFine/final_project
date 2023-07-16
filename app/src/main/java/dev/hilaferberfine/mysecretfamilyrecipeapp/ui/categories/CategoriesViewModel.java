package dev.hilaferberfine.mysecretfamilyrecipeapp.ui.categories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CategoriesViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public CategoriesViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("What do you want to eat?");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
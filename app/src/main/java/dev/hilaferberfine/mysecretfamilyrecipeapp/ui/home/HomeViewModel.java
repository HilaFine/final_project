package dev.hilaferberfine.mysecretfamilyrecipeapp.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Discover culinary magic with our recipes");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
package com.example.socafit.ui.competitions;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CompViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public CompViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Join a Competition!");
    }


    public LiveData<String> getText() {
        return mText;
    }
}
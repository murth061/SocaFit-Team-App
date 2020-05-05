package com.example.socafit.ui.leaderboard1;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class Lead3ViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public Lead3ViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Slow and Steady!");
    }


    public LiveData<String> getText() {
        return mText;
    }
}

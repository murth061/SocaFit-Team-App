package com.example.socafit.ui.leaderboard1;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class Lead1ViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public Lead1ViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Run Your Heart Out Leaderboard");
    }


    public LiveData<String> getText() {
        return mText;
    }
}

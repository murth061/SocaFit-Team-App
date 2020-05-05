package com.example.socafit.ui.findfriends.post;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.socafit.R;
import com.example.socafit.ui.findfriends.FindFriendsFragment;

public class PostActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

    }

    public void onCancel(View view){
        this.finish();
    }
    public void onPost(View view){
        FindFriendsFragment.postCreated();
        finish();
    }
}

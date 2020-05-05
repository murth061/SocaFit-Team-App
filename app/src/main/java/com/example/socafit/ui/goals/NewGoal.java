package com.example.socafit.ui.goals;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.socafit.R;

public class NewGoal extends AppCompatActivity {

    private int goalId;

    private GoalAdapter.GoalViewHolder holder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_goal);
    }

    public void cancelNewGoal(View view) {
        finish();
    }

    public void saveNewGoal(View view) {
        EditText editTextExpandedName = (EditText)findViewById(R.id.editTextExpandedName);
        String name = editTextExpandedName.getText().toString();
        EditText editTextExpandedDescription = (EditText)findViewById(R.id.editTextExpandedDescription);
        String desc = editTextExpandedDescription.getText().toString();
        EditText editTextExpandedLength = (EditText)findViewById(R.id.editTextExpandedLength);
        String length = editTextExpandedLength.getText().toString();
        EditText editTextExpandedActionPlan = (EditText)findViewById(R.id.editTextExpandedActionPlan);
        String actionplan = editTextExpandedActionPlan.getText().toString();
        Bundle bundle = new Bundle();
        bundle.putInt("id", goalId);
        bundle.putString("name", name);
        bundle.putString("description", desc);
        bundle.putString("length", length);
        bundle.putString("actionplan", actionplan);
        GoalsFragment.addNewGoal(bundle);
        finish();
    }
}

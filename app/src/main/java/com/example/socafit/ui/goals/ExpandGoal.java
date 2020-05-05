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

public class ExpandGoal extends AppCompatActivity {

    private int goalId;

    private GoalAdapter.GoalViewHolder holder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.expand_goal);

        // get the intent that started this activity and extract the string
        Intent intent = getIntent();
        goalId = intent.getIntExtra("id", -1);
        String name = intent.getStringExtra("name");
        String description = intent.getStringExtra("description");
        String length = intent.getStringExtra("length");
        String actionplan = intent.getStringExtra("actionplan");

        // Capture the layouts TextView and set the string as its text
        EditText editTextExpandedName = (EditText)findViewById(R.id.editTextExpandedName);
        editTextExpandedName.setText(name);
        EditText editTextExpandedDescription = (EditText)findViewById(R.id.editTextExpandedDescription);
        editTextExpandedDescription.setText(description);
        EditText editTextExpandedLength = (EditText)findViewById(R.id.editTextExpandedLength);
        editTextExpandedLength.setText(length);
        EditText editTextExpandedActionPlan = (EditText)findViewById(R.id.editTextExpandedActionPlan);
        editTextExpandedActionPlan.setText(actionplan);
    }

    public void goBackToMainGoalsPage(View view) {
        finish();
    }

    public void saveUpdatedGoal(View view) {
        // Doesn't currently save anything...
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
        GoalsFragment.updateGoal(bundle);
        finish();
    }
}

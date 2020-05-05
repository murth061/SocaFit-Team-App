package com.example.socafit.ui.goals;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.socafit.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GoalsFragment extends Fragment {

    private GoalsViewModel goalsViewModel;

    //a list to store all the products
    static List<Goal> goalList;

    //the recyclerview
    static RecyclerView recyclerView;

    private static Context context;

    private static int nextGoalId;

    static View root;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        goalsViewModel =
                ViewModelProviders.of(this).get(GoalsViewModel.class);
        root = inflater.inflate(R.layout.fragment_goals, container, false);
        FloatingActionButton goals_fab = root.findViewById(R.id.goals_fab);
        goals_fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), NewGoal.class);
                startActivity(intent);
            }
        });

        //getting the recyclerview from xml
        recyclerView = (RecyclerView) root.findViewById(R.id.goalsRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        //initializing the goallist
        goalList = new ArrayList<>();

        //adding some initial items to our list
        goalList.add(
                new Goal(
                        0,
                        "7 Minute Mile",
                        "Run one mile in 7 minutes or less",
                        "8 weeks",
                        "Consistently run 5 times per week, doing at least one track workout per week and one tempo workout per week. Try to increase pace of tempo workout by 5 seconds per mile each week, starting at 8:00 min/mi pace. After 8 weeks, head to track to time max effort for one mile.",
                        R.drawable.goal,
                        "Started: " + new SimpleDateFormat("MM/dd/yyyy").format(new Date()),
                        (Button) root.findViewById(R.id.goalExpandButton)));

        goalList.add(
                new Goal(
                        1,
                        "Run 20 Miles This Week",
                        "Run 20 miles (or more) over the next 7 days.",
                        "1 week",
                        "Plan to run at least 4 miles per day on 5 of the next 7 days.",
                        R.drawable.goal,
                        "Started: " + new SimpleDateFormat("MM/dd/yyyy").format(new Date()),
                        (Button) root.findViewById(R.id.goalExpandButton)));

        nextGoalId = 2;

//        context = getActivity();

        //creating recyclerview adapter
        GoalAdapter adapter = new GoalAdapter(getActivity(), goalList);

        //setting adapter to recyclerview
        recyclerView.setAdapter(adapter);

        return root;
    }


//    /* Called when the user taps on a goal */
//    public void expandGoal(View view) {
//        String name = ((TextView) view.findViewById(R.id.textViewName)).getText().toString();
//        Goal g = name.OuterClass;
//        String description = ((TextView) view.findViewById(R.id.textView)
//        Intent intent = new Intent(this, ExpandGoal.class);
//    }
    public static void updateGoal(Bundle args) {
        Activity context = (Activity)root.getContext();
        int goalId = args.getInt("id");
        Goal g = goalList.get(goalId);
        String name = args.getString("name");
        String desc = args.getString("description");
        String length = args.getString("length");
        String actionplan = args.getString("actionplan");
        g.setName(name);
        g.setDescription(desc);
        g.setLength(length);
        g.setActionPlan(actionplan);
        goalList.set(goalId, g);
        GoalAdapter newAdapter = new GoalAdapter(context, goalList);
        recyclerView.setAdapter(newAdapter);
    }

    public static void addNewGoal(Bundle args) {
        Activity context = (Activity)root.getContext();
        int goalId = nextGoalId;
        nextGoalId++;
        String name = args.getString("name");
        String desc = args.getString("description");
        String length = args.getString("length");
        String actionplan = args.getString("actionplan");
        goalList.add(
                new Goal(
                    goalId,
                    name,
                    desc,
                    length,
                    actionplan,
                    R.drawable.goal,
                    "Started: " + new SimpleDateFormat("MM/dd/yyyy").format(new Date()),
                    (Button) root.findViewById(R.id.goalExpandButton)));
        GoalAdapter newAdapter = new GoalAdapter(context, goalList);
        recyclerView.setAdapter(newAdapter);
    }
}
package com.example.socafit.ui.goals;


import android.content.Context;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.socafit.R;


import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class GoalAdapter extends RecyclerView.Adapter<GoalAdapter.GoalViewHolder> {


    //this context we will use to inflate the layout
    private Context mCtx;

    //we are storing all the goals in a list
    private List<Goal> goalList;


    //getting the context and goal list with constructor
    public GoalAdapter(Context mCtx, List<Goal> goalList) {
        this.mCtx = mCtx;
        this.goalList = goalList;
    }

    @Override
    public GoalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.layout_goals, null);
        return new GoalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(GoalViewHolder holder, int position) {
        //getting the goal of the specified position
        final Goal goal = goalList.get(position);
        final String name = goal.getName();
        final String description = goal.getDescription();
        final String length = goal.getLength();
        final String actionplan = goal.getActionPlan();
        final int id = goal.getId();
//
//        // Button btn = goal.getButton();
//
        holder.goalExpandButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mCtx, ExpandGoal.class);
                // intent.putExtra("Goal", goalList.get(pos));
                intent.putExtra("id", id);
                intent.putExtra("name", name);
                intent.putExtra("description", description);
                intent.putExtra("length", length);
                intent.putExtra("actionplan", actionplan);
                mCtx.startActivity(intent);
            }
        });
        //binding the data with the viewholder views
        holder.textViewName.setText(goal.getName());
        holder.textViewLength.setText(goal.getLength());
        holder.textViewStartDate.setText(new SimpleDateFormat("MM/dd/yyyy").format(new Date()));

        holder.goalImageView.setImageDrawable(mCtx.getResources().getDrawable(goal.getImage()));

    }


    @Override
    public int getItemCount() {
        return goalList.size();
    }


    class GoalViewHolder extends RecyclerView.ViewHolder {

        TextView textViewName, textViewLength, textViewStartDate;
        ImageView goalImageView;
        Button goalExpandButton;

        public GoalViewHolder(View itemView) {
            super(itemView);

            textViewName = itemView.findViewById(R.id.textViewName);
            textViewLength = itemView.findViewById(R.id.textViewLength);
            textViewStartDate = itemView.findViewById(R.id.textViewStartDate);
            goalImageView = itemView.findViewById(R.id.goalImageView);
            goalExpandButton = itemView.findViewById(R.id.goalExpandButton);
        }
    }
}

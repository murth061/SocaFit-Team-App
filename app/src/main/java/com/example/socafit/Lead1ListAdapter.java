package com.example.socafit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;


import com.example.socafit.ui.competitions.CompFragment;
import com.example.socafit.ui.leaderboard1.Lead1Fragment;
import com.example.socafit.ui.profile.ProfileFragment;

import java.util.List;

public class Lead1ListAdapter extends RecyclerView.Adapter<Lead1ListAdapter.Lead1ListViewHolder> {
    //this context we will use to inflate the layout
    private Context mCtx;

    //we are storing all the products in a list
    private List<Lead1List> leadList;

    //The fragment this list is in
    private Fragment myFragment;

    //getting the context and product list with constructor
    public Lead1ListAdapter(Context mCtx, List<Lead1List> leadList, Fragment myFragment) {
        this.mCtx = mCtx;
        this.leadList = leadList;
        this.myFragment = myFragment;
    }
    @Override
    public Lead1ListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.lead1_list, null);
        return new Lead1ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(Lead1ListViewHolder holder, int position) {
        //getting the product of the specified position
        Lead1List lead1List = leadList.get(position);

        //binding the data with the viewholder views
        holder.L1ranking.setText(Integer.toString(lead1List.getRanking())); // Make sure not an int
        holder.textViewScore.setText(lead1List.getScore());
        holder.textViewName.setText(lead1List.getName());
        holder.textViewHandle.setText(lead1List.getHandle());
        holder.imageView.setImageDrawable(mCtx.getResources().getDrawable(lead1List.getImage()));

    }


    @Override
    public int getItemCount() {
        return leadList.size();
    }


    class Lead1ListViewHolder extends RecyclerView.ViewHolder {

        TextView L1ranking, textViewScore, textViewName, textViewHandle;
        ImageView imageView;
        Button btnView;

        public Lead1ListViewHolder(View itemView) {
            super(itemView);

            L1ranking = itemView.findViewById(R.id.L1ranking);
            textViewScore = itemView.findViewById(R.id.textViewScore);
            textViewName = itemView.findViewById(R.id.textViewName);
            textViewHandle = itemView.findViewById(R.id.textViewHandle);
            imageView = itemView.findViewById(R.id.imageView);
//            btnView = itemView.findViewById(R.id.back1);
//            btnView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    FragmentTransaction fragmentTransaction = myFragment.getFragmentManager().beginTransaction();
//                    fragmentTransaction.replace(R.id.nav_host_fragment, new CompFragment());
//                    fragmentTransaction.commit();
//                }
//            });
        }
    }
}

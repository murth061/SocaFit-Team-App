package com.example.socafit;


import android.content.Context;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.socafit.ui.goals.GoalsFragment;
import com.example.socafit.ui.competitions.CompFragment;
import com.example.socafit.ui.leaderboard1.Lead1Fragment;
import com.example.socafit.ui.leaderboard1.Lead2Fragment;
import com.example.socafit.ui.leaderboard1.Lead3Fragment;
import com.example.socafit.ui.profile.ProfileFragment;

import java.util.List;

public class CompetitionListAdapter extends RecyclerView.Adapter<CompetitionListAdapter.CompetitionListViewHolder> {


    //this context we will use to inflate the layout
    private Context mCtx;

    //we are storing all the products in a list
    private List<CompetitionList> compList;

    //The fragment this list is in
    private Fragment myFragment;
    //getting the context and product list with constructor
    public CompetitionListAdapter(Context mCtx, List<CompetitionList> compList, Fragment myFragment) {
        this.mCtx = mCtx;
        this.compList = compList;
        this.myFragment = myFragment;
    }

    @Override
    public CompetitionListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.competition_list, null);
        return new CompetitionListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CompetitionListViewHolder holder, int position) {
        //getting the product of the specified position
        CompetitionList product = compList.get(position);

        //binding the data with the viewholder views
        holder.textViewTitle.setText(product.getTitle());
        holder.textViewShortDesc.setText(product.getShortdesc());
        holder.textViewDate.setText(product.getDate());
        holder.imageView.setImageDrawable(mCtx.getResources().getDrawable(product.getImage()));

    }


    @Override
    public int getItemCount() {
        return compList.size();
    }


    class CompetitionListViewHolder extends RecyclerView.ViewHolder {

        TextView textViewTitle, textViewShortDesc, textViewDate;
        ImageView imageView;
        Button btnView;

        public CompetitionListViewHolder(View itemView) {
            super(itemView);

            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewShortDesc = itemView.findViewById(R.id.textViewShortDesc);
            textViewDate = itemView.findViewById(R.id.textViewDate);
            imageView = itemView.findViewById(R.id.imageView);
            btnView = itemView.findViewById(R.id.button_lead);
            btnView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Button yeah = v.findViewById(R.id.button_lead);
                    String title = textViewTitle.getText().toString();
                    FragmentTransaction fragmentTransaction = myFragment.getFragmentManager().beginTransaction();
                    switch(title) {
                        case "Run Your Heart Out!":
                            fragmentTransaction.replace(R.id.nav_host_fragment, new Lead1Fragment());
                            fragmentTransaction.commit();
                            break;
                        case "Slow and Steady!":
                            fragmentTransaction.replace(R.id.nav_host_fragment, new Lead2Fragment());
                            fragmentTransaction.commit();
                            break;
                        case "Lift em weights!":
                            fragmentTransaction.replace(R.id.nav_host_fragment, new Lead3Fragment());
                            fragmentTransaction.commit();
                            break;
                        default:
                            fragmentTransaction.replace(R.id.nav_host_fragment, new ProfileFragment());
                            fragmentTransaction.commit();
                            break;
                    }
                }
            });
        }
    }
}


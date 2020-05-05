package com.example.socafit.ui.competitions;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

//import com.example.socafit.CompActivity;
import com.example.socafit.CompetitionList;
import com.example.socafit.CompetitionListAdapter;
import com.example.socafit.R;
import com.example.socafit.ui.goals.GoalsFragment;

import java.util.ArrayList;
import java.util.List;

public class CompFragment extends Fragment{
    List<CompetitionList> compList;
    private CompViewModel compViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        compViewModel =
                ViewModelProviders.of(this).get(CompViewModel.class);
        View root = inflater.inflate(R.layout.fragment_comp, container, false);
        final TextView textView = root.findViewById(R.id.text_comp);
        final RecyclerView recyclerview_dwu = root.findViewById(R.id.recyclerview_dwu);


        recyclerview_dwu.setHasFixedSize(true);
        recyclerview_dwu.setLayoutManager(new LinearLayoutManager(getActivity()));


        //initializing the productlist
        compList = new ArrayList<>();
//        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

        //adding some items to our list
        compList.add(
                new CompetitionList(
                        1,
                        "Run Your Heart Out!",
                        "Compete against other runners every week!",
                        "04/13-04/19",
                        R.drawable.run_icon));

        compList.add(
                new CompetitionList(
                        2,
                        "Slow and Steady!",
                        "Compete for distance against runners every month!",
                        "04/01-04/30",
                        R.drawable.run_icon));

        compList.add(
                new CompetitionList(
                        3,
                        "Lift em weights!",
                        "Compete against others to flex your strength!",
                        "04/01-04/12",
                        R.drawable.lifter));

        //creating recyclerview adapter
        CompetitionListAdapter adapter = new CompetitionListAdapter(getActivity(),compList, this);
        //setting adapter to recyclerview
        recyclerview_dwu.setAdapter(adapter);
        View cardView = inflater.inflate(R.layout.competition_list, container, false);
        Button btnFragment = cardView.findViewById((R.id.button_lead));
        System.out.println(btnFragment.getText());
        btnFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button yeah = v.findViewById(R.id.button_lead);
                System.out.println("Has been pushed" + yeah.getText());
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.nav_host_fragment, new GoalsFragment());
                fragmentTransaction.commit();
            }
        });

        compViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
//
//    @Override
//    public void onViewCreated(@NonNull View view,
//                              @Nullable Bundle savedInstanceState) {
//        NavController navController = Navigation.findNavController(view);
//        AppBarConfiguration appBarConfiguration =
//                new AppBarConfiguration.Builder(navController.getGraph()).build();
//        Toolbar toolbar = view.findViewById(R.id.toolbar);
//
//        NavigationUI.setupWithNavController(
//                toolbar, navController, appBarConfiguration);
//    }
}
package com.example.socafit.ui.leaderboard1;

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

import com.example.socafit.Lead1List;
import com.example.socafit.Lead1ListAdapter;
import com.example.socafit.Lead2List;
//import com.example.socafit.Lead2ListAdapter;
import com.example.socafit.R;
import com.example.socafit.ui.competitions.CompFragment;
import com.example.socafit.ui.goals.GoalsFragment;

import java.util.ArrayList;
import java.util.List;
public class Lead2Fragment extends Fragment implements View.OnClickListener {
    List<Lead1List> leadList;
    private Lead2ViewModel lead2ViewModel;
    Button btnView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        lead2ViewModel =
                ViewModelProviders.of(this).get(Lead2ViewModel.class);
        View root = inflater.inflate(R.layout.fragment_lead2, container, false);
        final TextView textView = root.findViewById(R.id.text_lead2);
        final RecyclerView lead2_recycler = root.findViewById(R.id.recyclerview_lead2);


        lead2_recycler.setHasFixedSize(true);
        lead2_recycler.setLayoutManager(new LinearLayoutManager(getActivity()));


        //initializing the productlist
        leadList = new ArrayList<>();
//        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

        //adding some items to our list
        leadList.add(
                new Lead1List(
                        1,
                        1,
                        "42.5 km",
                        "Jane",
                        "@janeruns",
                        R.drawable.patricia));

        leadList.add(
                new Lead1List(
                        2,
                        2,
                        "30.0 km",
                        "Charlie",
                        "@letsgetfit",
                        R.drawable.charlie));
        leadList.add(
                new Lead1List(
                        3,
                        3,
                        "16.0 km",
                        "Kari",
                        "@i_love_running",
                        R.drawable.kari));
        leadList.add(
                new Lead1List(
                        4,
                        4,
                        "12.0 km",
                        "James",
                        "@chillboxer",
                        R.drawable.james));

        leadList.add(
                new Lead1List(
                        5,
                        5,
                        "0.0 km",
                        "You",
                        "@Yourself",
                        R.drawable.ic_account_circle_black_24dp));

        //creating recyclerview adapter
        Lead1ListAdapter adapter = new Lead1ListAdapter(getActivity(),leadList, this);
        //setting adapter to recyclerview
        lead2_recycler.setAdapter(adapter);
        btnView = root.findViewById((R.id.back2));
        btnView.setOnClickListener(this);
//        btnView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                System.out.println(btnView.getText() + " was pushed");
//                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
//                fragmentTransaction.replace(R.id.nav_host_fragment, new CompFragment());
//                fragmentTransaction.commit();
//            }
//        });

        lead2ViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back2:
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.nav_host_fragment, new CompFragment());
                fragmentTransaction.commit();
                break;
            default:
                System.out.println("Something went wrong in switch");
                break;
        }
    }
}

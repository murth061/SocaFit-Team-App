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

import com.example.socafit.R;
import com.example.socafit.ui.competitions.CompFragment;
import com.example.socafit.ui.goals.GoalsFragment;

import java.util.ArrayList;
import java.util.List;
public class Lead3Fragment extends Fragment implements View.OnClickListener {
    List<Lead1List> leadList;
    private Lead3ViewModel lead3ViewModel;
    Button btnView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        lead3ViewModel =
                ViewModelProviders.of(this).get(Lead3ViewModel.class);
        View root = inflater.inflate(R.layout.fragment_lead3, container, false);
        final TextView textView = root.findViewById(R.id.text_lead3);
        final RecyclerView lead3_recycler = root.findViewById(R.id.recyclerview_lead3);


        lead3_recycler.setHasFixedSize(true);
        lead3_recycler.setLayoutManager(new LinearLayoutManager(getActivity()));


        //initializing the productlist
        leadList = new ArrayList<>();
//        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

        //adding some items to our list
        leadList.add(
                new Lead1List(
                        1,
                        1,
                        "80 kg",
                        "Charlie",
                        "@letsgetfit",
                        R.drawable.charlie));
        leadList.add(
                new Lead1List(
                        2,
                        2,
                        "70 kg",
                        "Kari",
                        "@i_love_running",
                        R.drawable.kari));
        leadList.add(
                new Lead1List(
                        3,
                        3,
                        "60 kg",
                        "You",
                        "@Yourself",
                        R.drawable.ic_account_circle_black_24dp));

        leadList.add(
                new Lead1List(
                        4,
                        4,
                        "60 kg",
                        "James",
                        "@chillboxer",
                        R.drawable.james));
        leadList.add(
                new Lead1List(
                        5,
                        5,
                        "0 kg",
                        "Mary",
                        "@mary1234",
                        R.drawable.mary));


        //creating recyclerview adapter
        Lead1ListAdapter adapter = new Lead1ListAdapter(getActivity(),leadList, this);
        //setting adapter to recyclerview
        lead3_recycler.setAdapter(adapter);
        btnView = root.findViewById((R.id.back3));
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

        lead3ViewModel.getText().observe(this, new Observer<String>() {
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
            case R.id.back3:
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

package com.example.socafit.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.socafit.PostListAdapter;
import com.example.socafit.R;
import com.example.socafit.ui.HomePost;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    public HomeFragment(){

    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);


        //create posts for now
        HomePost personOne= new HomePost("Anthony", "@smugRunner", "This is extremely cool and I will use it every day of the week for weeks to come", "drawable://" + R.drawable.anthony, 0);
        HomePost personTwo= new HomePost("Charlie", "@Cheeky_Charlie", "I am very happy to be here", "drawable://" + R.drawable.charlie, 0);
        HomePost personThree= new HomePost("Henry", "@HotRod_Henry", "I am very happy to be here", "drawable://" + R.drawable.henry, 2);
        HomePost personFour= new HomePost("James", "@Jacked_James", "I am excited to do runs and pushups and pullups and dips and squats with all of you", "drawable://" + R.drawable.james, 1);
        HomePost personFive= new HomePost("Jane", "@Jolly_Jane", "I am very happy to be here", "drawable://" + R.drawable.janeimg, 2);
        HomePost personSix= new HomePost("Karen", "@Kool_Karen", "I am very happy to be here", "drawable://" + R.drawable.karen, 0);
        HomePost personSeven= new HomePost("Kari", "@LetsGetFit", "I am very happy to be here", "drawable://" + R.drawable.kari, 5);
        HomePost personEight= new HomePost("Anthony", "@smugRunner", "I am very happy to be here", "drawable://" + R.drawable.anthony, 0);

        HomePost personNine= new HomePost("James", "@Jacked_James", "I am very happasdfy to be here", "drawable://" + R.drawable.mary,0);
        HomePost personTen= new HomePost("Patricia", "@Patricia", "I am verasdfy happy to be here", "drawable://" + R.drawable.patricia,0);
        HomePost personEleven= new HomePost("Tom", "@Tommy_Hilfiger", "I am very happy to beasdffasd here", "drawable://" + R.drawable.tom,0);
        HomePost personTweleve= new HomePost("Leo", "@Lovely_Leo", "I am very hapdspy to be here", "drawable://" + R.drawable.anthony,0);
        //add posts to list
        ArrayList<HomePost> postList = new ArrayList<>();
        postList.add(personOne);
        postList.add(personTwo);
        postList.add(personThree);
        postList.add(personFour);
        postList.add(personFive);
        postList.add(personSix);
        postList.add(personSeven);
        postList.add(personEight);
        postList.add(personNine);
        postList.add(personTen);
        postList.add(personEleven);
        postList.add(personTweleve);
        //duplicate


        ListView listView = (ListView)view.findViewById(R.id.all_posts);
        PostListAdapter adapter = new PostListAdapter(getActivity(), R.layout.fragment_post, postList);
        listView.setAdapter(adapter);
        // screen goes live
        // create buttons



        return view;

    }
}

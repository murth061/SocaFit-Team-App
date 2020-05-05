package com.example.socafit.ui.findfriends;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.socafit.R;
import com.example.socafit.ui.findfriends.chats.*;
import com.example.socafit.ui.findfriends.post.PostActivity;

public class FindFriendsFragment extends Fragment {

    private FindFriendsViewModel findFriendsViewModel;
    private boolean is_posted;
    private static View root;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        findFriendsViewModel = ViewModelProviders.of(this).get(FindFriendsViewModel.class);
        root = inflater.inflate(R.layout.fragment_findfriends, container, false);

        root.findViewById(R.id.card_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.getContext().startActivity(new Intent(v.getContext(), CharlieChatActivity.class));
            }
        });

        root.findViewById(R.id.card_2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.getContext().startActivity(new Intent(v.getContext(), JamesChatActivity.class));
            }
        });

        root.findViewById(R.id.card_3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.getContext().startActivity(new Intent(v.getContext(), KariChatActivity.class));
            }
        });

//        root.findViewById(R.id.card_4).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                v.getContext().startActivity(new Intent(v.getContext(), CharlieChatActivity.class));
//            }
//        });
//
//        root.findViewById(R.id.card_5).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                v.getContext().startActivity(new Intent(v.getContext(), CharlieChatActivity.class));
//            }
//        });
//
//        root.findViewById(R.id.card_6).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                v.getContext().startActivity(new Intent(v.getContext(), CharlieChatActivity.class));
//            }
//        });
//
//        root.findViewById(R.id.card_7).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                v.getContext().startActivity(new Intent(v.getContext(), CharlieChatActivity.class));
//            }
//        });
//
//        root.findViewById(R.id.card_8).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                v.getContext().startActivity(new Intent(v.getContext(), CharlieChatActivity.class));
//            }
//        });
//
//        root.findViewById(R.id.card_9).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                v.getContext().startActivity(new Intent(v.getContext(), CharlieChatActivity.class));
//            }
//        });
//
//        root.findViewById(R.id.card_10).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                v.getContext().startActivity(new Intent(v.getContext(), CharlieChatActivity.class));
//            }
//        });
//
//        root.findViewById(R.id.card_11).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                v.getContext().startActivity(new Intent(v.getContext(), CharlieChatActivity.class));
//            }
//        });
        root.findViewById(R.id.createPost).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.getContext().startActivity(new Intent(v.getContext(), PostActivity.class));
            }
        });

        root.findViewById(R.id.PostBanner).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.getContext().startActivity(new Intent(v.getContext(), PostActivity.class));
            }
        });
        return root;
    }

    public static void postCreated(){
        root.findViewById(R.id.PostBanner).setVisibility(View.VISIBLE);
    }
}
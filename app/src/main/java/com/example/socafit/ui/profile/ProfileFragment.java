package com.example.socafit.ui.profile;

import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.socafit.R;

public class ProfileFragment extends Fragment{

    private ProfileViewModel profileViewModel;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        profileViewModel =
                ViewModelProviders.of(this).get(ProfileViewModel.class);
        final View root = inflater.inflate(R.layout.fragment_profile, container, false);
        final TextView textView = root.findViewById(R.id.text_profile);
        profileViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        TextView t2 = (TextView) root.findViewById(R.id.textView18);
        t2.setMovementMethod(LinkMovementMethod.getInstance());

        final ImageView star1 = (ImageView) root.findViewById(R.id.star1);
        final ImageView star2 = (ImageView) root.findViewById(R.id.star2);
        final ImageView star3 = (ImageView) root.findViewById(R.id.star3);
        final ImageView star4 = (ImageView) root.findViewById(R.id.star4);
        final ImageView star5 = (ImageView) root.findViewById(R.id.star5);
        final TextView experienceText = (TextView) root.findViewById(R.id.experienceText);

        star1.setEnabled(false);
        star2.setEnabled(false);
        star3.setEnabled(false);
        star4.setEnabled(false);
        star5.setEnabled(false);


        star1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                star1.setImageResource(R.drawable.star_filled);
                star2.setImageResource(R.drawable.star_empty);
                star3.setImageResource(R.drawable.star_empty);
                star4.setImageResource(R.drawable.star_empty);
                star5.setImageResource(R.drawable.star_empty);

                experienceText.setText("Novice");

            }
        });
        star2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                star1.setImageResource(R.drawable.star_filled);
                star2.setImageResource(R.drawable.star_filled);
                star3.setImageResource(R.drawable.star_empty);
                star4.setImageResource(R.drawable.star_empty);
                star5.setImageResource(R.drawable.star_empty);

                experienceText.setText("Adv. Beginner");



            }
        });
        star3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                star1.setImageResource(R.drawable.star_filled);
                star2.setImageResource(R.drawable.star_filled);
                star3.setImageResource(R.drawable.star_filled);
                star4.setImageResource(R.drawable.star_empty);
                star5.setImageResource(R.drawable.star_empty);

                experienceText.setText("Competent");



            }
        });
        star4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                star1.setImageResource(R.drawable.star_filled);
                star2.setImageResource(R.drawable.star_filled);
                star3.setImageResource(R.drawable.star_filled);
                star4.setImageResource(R.drawable.star_filled);
                star5.setImageResource(R.drawable.star_empty);

                experienceText.setText("Proficient");



            }
        });
        star5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                star1.setImageResource(R.drawable.star_filled);
                star2.setImageResource(R.drawable.star_filled);
                star3.setImageResource(R.drawable.star_filled);
                star4.setImageResource(R.drawable.star_filled);
                star5.setImageResource(R.drawable.star_filled);

                experienceText.setText("Expert");


            }
        });


        final Button button6 = root.findViewById(R.id.button6);
        final Button button5 = root.findViewById(R.id.button5);
        button6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                ImageView image6 = (ImageView) root.findViewById(R.id.imageView6);
                image6.setVisibility(View.VISIBLE);
                ImageView image7 = (ImageView) root.findViewById(R.id.imageView7);
                image7.setVisibility(View.GONE);
                button5.setVisibility(View.VISIBLE);
                button6.setVisibility(View.GONE);


            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                ImageView image6 = (ImageView) root.findViewById(R.id.imageView6);
                image6.setVisibility(View.GONE);
                ImageView image7 = (ImageView) root.findViewById(R.id.imageView7);
                image7.setVisibility(View.VISIBLE);
                button5.setVisibility(View.GONE);
                button6.setVisibility(View.VISIBLE);


            }
        });
        final Button button4 = root.findViewById(R.id.button4);
        final Button button8 = root.findViewById(R.id.button8);
        button4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ScrollView profileLayout = (ScrollView) root.findViewById(R.id.profileLayout);
                ScrollView partnerLayout = (ScrollView) root.findViewById(R.id.partnerLayout);
                ScrollView activityLayout = (ScrollView) root.findViewById(R.id.activityLayout);
                TextView profileUnder = (TextView) root.findViewById(R.id.profileUnder);
                TextView partnerUnder = (TextView) root.findViewById(R.id.partnerUnder);
                TextView activityUnder = (TextView) root.findViewById(R.id.activityUnder);
                TextView textView3 = (TextView) root.findViewById(R.id.textView3);
                ImageView image6 = (ImageView) root.findViewById(R.id.imageView6);
                ImageView image7 = (ImageView) root.findViewById(R.id.imageView7);
                ImageView imageView3 = (ImageView) root.findViewById(R.id.imageView3);

                imageView3.setVisibility(View.VISIBLE);
                image6.setVisibility(View.VISIBLE);
                image7.setVisibility(View.GONE);
                textView3.setVisibility(View.VISIBLE);
                profileUnder.setVisibility(View.VISIBLE);
                partnerUnder.setVisibility(View.GONE);
                activityUnder.setVisibility(View.GONE);
                profileLayout.setVisibility(View.VISIBLE);
                activityLayout.setVisibility(View.INVISIBLE);
                partnerLayout.setVisibility(View.INVISIBLE);


                EditText interest = (EditText) root.findViewById(R.id.interest);
                interest.setPaintFlags(textView.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
                interest.setEnabled(true);

                EditText bio = (EditText) root.findViewById(R.id.bio);
                bio.setPaintFlags(textView.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
                bio.setEnabled(true);

                EditText username = (EditText) root.findViewById(R.id.username);
                username.setPaintFlags(textView.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
                username.setEnabled(true);

                EditText gender = (EditText) root.findViewById(R.id.gender);
                gender.setPaintFlags(textView.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
                gender.setEnabled(true);
                gender.setVisibility(View.VISIBLE);

                EditText birthday = (EditText) root.findViewById(R.id.birthday);
                birthday.setPaintFlags(textView.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
                birthday.setEnabled(true);
                birthday.setVisibility(View.VISIBLE);

                EditText location = (EditText) root.findViewById(R.id.location);
                location.setPaintFlags(textView.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
                location.setEnabled(true);
                location.setVisibility(View.VISIBLE);

                interest.setTextColor(Color.rgb(59, 172,180));
                bio.setTextColor(Color.rgb(59, 172,180));
                username.setTextColor(Color.rgb(59, 172,180));
                gender.setTextColor(Color.rgb(59, 172,180));
                birthday.setTextColor(Color.rgb(59, 172,180));
                location.setTextColor(Color.rgb(59, 172,180));
                experienceText.setTextColor(Color.rgb(59, 172,180));





                button8.setVisibility(View.VISIBLE);
                button4.setVisibility(View.GONE);

                ImageView star_1 = (ImageView) root.findViewById(R.id.star1);
                ImageView star_2 = (ImageView) root.findViewById(R.id.star2);
                ImageView star_3 = (ImageView) root.findViewById(R.id.star3);
                ImageView star_4 = (ImageView) root.findViewById(R.id.star4);
                ImageView star_5 = (ImageView) root.findViewById(R.id.star5);

                star_1.setEnabled(true);
                star_2.setEnabled(true);
                star_3.setEnabled(true);
                star_4.setEnabled(true);
                star_5.setEnabled(true);




            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {


                EditText interest = (EditText) root.findViewById(R.id.interest);
                interest.setEnabled(false);
                interest.setPaintFlags(0);

                EditText bio = (EditText) root.findViewById(R.id.bio);
                bio.setPaintFlags(0);
                bio.setEnabled(false);


                EditText username = (EditText) root.findViewById(R.id.username);
                username.setEnabled(false);
                username.setPaintFlags(0);


                EditText gender = (EditText) root.findViewById(R.id.gender);
                gender.setPaintFlags(0);
                gender.setEnabled(false);

                EditText birthday = (EditText) root.findViewById(R.id.birthday);
                birthday.setPaintFlags(0);
                birthday.setEnabled(false);

                EditText location = (EditText) root.findViewById(R.id.location);
                location.setPaintFlags(0);
                location.setEnabled(false);

                ImageView star_1 = (ImageView) root.findViewById(R.id.star1);
                ImageView star_2 = (ImageView) root.findViewById(R.id.star2);
                ImageView star_3 = (ImageView) root.findViewById(R.id.star3);
                ImageView star_4 = (ImageView) root.findViewById(R.id.star4);
                ImageView star_5 = (ImageView) root.findViewById(R.id.star5);

                star_1.setEnabled(false);
                star_2.setEnabled(false);
                star_3.setEnabled(false);
                star_4.setEnabled(false);
                star_5.setEnabled(false);


                interest.setTextColor(Color.rgb(255, 255,255));
                bio.setTextColor(Color.rgb(255, 255,255));
                username.setTextColor(Color.rgb(255, 255,255));
                gender.setTextColor(Color.rgb(255, 255,255));
                birthday.setTextColor(Color.rgb(255, 255,255));
                location.setTextColor(Color.rgb(255, 255,255));
                experienceText.setTextColor(Color.rgb(255, 255,255));





                button8.setVisibility(View.GONE);
                button4.setVisibility(View.VISIBLE);

                //Reseting to profile page
                ScrollView profileLayout = (ScrollView) root.findViewById(R.id.profileLayout);
                ScrollView partnerLayout = (ScrollView) root.findViewById(R.id.partnerLayout);
                ScrollView activityLayout = (ScrollView) root.findViewById(R.id.activityLayout);


                ImageView image6 = (ImageView) root.findViewById(R.id.imageView6);
                image6.setVisibility(View.VISIBLE);
                ImageView image7 = (ImageView) root.findViewById(R.id.imageView7);
                image7.setVisibility(View.GONE);
                button5.setVisibility(View.VISIBLE);
                button6.setVisibility(View.GONE);
                TextView profileUnder = (TextView) root.findViewById(R.id.profileUnder);
                TextView partnerUnder = (TextView) root.findViewById(R.id.partnerUnder);
                TextView activityUnder = (TextView) root.findViewById(R.id.activityUnder);

                TextView textView3 = (TextView) root.findViewById(R.id.textView3);
                ImageView imageView3 = (ImageView) root.findViewById(R.id.imageView3);
                textView3.setVisibility(View.VISIBLE);
                imageView3.setVisibility(View.VISIBLE);


                profileUnder.setVisibility(View.VISIBLE);
                partnerUnder.setVisibility(View.GONE);
                activityUnder.setVisibility(View.GONE);




                profileLayout.setVisibility(View.VISIBLE);
                activityLayout.setVisibility(View.INVISIBLE);
                partnerLayout.setVisibility(View.INVISIBLE);





            }
        });


        final Button button = root.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d("CLICKED", "Button 1 clicked");
                Log.d("Creation", "Button 1 clicked");
                ScrollView profileLayout = (ScrollView) root.findViewById(R.id.profileLayout);
                ScrollView partnerLayout = (ScrollView) root.findViewById(R.id.partnerLayout);
                ScrollView activityLayout = (ScrollView) root.findViewById(R.id.activityLayout);
                button8.setVisibility(View.GONE);
                button4.setVisibility(View.VISIBLE);


                ImageView image6 = (ImageView) root.findViewById(R.id.imageView6);
                image6.setVisibility(View.VISIBLE);
                ImageView image7 = (ImageView) root.findViewById(R.id.imageView7);
                image7.setVisibility(View.GONE);
                button5.setVisibility(View.VISIBLE);
                button6.setVisibility(View.GONE);
                TextView profileUnder = (TextView) root.findViewById(R.id.profileUnder);
                TextView partnerUnder = (TextView) root.findViewById(R.id.partnerUnder);
                TextView activityUnder = (TextView) root.findViewById(R.id.activityUnder);

                TextView textView3 = (TextView) root.findViewById(R.id.textView3);
                ImageView imageView3 = (ImageView) root.findViewById(R.id.imageView3);
                textView3.setVisibility(View.VISIBLE);
                imageView3.setVisibility(View.VISIBLE);


                profileUnder.setVisibility(View.VISIBLE);
                partnerUnder.setVisibility(View.GONE);
                activityUnder.setVisibility(View.GONE);




                profileLayout.setVisibility(View.VISIBLE);
                activityLayout.setVisibility(View.INVISIBLE);
                partnerLayout.setVisibility(View.INVISIBLE);




                EditText interest = (EditText) root.findViewById(R.id.interest);
                interest.setEnabled(false);
                interest.setPaintFlags(0);

                EditText bio = (EditText) root.findViewById(R.id.bio);
                bio.setPaintFlags(0);
                bio.setEnabled(false);

                EditText username = (EditText) root.findViewById(R.id.username);
                username.setEnabled(false);
                username.setPaintFlags(0);

                EditText gender = (EditText) root.findViewById(R.id.gender);
                gender.setPaintFlags(0);
                gender.setEnabled(false);

                EditText birthday = (EditText) root.findViewById(R.id.birthday);
                birthday.setPaintFlags(0);
                birthday.setEnabled(false);

                EditText location = (EditText) root.findViewById(R.id.location);
                location.setPaintFlags(0);
                location.setEnabled(false);

                gender.setVisibility(View.VISIBLE);
                birthday.setVisibility(View.VISIBLE);
                location.setVisibility(View.VISIBLE);

                ImageView star_1 = (ImageView) root.findViewById(R.id.star1);
                ImageView star_2 = (ImageView) root.findViewById(R.id.star2);
                ImageView star_3 = (ImageView) root.findViewById(R.id.star3);
                ImageView star_4 = (ImageView) root.findViewById(R.id.star4);
                ImageView star_5 = (ImageView) root.findViewById(R.id.star5);

                star_1.setEnabled(false);
                star_2.setEnabled(false);
                star_3.setEnabled(false);
                star_4.setEnabled(false);
                star_5.setEnabled(false);


                interest.setTextColor(Color.rgb(255, 255,255));
                bio.setTextColor(Color.rgb(255, 255,255));
                username.setTextColor(Color.rgb(255, 255,255));
                gender.setTextColor(Color.rgb(255, 255,255));
                birthday.setTextColor(Color.rgb(255, 255,255));
                location.setTextColor(Color.rgb(255, 255,255));
                experienceText.setTextColor(Color.rgb(255, 255,255));

            }
        });

        final Button button2 = root.findViewById(R.id.button2);


        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d("Creation", "Button 2 clicked");
                ScrollView profileLayout = (ScrollView) root.findViewById(R.id.profileLayout);
                ScrollView partnerLayout = (ScrollView) root.findViewById(R.id.partnerLayout);
                ScrollView activityLayout = (ScrollView) root.findViewById(R.id.activityLayout);
                button8.setVisibility(View.GONE);
                button4.setVisibility(View.VISIBLE);


                ImageView image6 = (ImageView) root.findViewById(R.id.imageView6);
                image6.setVisibility(View.GONE);
                ImageView image7 = (ImageView) root.findViewById(R.id.imageView7);
                image7.setVisibility(View.GONE);
                button5.setVisibility(View.GONE);
                button6.setVisibility(View.GONE);
                TextView profileUnder = (TextView) root.findViewById(R.id.profileUnder);
                TextView partnerUnder = (TextView) root.findViewById(R.id.partnerUnder);
                TextView activityUnder = (TextView) root.findViewById(R.id.activityUnder);

                TextView textView3 = (TextView) root.findViewById(R.id.textView3);
                ImageView imageView3 = (ImageView) root.findViewById(R.id.imageView3);
                textView3.setVisibility(View.GONE);
                imageView3.setVisibility(View.GONE);

                profileUnder.setVisibility(View.GONE);
                partnerUnder.setVisibility(View.VISIBLE);
                activityUnder.setVisibility(View.GONE);

                profileLayout.setVisibility(View.INVISIBLE);
                partnerLayout.setVisibility(View.VISIBLE);
                activityLayout.setVisibility(View.INVISIBLE);


                EditText interest = (EditText) root.findViewById(R.id.interest);
                interest.setEnabled(false);
                interest.setPaintFlags(0);

                EditText bio = (EditText) root.findViewById(R.id.bio);
                bio.setPaintFlags(0);
                bio.setEnabled(false);

                EditText username = (EditText) root.findViewById(R.id.username);
                username.setEnabled(false);
                username.setPaintFlags(0);

                EditText gender = (EditText) root.findViewById(R.id.gender);
                gender.setPaintFlags(0);
                gender.setEnabled(false);

                EditText birthday = (EditText) root.findViewById(R.id.birthday);
                birthday.setPaintFlags(0);
                birthday.setEnabled(false);

                EditText location = (EditText) root.findViewById(R.id.location);
                location.setPaintFlags(0);
                location.setEnabled(false);

                gender.setVisibility(View.GONE);
                birthday.setVisibility(View.GONE);
                location.setVisibility(View.GONE);

                ImageView star_1 = (ImageView) root.findViewById(R.id.star1);
                ImageView star_2 = (ImageView) root.findViewById(R.id.star2);
                ImageView star_3 = (ImageView) root.findViewById(R.id.star3);
                ImageView star_4 = (ImageView) root.findViewById(R.id.star4);
                ImageView star_5 = (ImageView) root.findViewById(R.id.star5);

                star_1.setEnabled(false);
                star_2.setEnabled(false);
                star_3.setEnabled(false);
                star_4.setEnabled(false);
                star_5.setEnabled(false);


                interest.setTextColor(Color.rgb(255, 255,255));
                bio.setTextColor(Color.rgb(255, 255,255));
                username.setTextColor(Color.rgb(255, 255,255));
                gender.setTextColor(Color.rgb(255, 255,255));
                birthday.setTextColor(Color.rgb(255, 255,255));
                location.setTextColor(Color.rgb(255, 255,255));
                experienceText.setTextColor(Color.rgb(255, 255,255));

            }
        });

        final Button button3 = root.findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d("Creation", "Button 3 clicked");

                ScrollView profileLayout = (ScrollView) root.findViewById(R.id.profileLayout);
                ScrollView partnerLayout = (ScrollView) root.findViewById(R.id.partnerLayout);
                ScrollView activityLayout = (ScrollView) root.findViewById(R.id.activityLayout);
                button8.setVisibility(View.GONE);
                button4.setVisibility(View.VISIBLE);

                ImageView image6 = (ImageView) root.findViewById(R.id.imageView6);
                image6.setVisibility(View.GONE);
                ImageView image7 = (ImageView) root.findViewById(R.id.imageView7);
                image7.setVisibility(View.GONE);
                button5.setVisibility(View.GONE);
                button6.setVisibility(View.GONE);
                TextView profileUnder = (TextView) root.findViewById(R.id.profileUnder);
                TextView partnerUnder = (TextView) root.findViewById(R.id.partnerUnder);
                TextView activityUnder = (TextView) root.findViewById(R.id.activityUnder);

                TextView textView3 = (TextView) root.findViewById(R.id.textView3);
                ImageView imageView3 = (ImageView) root.findViewById(R.id.imageView3);
                textView3.setVisibility(View.GONE);
                imageView3.setVisibility(View.GONE);



                profileUnder.setVisibility(View.GONE);
                partnerUnder.setVisibility(View.GONE);
                activityUnder.setVisibility(View.VISIBLE);

                profileLayout.setVisibility(View.INVISIBLE);
                partnerLayout.setVisibility(View.INVISIBLE);
                activityLayout.setVisibility(View.VISIBLE);



                EditText interest = (EditText) root.findViewById(R.id.interest);
                interest.setEnabled(false);
                interest.setPaintFlags(0);

                EditText bio = (EditText) root.findViewById(R.id.bio);
                bio.setPaintFlags(0);
                bio.setEnabled(false);

                EditText gender = (EditText) root.findViewById(R.id.gender);
                gender.setPaintFlags(0);
                gender.setEnabled(false);

                EditText birthday = (EditText) root.findViewById(R.id.birthday);
                birthday.setPaintFlags(0);
                birthday.setEnabled(false);

                EditText location = (EditText) root.findViewById(R.id.location);
                location.setPaintFlags(0);
                location.setEnabled(false);

                EditText username = (EditText) root.findViewById(R.id.username);
                username.setEnabled(false);
                username.setPaintFlags(0);

                gender.setVisibility(View.GONE);
                birthday.setVisibility(View.GONE);
                location.setVisibility(View.GONE);

                ImageView star_1 = (ImageView) root.findViewById(R.id.star1);
                ImageView star_2 = (ImageView) root.findViewById(R.id.star2);
                ImageView star_3 = (ImageView) root.findViewById(R.id.star3);
                ImageView star_4 = (ImageView) root.findViewById(R.id.star4);
                ImageView star_5 = (ImageView) root.findViewById(R.id.star5);

                star_1.setEnabled(false);
                star_2.setEnabled(false);
                star_3.setEnabled(false);
                star_4.setEnabled(false);
                star_5.setEnabled(false);

                interest.setTextColor(Color.rgb(255, 255,255));
                bio.setTextColor(Color.rgb(255, 255,255));
                username.setTextColor(Color.rgb(255, 255,255));
                gender.setTextColor(Color.rgb(255, 255,255));
                birthday.setTextColor(Color.rgb(255, 255,255));
                location.setTextColor(Color.rgb(255, 255,255));
                experienceText.setTextColor(Color.rgb(255, 255,255));
            }
        });




        return root;
    }

}
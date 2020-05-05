package com.example.socafit.ui.findfriends.chats;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import com.example.socafit.R;

import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.List;

public class JamesChatActivity extends AppCompatActivity {

    EditText editText;
    MessageAdapter messageAdapter;
    ListView list_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_james_chat);
        editText = findViewById(R.id.jamessend);
        messageAdapter = new MessageAdapter(this);
        list_view = findViewById(R.id.messages_view);
        list_view.setAdapter(messageAdapter);
        Message helloWorld = new Message("Hey I saw your post, are you still looking for a partner today?", false, "James", R.drawable.james);
        Message helloWorld2 = new Message("Yeah! Are you free this afternoon at 1? The university gym?", true, "", 0);
        Message helloWorld3 = new Message("Yup, see you then!", false, "James", R.drawable.james);
        Message helloWorld4 = new Message("Here!", false, "James", R.drawable.james);
        Message helloWorld5 = new Message("I don't see you, I'm wearing a red shirt", true, "", 0);
        onMessage(helloWorld);
        onMessage(helloWorld2);
        onMessage(helloWorld3);
        onMessage(helloWorld4);
        onMessage(helloWorld5);
    }

    public void sendMessage(View view) {
        String message = editText.getText().toString();
        if (message.length() > 0) {
            editText.getText().clear();
        }
        onMessage(new Message(message, true, "", 0));
    }

    public void onMessage(Message message) {
        try {
            messageAdapter.add(message);
            list_view.setSelection(list_view.getCount() - 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

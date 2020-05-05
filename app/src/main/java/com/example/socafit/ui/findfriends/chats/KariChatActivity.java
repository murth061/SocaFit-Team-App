package com.example.socafit.ui.findfriends.chats;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import com.example.socafit.R;

public class KariChatActivity extends AppCompatActivity {

    EditText editText;
    MessageAdapter messageAdapter;
    ListView list_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kari_chat);
        editText = findViewById(R.id.karisend);
        messageAdapter = new MessageAdapter(this);
        list_view = findViewById(R.id.messages_view);
        list_view.setAdapter(messageAdapter);
        Message helloWorld = new Message("Hey wanna work out together? I am looking for a good running partner.", true, "", 0);
        Message helloWorld2 = new Message("Hey sure, are you looking for a long or short run?", false, "Kari", R.drawable.kari);
        onMessage(helloWorld);
        onMessage(helloWorld2);
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

package com.example.socafit.ui.findfriends.chats;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import com.example.socafit.R;

import java.util.List;

public class CharlieChatActivity extends AppCompatActivity {

    EditText editText;
    MessageAdapter messageAdapter;
    ListView list_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_charlie_chat);
        editText = findViewById(R.id.charliesend);
        messageAdapter = new MessageAdapter(this);
        list_view = findViewById(R.id.messages_view);
        list_view.setAdapter(messageAdapter);
        Message helloWorld = new Message("Hey it's Charlie from the competition!", false, "Charlie", R.drawable.charlie);
        Message helloWorld2 = new Message("Hey Charlie! We should for sure train for that weightlifting comp you were telling me about.", true, "", 0);
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

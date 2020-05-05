package com.example.socafit.ui.findfriends.chats;

import android.graphics.drawable.Drawable;

public class Message {
    private String text; // message body
    private String fromName;
    private int fromPic;
    private boolean belongsToCurrentUser; // is this message sent by us?

    public Message(String text, boolean belongsToCurrentUser, String fromName, int fromPic) {
        this.text = text;
        this.fromPic = fromPic;
        this.fromName = fromName;
        this.belongsToCurrentUser = belongsToCurrentUser;
    }

    public String getText() {
        return text;
    }
    public int getPic() {
        return fromPic;
    }
    public String getName() {
        return fromName;
    }


    public boolean isBelongsToCurrentUser() {
        return belongsToCurrentUser;
    }
}

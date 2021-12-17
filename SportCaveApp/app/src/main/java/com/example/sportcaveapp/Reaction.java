package com.example.sportcaveapp;

import com.parse.ParseClassName;
import com.parse.ParseObject;
import com.parse.ParseUser;

@ParseClassName("Reaction")
public class Reaction extends ParseObject {
    public static final String KEY_COMMENT = "comment";
    public static final String KEY_USER = "user";
    public static final String KEY_CREATED_KEY = "createdAt";

    public String getComment() {
        return getString(KEY_COMMENT);
    }

    public void setComment(String comment) {
        put(KEY_COMMENT, comment);
    }

    public ParseUser getUser() {
        return getParseUser(KEY_USER);
    }

    public void setUser(ParseUser user) {
        put(KEY_USER, user);
    }
}

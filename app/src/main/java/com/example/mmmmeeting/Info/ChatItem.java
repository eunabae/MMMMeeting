package com.example.mmmmeeting.Info;

import java.util.Date;

public class ChatItem {

    String id;
    String name;
    String message;
    String time;
    String profilePath;
    Long timestamp;

    public ChatItem(String id, String name, String message, String time, Long timestamp, String profilePath) {
        this.id = id;
        this.name = name;
        this.message = message;
        this.time = time;
        this.timestamp = timestamp;
        this.profilePath = profilePath;
    }

    public ChatItem() {
    }

    //Getter & Setter
    public String getId() { return id; }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public String getProfilePath() {
        return profilePath;
    }

    public void setProfilePath(String profilePath) {
        this.profilePath = profilePath;
    }

}


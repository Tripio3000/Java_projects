package edu.school21.chat;

import java.util.Date;

public class Message {
    private int message_id;
    private int message_author;
    private int message_room;
    private String message_text;
    private Date date;

    public void setDate(Date date) {
        this.date = date;
    }

    public Message(int message_id, int message_author, int message_room, String message_text, Date date) {
        this.message_id = message_id;
        this.message_author = message_author;
        this.message_room = message_room;
        this.message_text = message_text;
        this.date = date;
    }

    public void setMessage_id(int message_id) {
        this.message_id = message_id;
    }

    public void setMessage_author(int message_author) {
        this.message_author = message_author;
    }

    public void setMessage_room(int message_room) {
        this.message_room = message_room;
    }

    public void setMessage_text(String message_text) {
        this.message_text = message_text;
    }

    public int getMessage_author() {
        return message_author;
    }

    public int getMessage_id() {
        return message_id;
    }

    public int getMessage_room() {
        return message_room;
    }

    public String getMessage_text() {
        return message_text;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

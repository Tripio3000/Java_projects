package edu.school21.chat;

import java.util.ArrayList;
import java.util.List;

public class Chatroom {
    private int chatroom_id;
    private String chatroom_name;
    private int chatroom_owner;
    private List<Message> List_of_messages_in_a_chatroom;


    public Chatroom(int chatroom_id, String chatroom_name, int chatroom_owner) {
        this.chatroom_id = chatroom_id;
        this.chatroom_name = chatroom_name;
        this.chatroom_owner = chatroom_owner;
        List_of_messages_in_a_chatroom = new ArrayList<Message>();
    }

    public int getChatroom_id() {
        return chatroom_id;
    }

    public String getChatroom_name() {
        return chatroom_name;
    }

    public int getChatroom_owner() {
        return chatroom_owner;
    }

    public void setChatroom_id(int chatroom_id) {
        this.chatroom_id = chatroom_id;
    }

    public void setChatroom_name(String chatroom_name) {
        this.chatroom_name = chatroom_name;
    }

    public void setChatroom_owner(int chatroom_owner) {
        this.chatroom_owner = chatroom_owner;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

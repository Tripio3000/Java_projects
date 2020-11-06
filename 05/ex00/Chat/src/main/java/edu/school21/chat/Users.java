package edu.school21.chat;

import java.util.ArrayList;
import java.util.List;

public class Users {
    private int user_id;
    private String login;
    private String password;
    private List<Chatroom> list_of_created_rooms;
    private List<Chatroom> list_of_chatrooms_where_a_user_socializes;

    public Users(int user_id, String login, String password) {
        this.user_id = user_id;
        this.login = login;
        this.password = password;
        list_of_created_rooms = new ArrayList<Chatroom>();
        list_of_chatrooms_where_a_user_socializes = new ArrayList<Chatroom>();
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

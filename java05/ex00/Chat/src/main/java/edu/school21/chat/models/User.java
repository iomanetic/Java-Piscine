package edu.school21.chat.models;

import java.util.ArrayList;
import java.util.Objects;

public class User {

    private int userId;
    private String login;
    private String password;
    private ArrayList<ChatRoom> createdRooms;
    private ArrayList<ChatRoom> chatsSocializes;

    public User(int userId, String login, String password,
                ArrayList<ChatRoom> createdRooms, ArrayList<ChatRoom> chatsSocializes) {
        this.userId = userId;
        this.login = login;
        this.password = password;
        this.createdRooms = createdRooms;
        this.chatsSocializes = chatsSocializes;
    }

    public int getUserId() {
        return (this.userId);
    }

    public String getLogin() {
        return (this.login);
    }

    public String getPassword() {
        return (this.password);
    }

    public ArrayList<ChatRoom> getCreatedRooms() {
        return (this.createdRooms);
    }

    public ArrayList<ChatRoom> getChatsSocializes() {
        return (this.chatsSocializes);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return (userId == user.userId && Objects.equals(login, user.login)
                        && Objects.equals(password, user.password)
                        && Objects.equals(createdRooms, user.createdRooms)
                        && Objects.equals(chatsSocializes, user.chatsSocializes));
    }

    @Override
    public int hashCode() {
        return (Objects.hash(userId, login, password, createdRooms, chatsSocializes));
    }

    @Override
    public String toString() {
        return ("User{" +
                "userId=" + userId +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", createdRooms=" + createdRooms +
                ", chatsSocializes=" + chatsSocializes +
                '}');
    }
}

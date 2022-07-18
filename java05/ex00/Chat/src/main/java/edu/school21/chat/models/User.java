package edu.school21.chat.models;

import java.util.ArrayList;
import java.util.Objects;

public class User {

    private Integer userId;
    private String login;
    private String password;
    private ArrayList<ChatRoom> createdRooms;
    private ArrayList<ChatRoom> roomsSocializes;

    public User(Integer userId, String login, String password,
                ArrayList<ChatRoom> createdRooms, ArrayList<ChatRoom> chatsSocializes) {
        this.userId = userId;
        this.login = login;
        this.password = password;
        this.createdRooms = createdRooms;
        this.roomsSocializes = chatsSocializes;
    }

    public Integer getUserId() {
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
        return (this.roomsSocializes);
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
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
                && Objects.equals(roomsSocializes, user.roomsSocializes));
    }

    @Override
    public int hashCode() {
        return (Objects.hash(userId, login, password, createdRooms, roomsSocializes));
    }

    @Override
    public String toString() {
        return ("User{" +
                "userId=" + userId +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", createdRooms=" + createdRooms +
                ", chatsSocializes=" + roomsSocializes +
                '}');
    }
}

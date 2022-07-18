package edu.school21.chat.models;

import java.util.ArrayList;
import java.util.Objects;

public class Chat {

    private int chatRoomId;
    private int chatRoomOwner;
    private String chatRoomName;
    private ArrayList<Message> listOfMessages;

    public Chat(int chatRoomId, int chatRoomOwner, String chatRoomName,
                ArrayList<Message> listOfMessages) {
        this.chatRoomId = chatRoomId;
        this.chatRoomOwner = chatRoomOwner;
        this.chatRoomName = chatRoomName;
        this.listOfMessages = listOfMessages;
    }

    public int getChatRoomId() {
        return (this.chatRoomId);
    }

    public int getChatRoomOwner() {
        return (this.chatRoomOwner);
    }

    public String getChatRoomName() {
        return (this.chatRoomName);
    }

    public ArrayList<Message> getListOfMessages() {
        return (this.listOfMessages);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Chat chat = (Chat) o;
        return (chatRoomId == chat.chatRoomId
                && chatRoomOwner == chat.chatRoomOwner
                && Objects.equals(chatRoomName, chat.chatRoomName)
                && Objects.equals(listOfMessages, chat.listOfMessages));
    }

    @Override
    public int hashCode() {
        return (Objects.hash(chatRoomId, chatRoomOwner, chatRoomName, listOfMessages));
    }

    @Override
    public String toString() {
        return ("Chat{" +
                "chatRoomId=" + chatRoomId +
                ", chatRoomOwner=" + chatRoomOwner +
                ", chatRoomName='" + chatRoomName + '\'' +
                ", listOfMessages=" + listOfMessages +
                '}');
    }
}

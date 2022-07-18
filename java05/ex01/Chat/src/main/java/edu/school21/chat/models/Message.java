package edu.school21.chat.models;

import java.text.DateFormat;
import java.util.Objects;

public class Message {

    private Integer messageId;
    private User messageAutor;
    private ChatRoom chatWhereIsMessage;
    private String messageText;
    private DateFormat dateAndTime;

    public Message(Integer messageId, User messageAutor, ChatRoom chatWhereIsMessage,
                   String messageText, DateFormat dateAndTime) {
        this.messageId = messageId;
        this.messageAutor = messageAutor;
        this.chatWhereIsMessage = chatWhereIsMessage;
        this.messageText = messageText;
        this.dateAndTime = dateAndTime;
    }

    public Integer getMessageId() {
        return (this.messageId);
    }

    public User getMessageAutor() {
        return (this.messageAutor);
    }

    public ChatRoom getMessageRoom() {
        return (this.chatWhereIsMessage);
    }

    public String getMessageText() {
        return (this.messageText);
    }

    public DateFormat getDateAndTime() {
        return (this.dateAndTime);
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    public void setMessageAutor(User messageAutor) {
        this.messageAutor = messageAutor;
    }

    public void setChatWhereIsMessage(ChatRoom chatWhereIsMessage) {
        this.chatWhereIsMessage = chatWhereIsMessage;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public void setDateAndTime(DateFormat dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Message message = (Message) o;
        return (messageId == message.messageId
                && Objects.equals(messageAutor, message.messageAutor)
                && Objects.equals(chatWhereIsMessage, message.chatWhereIsMessage)
                && Objects.equals(messageText, message.messageText)
                && Objects.equals(dateAndTime, message.dateAndTime));
    }

    @Override
    public int hashCode() {
        return (Objects.hash(messageId, messageAutor, chatWhereIsMessage, messageText, dateAndTime));
    }

    @Override
    public String toString() {
        return ("Message{" +
                "messageId=" + messageId +
                ", messageAutor='" + messageAutor + '\'' +
                ", messageRoom='" + chatWhereIsMessage + '\'' +
                ", messageText='" + messageText + '\'' +
                ", dateAndTime=" + dateAndTime +
                '}');
    }
}

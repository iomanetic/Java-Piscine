package edu.school21.chat;

import java.text.DateFormat;
import java.util.Objects;

public class Message {

    private int messageId;
    private int messageAutor;
    private Chat chatWhereIsMessage;
    private String messageText;
    private DateFormat dateAndTime;

    public Message(int messageId, int messageAutor, Chat chatWhereIsMessage,
                   String messageText, DateFormat dateAndTime) {
        this.messageId = messageId;
        this.messageAutor = messageAutor;
        this.chatWhereIsMessage = chatWhereIsMessage;
        this.messageText = messageText;
        this.dateAndTime = dateAndTime;
    }

    public int getMessageId() {
        return (this.messageId);
    }

    public int getMessageAutor() {
        return (this.messageAutor);
    }

    public Chat getMessageRoom() {
        return (this.chatWhereIsMessage);
    }

    public String getMessageText() {
        return (this.messageText);
    }

    public DateFormat getDateAndTime() {
        return (this.dateAndTime);
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

package edu.school21.chat.models;

import java.time.LocalDateTime;
import java.util.Objects;

public class Message {

    private Long messageId;
    private User messageAutor;
    private ChatRoom chatWhereIsMessage;
    private String messageText;
    private LocalDateTime dateAndTime;

    public Message(Long messageId, User messageAutor, ChatRoom chatWhereIsMessage,
                   String messageText, LocalDateTime dateAndTime) {
        this.messageId = messageId;
        this.messageAutor = messageAutor;
        this.chatWhereIsMessage = chatWhereIsMessage;
        this.messageText = messageText;
        this.dateAndTime = dateAndTime;
    }

    public Long getMessageId() {
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

    public LocalDateTime getDateAndTime() {
        return (this.dateAndTime);
    }

    public void setMessageId(Long messageId) {
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

    public void setDateAndTime(LocalDateTime dateAndTime) {
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
        return ("Message:" +
                "\nmessageId=" + messageId +
                "\nmessageAutor='" + messageAutor + '\'' +
                "\nmessageRoom='" + chatWhereIsMessage + '\'' +
                "\nmessageText='" + messageText + '\'' +
                "\ndateAndTime=" + dateAndTime);
    }
}

package edu.school21.chat.app;

import com.zaxxer.hikari.HikariDataSource;
import edu.school21.chat.models.ChatRoom;
import edu.school21.chat.models.Message;
import edu.school21.chat.models.User;
import edu.school21.chat.repositories.MessagesRepositoryJdbcImpl;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String username = "postgres";
        String password = "postgres";
        Scanner scan = new Scanner(System.in);
        Long id;

        HikariDataSource db = new HikariDataSource();
        db.setJdbcUrl(url);
        db.setUsername(username);
        db.setPassword(password);
        db.getConnection();

        MessagesRepositoryJdbcImpl messagesRepository = new MessagesRepositoryJdbcImpl(db);
        Optional<Message> message_o = messagesRepository.findById(5L);
        if(message_o.isPresent()) {
            Message message = message_o.get();
            message.setMessageText("Hello");
            message.setDateAndTime(LocalDateTime.now());
            messagesRepository.update(message);
            System.out.println(message_o.get());
        }
    }
}
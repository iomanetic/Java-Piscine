package edu.school21.chat.app;

import com.zaxxer.hikari.HikariDataSource;
import edu.school21.chat.models.ChatRoom;
import edu.school21.chat.models.Message;
import edu.school21.chat.models.User;
import edu.school21.chat.repositories.MessagesRepositoryJdbcImpl;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
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

        User autor = new User(5L, "employees_user", "mypassisveryhard", new ArrayList<>(), new ArrayList<>());
        User creator = autor;
        ChatRoom room = new ChatRoom(5L, creator, "roomForGames", new ArrayList<>());
        Message message = new Message(null, autor, room, "Hello tyyuuki!!!!!", LocalDateTime.now());
        MessagesRepositoryJdbcImpl messagesRepository = new MessagesRepositoryJdbcImpl(db);
        messagesRepository.save(message);
        System.out.println(message.getMessageId());

        User autor2 = new User(11L, "employees_user", "mypassisveryhard", new ArrayList<>(), new ArrayList<>());
        ChatRoom room2 = new ChatRoom(12L, creator, "roomForGames", new ArrayList<>());
        Message message2 = new Message(null, autor2, room2, "Hello tyyuuki!!!!!", LocalDateTime.now());
        messagesRepository.save(message2);
        System.out.println(message2.getMessageId());
    }
}
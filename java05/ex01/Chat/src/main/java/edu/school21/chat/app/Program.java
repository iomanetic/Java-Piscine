package edu.school21.chat.app;

import com.zaxxer.hikari.HikariDataSource;
import edu.school21.chat.models.Message;
import edu.school21.chat.repositories.MessagesRepositoryJdbcImpl;

import java.sql.SQLException;
import java.util.Optional;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String username = "postgres";
        String password = "postgres";
        Long id;
        Scanner scan = new Scanner(System.in);

        HikariDataSource db = new HikariDataSource();
        db.setJdbcUrl(url);
        db.setUsername(username);
        db.setPassword(password);
        db.getConnection();

        System.out.print("Enter a message ID: ");
        id = scan.nextLong();

        MessagesRepositoryJdbcImpl get = new MessagesRepositoryJdbcImpl(db);
        Optional<Message> message = get.findById(id);
        System.out.println(message.get());
        scan.close();
    }
}
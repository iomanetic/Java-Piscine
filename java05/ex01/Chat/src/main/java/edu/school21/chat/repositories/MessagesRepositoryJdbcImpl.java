package edu.school21.chat.repositories;

import edu.school21.chat.models.ChatRoom;
import edu.school21.chat.models.Message;
import edu.school21.chat.models.User;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Optional;

public class MessagesRepositoryJdbcImpl implements MessagesRepository {

    private DataSource dataSource;

    public MessagesRepositoryJdbcImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Optional<Message> findById(Long id) throws SQLException {
        final String SQL_QUERY = "SELECT * FROM chat.messages WHERE message_id = " + id;
        Connection connect = dataSource.getConnection();
        PreparedStatement prs = connect.prepareStatement(SQL_QUERY);
        ResultSet result = prs.executeQuery();
        result.next();
        User user = new User(1, "tyuuki", "karimvaliev", null, null);
        ChatRoom room = new ChatRoom(1, user, "newRoom", null);
        Optional<Message> message = Optional.of(new Message((long)result.getInt(1),
                                                user, room, result.getString("message_text"),
                                                LocalDateTime.of(2022, 8, 18, 13,4)));
        connect.close();
        prs.close();
        return (message);
    }
}

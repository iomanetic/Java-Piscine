package edu.school21.chat.repositories;

import edu.school21.chat.exceptions.NotSavedSubEntityException;
import edu.school21.chat.models.ChatRoom;
import edu.school21.chat.models.Message;
import edu.school21.chat.models.User;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.Optional;

public class MessagesRepositoryJdbcImpl implements MessagesRepository {

    private DataSource dataSource;

    public MessagesRepositoryJdbcImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void save(Message message) throws SQLException {
        final String SQL_QUERY = "INSERT INTO chat.messages(message_autor, room_id, message_text, date_of_message) " +
                            "VALUES (" + "'" + message.getMessageAutor().getUserId() + "'" + ',' + "'" + message.getMessageRoom().getChatRoomId() + "'"+
                            ',' + "'" + message.getMessageText() + "'" + ',' + "'" + message.getDateAndTime() + "'" + ')';
        Connection connect = dataSource.getConnection();
        PreparedStatement prs = connect.prepareStatement(SQL_QUERY, Statement.RETURN_GENERATED_KEYS);
        try {
            prs.execute();
            ResultSet key = prs.getGeneratedKeys();
            key.next();
            message.setMessageId(key.getLong(1));
        } catch (SQLException ex) {
            throw new NotSavedSubEntityException("Autor or room ID error");
        }
        connect.close();
        prs.close();
    }

    @Override
    public Optional<Message> findById(Long id) throws SQLException {
        final String SQL_QUERY = "SELECT * FROM chat.messages WHERE message_id = " + id;
        Connection connect = dataSource.getConnection();
        PreparedStatement prs = connect.prepareStatement(SQL_QUERY);
        ResultSet result = prs.executeQuery();
        result.next();
        User user = new User(1L, "tyuuki", "karimvaliev", null, null);
        ChatRoom room = new ChatRoom(1L, user, "newRoom", null);
        Optional<Message> message = Optional.of(new Message((long)result.getInt(1),
                                                user, room, result.getString("message_text"),
                                                LocalDateTime.of(2022, 8, 18, 13,4)));
        connect.close();
        prs.close();
        return (message);
    }
}

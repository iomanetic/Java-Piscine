package school21.spring.service.repositories;

import school21.spring.service.models.User;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsersRepositoryJdbcImpl implements UsersRepository {

    private DataSource dataSource;

    private final String SQL_DELETE_TABLE = "DROP TABLE hikari_table CASCADE";
    private String SQL_TABLE_INIT = "CREATE TABLE if not exists hikari_table(" +
                                    "id INT PRIMARY KEY, " +
                                    "email TEXT" +
                                    ")";
    private String SQL_FIND_BY_EMAIL = "SELECT * FROM hikari_table WHERE email = ?";
    private String SQL_FIND_BY_ID = "SELECT * FROM hikari_table WHERE id = ?";
    private String SQL_FIND_ALL = "SELECT * FROM hikari_table";
    private String SQL_SAVE = "INSERT INTO hikari_table(id, email) VALUES(?, ?)";
    private String SQL_UPDATE = "UPDATE hikari_table SET email = ? WHERE id = ?";
    private String SQL_DELETE = "DELETE FROM hikari_table WHERE id = ?";

    public UsersRepositoryJdbcImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void tableInit() throws SQLException {
        Connection connect = null;
        PreparedStatement statement = null;

        try {
            connect = dataSource.getConnection();
            statement = connect.prepareStatement(SQL_DELETE_TABLE);
            statement.execute();
            statement.close();
            statement = connect.prepareStatement(SQL_TABLE_INIT);
            statement.execute();
            connect.close();
            statement.close();
        } catch (Exception ex) {
            System.err.println("Error:\ntableInit");
        }
    }

    @Override
    public Optional<User> findByEmail(String email) throws SQLException {
        Connection connect = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        Optional<User> user = null;

        try {
            connect = dataSource.getConnection();
            statement = connect.prepareStatement(SQL_FIND_BY_EMAIL);
            statement.setString(1, email);
            result = statement.executeQuery();
            result.next();
            user = Optional.of(new User(result.getLong(1), result.getString(2)));
        } catch (Exception ex) {
            System.err.println("Error:\nfindByEmail");
        }
        return (user);
    }

    @Override
    public Optional<User> findById(Long id) throws SQLException {
        Connection connect = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        Optional<User> user = null;

        try {
            connect = dataSource.getConnection();
            statement = connect.prepareStatement(SQL_FIND_BY_ID);
            statement.setLong(1, id);
            result = statement.executeQuery();
            result.next();
            user = Optional.of(new User(result.getLong(1), result.getString(2)));
        } catch (Exception ex) {
            System.err.println("Error:\nfindById");
        }
        return (user);
    }

    @Override
    public List<User> findAll() throws SQLException {
        Connection connect = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        List<User> users = null;

        try {
            connect = dataSource.getConnection();
            statement = connect.prepareStatement(SQL_FIND_ALL);
            result = statement.executeQuery();
        } catch (Exception ex) {
            System.err.println("findAll");
        }
            users = new ArrayList<>();
        while(result.next()) {
            users.add(new User(result.getLong(1), result.getString(2)));
        }
        return (users);
    }

    @Override
    public void save(User entity) throws SQLException {
        Connection connect = null;
        PreparedStatement statement = null;

        try {
            connect = dataSource.getConnection();
            statement = connect.prepareStatement(SQL_SAVE);
            statement.setLong(1, entity.getId());
            statement.setString(2, entity.getEmail());
            statement.execute();
        } catch (Exception ex) {
            System.err.println("Error:\nsave");
        }
    }

    @Override
    public void update(User entity) throws SQLException {
        Connection connect = null;
        PreparedStatement statement = null;

        try {
            connect = dataSource.getConnection();
            statement = connect.prepareStatement(SQL_UPDATE);
            statement.setString(1, entity.getEmail());
            statement.setLong(2, entity.getId());
            statement.execute();
        } catch (Exception ex) {
            System.err.println("Error:\nupdate");
        }
    }

    @Override
    public void delete(Long id) throws SQLException {
        Connection connect = null;
        PreparedStatement statement = null;

        try {
            connect = dataSource.getConnection();
            statement = connect.prepareStatement(SQL_DELETE);
            statement.setLong(1, id);
            statement.execute();
        } catch (Exception ex) {
            System.err.println("Error:\ndelete");
        }
    }
}

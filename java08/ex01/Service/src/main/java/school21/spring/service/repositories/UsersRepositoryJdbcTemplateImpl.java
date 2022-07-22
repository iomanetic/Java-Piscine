package school21.spring.service.repositories;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import school21.spring.service.models.User;

import java.util.List;
import java.util.Optional;

public class UsersRepositoryJdbcTemplateImpl implements UsersRepository {

    private JdbcTemplate dataSource;

    private final String SQL_DELETE_TABLE = "DROP TABLE spring_jdbc_table CASCADE";
    private final String SQL_TABLE_INIT = "CREATE TABLE if not exists spring_jdbc_table(" +
            "id INT PRIMARY KEY, " +
            "email TEXT" +
            ")";
    private final String SQL_FIND_BY_EMAIL = "SELECT * FROM spring_jdbc_table WHERE email = ?";
    private final String SQL_FIND_BY_ID = "SELECT * FROM spring_jdbc_table WHERE id = ?";
    private final String SQL_FIND_ALL = "SELECT * FROM spring_jdbc_table";
    private final String SQL_SAVE = "INSERT INTO spring_jdbc_table(id, email) VALUES(?, ?)";
    private final String SQL_UPDATE = "UPDATE spring_jdbc_table SET email = ? WHERE id = ?";
    private final String SQL_DELETE = "DELETE FROM spring_jdbc_table WHERE id = ?";


    public UsersRepositoryJdbcTemplateImpl(DriverManagerDataSource dataSource) {
        this.dataSource = new JdbcTemplate(dataSource);
    }

    public void tableInit() {
        try {
            dataSource.update(SQL_DELETE_TABLE);
            dataSource.update(SQL_TABLE_INIT);
        } catch (Exception ex) {
            System.err.println("Error:\ncreateTable");
        }
    }

    @Override
    public Optional<User> findById(Long id) {
        Optional<User> user = null;

        try {
            user = dataSource.queryForObject(SQL_FIND_BY_ID, new BeanPropertyRowMapper<>(), id);
        } catch (Exception ex) {
            System.err.println("Error:\nfindById");
        }
        return (user);
    }

    @Override
    public List<User> findAll() {
        List<User> users = null;

        try {
            users = dataSource.query(SQL_FIND_ALL, new BeanPropertyRowMapper<>(User.class));
        } catch (Exception ex) {
            System.err.println("Error:\nfindAll");
        }
        return (users);
    }

    @Override
    public void save(User entity) {
        try {
            dataSource.update(SQL_SAVE, entity.getId(), entity.getEmail());
        } catch (Exception ex) {
            System.err.println("Error:\nsave");
        }
    }

    @Override
    public void update(User entity) {
        try {
            dataSource.update(SQL_UPDATE, entity.getEmail(), entity.getId());
        } catch (Exception ex) {
            System.err.println("Error:\nupdate");
        }
    }

    @Override
    public void delete(Long id) {
        dataSource.update(SQL_DELETE, id);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        List<User> user = null;
        Optional<User> userOptional = null;

        try {
            user = dataSource.query(SQL_FIND_BY_EMAIL, new BeanPropertyRowMapper<>(User.class), email);
            userOptional = Optional.of(user.get(0));
            return (userOptional);
        } catch (IndexOutOfBoundsException ex) {
            System.err.println("Error:\nfindByEmail");
        }
        return (null);
    }
}

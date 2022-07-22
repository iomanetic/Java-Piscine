package school21.spring.service.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import school21.spring.service.models.User;
import school21.spring.service.repositories.UsersRepository;
import school21.spring.service.repositories.UsersRepositoryJdbcImpl;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        UsersRepository usersRepository = null;
        UsersRepository springUsersRepository = null;
        User userOne = null;
        User userTwo = null;

        System.out.println("\n\nHikari_Table:");
        usersRepository = context.getBean("userRepJbcd", UsersRepositoryJdbcImpl.class);
        userOne = new User(33L, "loli78@yandex.ru");
        userTwo = new User(35L, "popkins@yandex.ru");
        usersRepository.save(userTwo);
        usersRepository.save(userOne);
        usersRepository.save(new User(37L, "email@mail.ru"));
        List<User> users = usersRepository.findAll();
        for(int i = 0; i < users.size(); i++) {
            System.out.println(users.get(i).getId() + " : " + users.get(i).getEmail());
        }

        System.out.println("\n\nSpring_Table:");
        springUsersRepository = context.getBean("userRepSpring", UsersRepository.class);
        springUsersRepository.save(userOne);
        springUsersRepository.save(userTwo);
        springUsersRepository.save(new User(36L, "popkins@yandex.ru"));
        springUsersRepository.save(new User(38L, "emely@yandex.ru"));
        List<User> usersSpring = springUsersRepository.findAll();
        for(int i = 0; i < usersSpring.size(); i++) {
            System.out.println(usersSpring.get(i).getId() + " : " + usersSpring.get(i).getEmail());
        }
    }
}
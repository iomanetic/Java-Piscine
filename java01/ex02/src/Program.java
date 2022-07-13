public class Program {
    public static void main(String[] args) throws UserNotFoundException {
        UsersArrayList userList = new UsersArrayList();

        userList.addUser(new User("Karim", 1000));
        userList.addUser(new User("Petya", 1000));
        userList.addUser(new User("Artem", 1000));
        userList.addUser(new User("Egor", 1000));
        userList.addUser(new User("Sasha", 1000));
        userList.addUser(new User("Misha", 1000));
        userList.addUser(new User("Jenya", 1000));
        userList.addUser(new User("Ira", 1000));
        userList.addUser(new User("Andrey", 1000));
        userList.addUser(new User("Nikita", 1000));
        userList.addUser(new User("Dima", 1000));
        userList.addUser(new User("Mark", 1000));
        System.out.println("Number of users - " + userList.getNumOfUsers());
        System.out.println("By index - " + userList.getUserWithIndex(11).getName());
        System.out.println("By id - " + userList.getUserWithId(1).getName());
        System.out.println("By id - " + userList.getUserWithId(-1).getName());
    }
}
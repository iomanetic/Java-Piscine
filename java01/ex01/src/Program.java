public class Program {
    public static void main(String[] args) {
        User user1 = new User("Karim", 1000);
        User user2 = new User("Artem", 1000);
        User user3 = new User("Egor", 1000);

        System.out.println(user1.getName() + ": " + user1.getId());
        System.out.println(user2.getName() + ": " + user2.getId());
        System.out.println(user3.getName() + ": " + user3.getId());
        System.out.println(user1.getName() + ": " + user1.getId());
    }
}
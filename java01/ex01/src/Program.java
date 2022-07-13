public class Program {
    public static void main(String[] args) {
        User user1 = new User("Karim", 1000);
        User user2 = new User("Artem", 1000);
        User user3 = new User("Egor", 1000);

        System.out.println("\n\nConfiguration with constructor");
        System.out.println(user1.getName() + ": " + user1.getId() + " balance: " + user1.getBalance());
        System.out.println(user2.getName() + ": " + user2.getId() + " balance: " + user2.getBalance());
        System.out.println(user3.getName() + ": " + user3.getId() + " balance: " + user3.getBalance());

        System.out.println("\n\nConfiguration with setters");
        user1.setName("");
        user1.setBalance(-1);
        System.out.println(user1.getName() + ": " + user1.getId() + " balance: " + user1.getBalance());
        user2.setName("Andrey");
        user2.setBalance(932);
        System.out.println(user2.getName() + ": " + user2.getId() + " balance: " + user2.getBalance());
    }
}
import java.sql.SQLOutput;

public class Program {
    public static void main(String[] args) {
        User user1 = new User("Karim", 40000);
        User user2 = new User("Sasha", 0);
        User recipient;
        User sender;

        Transaction tran1 = new Transaction(user2, user1, -40000);
        recipient = tran1.getRecipient();
        sender = tran1.getSender();
        System.out.print("Sender id: " + sender.getId() + " " + sender.getName() + " -> " + recipient.getName() + " ");
        System.out.print(tran1.getAmount() + " ");
        System.out.print(tran1.getType() + " ");
        System.out.println(tran1.getUuid());
        System.out.println(recipient.getName() + " balance is " + recipient.getBalance());
        System.out.println(sender.getName() + " balance is " + sender.getBalance());

        System.out.print("\n\n");

        Transaction tran2 = new Transaction(user2, user1, 40000);
        recipient = tran2.getRecipient();
        sender = tran2.getSender();
        System.out.print("Sender id: " + sender.getId() + " " + sender.getName() + " -> " + recipient.getName() + " ");
        System.out.print(tran2.getAmount() + " ");
        System.out.print(tran2.getType() + " ");
        System.out.println(tran2.getUuid());
        System.out.println(recipient.getName() + " balance is " + recipient.getBalance());
        System.out.println(sender.getName() + " balance is " + sender.getBalance());
    }
}
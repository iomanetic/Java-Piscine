import java.util.UUID;

public class Program {
    public static void main(String[] args) throws TransactionNotFoundException {
        TransactionsLinkedList list = new TransactionsLinkedList();
        Transaction[] arr;
        UUID ud;

        list.addTransaction(new Transaction(new User("Karim", 1000000),
                            new User("Petya", 10000000), 100));

        list.addTransaction(new Transaction(new User("Petya", 1000000),
                            new User("Sergey", 10000000), -100));

        list.addTransaction(new Transaction(new User("Mark", 1000000),
                            new User("Artem", 10000000), 100));

        list.addTransaction(new Transaction(new User("Nikita", 1000000),
                            new User("Danya", 10000000), 100));

        list.addTransaction(new Transaction(new User("Kolya", 1000000),
                            new User("Sasha", 10000000), -100));

        arr = list.convertListToArray(list);
        list.deleteTransactionByIndeficator(arr[4].getUuid());
        arr = list.convertListToArray(list);
        for(int index = 0; arr[index] != null; index++) {
            System.out.println("Sender: " + arr[index].getSender().getName());
            System.out.println("Recipient: " + arr[index].getRecipient().getName());
            System.out.println("Type: " + arr[index].getType());
            System.out.println("Amount: " + arr[index].getAmount());
            System.out.println();
        }

        ud = UUID.randomUUID();
        list.deleteTransactionByIndeficator(ud);
    }
}
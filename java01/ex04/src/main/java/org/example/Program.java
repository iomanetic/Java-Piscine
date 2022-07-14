package org.example;

import java.util.UUID;

public class Program {
    public static void main(String[] args) throws UserNotFoundException,
            IllegalTransactionException, TransactionNotFoundException {
        User karim = new User("Karim", 1000);
        User artem = new User("Artem", 0);
        Transaction[] arr;
        TransactionsService service = new TransactionsService();
        UUID uuid;

        service.addUser(karim);
        service.addUser(artem);

        System.out.println("Karim's balance is " + service.getUserBalance(karim.getId()));
        System.out.println("Artem's balance is " + service.getUserBalance(artem.getId()));
        service.makeTransaction(karim.getId(), artem.getId(), 110);
        service.makeTransaction(artem.getId(), karim.getId(), 90);
        service.makeTransaction(karim.getId(), artem.getId(), 110);
        service.makeTransaction(artem.getId(), karim.getId(), 90);
        service.makeTransaction(karim.getId(), artem.getId(), 110);
        service.makeTransaction(artem.getId(), karim.getId(), 90);
        System.out.println("Karim's balance is " + service.getUserBalance(karim.getId()));
        System.out.println("Artem's balance is " + service.getUserBalance(artem.getId()));

        System.out.println("\nKarim transactions: ");
        TransactionsLinkedList list = service.getUserWithIndex(0).getTransactionList();
        arr = list.convertListToArray(list);
        printLog(arr);
        System.out.println("\nArtem transactions: ");
        list = service.getUserWithIndex(1).getTransactionList();
        arr = list.convertListToArray(list);
        printLog(arr);

        System.out.println("\nKarims's Transactions log");
        arr = service.getTransactionsArr(1);
        printLog(arr);

        arr = service.getTransactionsArr(2);
        uuid = arr[1].getUuid();
        service.deleteTransactionByUserIndeficator(2, uuid);
        uuid = arr[2].getUuid();
        service.deleteTransactionByUserIndeficator(2, uuid);
        System.out.println("\nKarims's Transactions log after delete log by UUID: " + uuid);
        arr = service.getTransactionsArr(1);
        printLog(arr);

        System.out.println("\nArtem's Transactions log after delete log by UUID: " + uuid);
        arr = service.getTransactionsArr(2);
        printLog(arr);

        System.out.println("\nUnpair transactions");
        arr = service.getArrayUnpairTransactions();
        printLog(arr);
    }

    private static void printLog(Transaction[] arr) {
        for(int count = 0; count < arr.length; count++) {
            System.out.print(arr[count].getSender().getName() + " -> " +  arr[count].getRecipient().getName() + " ");
            System.out.print((arr[count].getType() == "CREDIT") ? "-" + arr[count].getAmount() + " "
                    : "+" + arr[count].getAmount() + " ");
            System.out.print(arr[count].getType() + " ");
            System.out.println("(UUID " + arr[count].getUuid() + ")");
        }
    }
}
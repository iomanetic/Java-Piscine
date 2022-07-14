package org.example;

public class User {
    private final Integer id;

    private String name;

    private Integer balance;

    private TransactionsLinkedList transactionList;

    public User(String name, int balance) {
        this.name = name;
        if(name.length() == 0) {
            this.name = "Anonimus";
        }
        this.balance = balance;
        if(this.balance < 0) {
            this.balance = 0;
        }
        this.id = UserIdsGenerator.getInstance().generateId();
        transactionList = new TransactionsLinkedList();
    }

    public void addNewTran(Transaction transaction) {
        transactionList.addTransaction(transaction);
    }

    public TransactionsLinkedList getTransactionList() {
        return (transactionList);
    }

    public int getId() {
        return (id);
    }

    public String getName() {
        return (this.name);
    }

    public int getBalance() {
        return (this.balance);
    }

    public void setBalance(int balance) {
        if(balance < 0) {
            balance = 0;
        }
        this.balance = balance;
    }

    public void setName(String name) {
        if(name.length() == 0) {
            name = "Anonimus";
        }
        this.name = name;
    }
}

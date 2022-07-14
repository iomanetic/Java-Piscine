package org.example;
import java.util.UUID;

public class TransactionsLinkedList implements TransactionsList {

    private LinkedList head;

    private LinkedList tail;

    private Integer countList;

    public TransactionsLinkedList() {
        countList = 0;
    }

    public void addTransaction(Transaction transaction) {
        LinkedList newElem = new LinkedList();

        newElem.data = transaction;
        if(head == null) {
            head = newElem;
            tail = newElem;
            newElem.next = null;
            newElem.prev = null;
        } else {
            tail.next = newElem;
            newElem.prev = tail;
            tail = newElem;
        }
        countList++;
    }

    public void deleteTransactionByIndeficator(UUID indeficator)  throws TransactionNotFoundException {
        LinkedList head;

        if(this.head == this.tail) {
            this.head = null;
            this.tail = null;
            this.countList--;
            return ;
        }
        if(this.head.data.getUuid().equals(indeficator)) {
            this.head = this.head.next;
            countList--;
            return ;
        }
        head = this.head;
        while(head != null) {
            if(head.next != null && head.next.data.getUuid().equals(indeficator)) {
                head.next = head.next.next;
                while(head.prev != null) {
                    head = head.prev;
                }
                this.head = head;
                countList--;
                return ;
            }
            head = head.next;
        }
        throw new TransactionNotFoundException("Transaction not found");
    }

    public Transaction[] convertListToArray(TransactionsList list) {
        Transaction[] arr = new Transaction[this.countList];
        LinkedList head = this.head;

        for(int index = 0; index < arr.length; index++) {
            arr[index] = head.data;
            head = head.next;
        }
        return (arr);
    }
}

class LinkedList {
    Transaction data;
    LinkedList prev;
    LinkedList next;
}

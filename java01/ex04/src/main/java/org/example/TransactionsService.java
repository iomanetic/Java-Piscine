package org.example;

import java.util.UUID;

public class TransactionsService implements UserList {

    private UsersArrayList userList;

    private Integer userCount;

    public TransactionsService() {
        this.userList = new UsersArrayList();
        this.userCount = 0;
    }

    public void addUser(User user) {
        this.userList.addUser(user);
        this.userCount++;
    }

    public Integer getUserBalance(Integer id) throws UserNotFoundException {
        return (this.userList.getUserWithId(id).getBalance());
    }

    public void makeTransaction(Integer idSender, Integer idRecipient, Integer amount)
                                throws IllegalTransactionException, UserNotFoundException {
        UUID uuid = UUID.randomUUID();
        User recipient = userList.getUserWithId(idRecipient);
        User sender = userList.getUserWithId(idSender);
        if(sender.getBalance() - amount < 0) {
            throw new IllegalTransactionException("There are not enough funds in your account");
        } else if(amount < 0) {
            throw new IllegalTransactionException("Amount < 0");
        }
        sender.addNewTran(new Transaction(recipient, sender, amount, "CREDIT", uuid));
        recipient.addNewTran(new Transaction(recipient, sender, amount, "DEBIT", uuid));
        sender.setBalance(sender.getBalance() - amount);
        recipient.setBalance(recipient.getBalance() + amount);
    }

    public Transaction[] getTransactionsArr(Integer indeficator) throws UserNotFoundException{
        TransactionsLinkedList list = getUserWithId(indeficator).getTransactionList();
        return (list.convertListToArray(list));
    }

    public User getUserWithId(Integer id) throws UserNotFoundException {
        for(Integer checkId = 0; checkId < userCount; checkId++) {
            if(id.equals(this.userList.getUserWithIndex(checkId).getId())) {
                return (this.userList.getUserWithIndex(checkId));
            }
        }
        throw new UserNotFoundException("User not found");
    }

    public Transaction[] getArrayUnpairTransactions() {
        TransactionsLinkedList TransList = new TransactionsLinkedList();

        for(Integer count = 0; count < userCount; count++) {
            User mainUser = userList.getUserWithIndex(count);
            TransactionsLinkedList list = mainUser.getTransactionList();
            Transaction[] arr = list.convertListToArray(list);
            for(Integer count2 = 0; count2 < arr.length; count2++) {
                TransactionsLinkedList list2;
                User recip = arr[count2].getRecipient();
                User send = arr[count2].getSender();
                list2 = recip.getTransactionList();
                Transaction[] tranRecip = list2.convertListToArray(list2);
                list2 = send.getTransactionList();
                Transaction[] tranSend = list2.convertListToArray(list2);
                Integer count3;
                for(count3 = 0; count3 < tranRecip.length; count3++) {
                    if(tranRecip[count3].getUuid().equals(arr[count2].getUuid())) {
                        break ;
                    }
                }
                if(count3 == tranRecip.length) {
                    TransList.addTransaction(arr[count2]);
                }
                for(count3 = 0; count3 < tranSend.length; count3++) {
                    if(tranSend[count3].getUuid().equals(arr[count2].getUuid())) {
                        break ;
                    }
                }
                if(count3 == tranSend.length) {
                    TransList.addTransaction(arr[count2]);
                }
            }
            count++;
        }
        return (TransList.convertListToArray(TransList));
    }

    public void deleteTransactionByUserIndeficator(Integer userId, UUID tranUuid) throws UserNotFoundException,
                                            TransactionNotFoundException {
       userList.getUserWithId(userId).getTransactionList().deleteTransactionByIndeficator(tranUuid);
    }

    public User getUserWithIndex(Integer index) {
        return (this.userList.getUserWithIndex(index));
    }

    public Integer getNumOfUsers() {
        return (this.userCount);
    }
}

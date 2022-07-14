package org.example;
import java.util.UUID;
public class Transaction {

    private final UUID uuid;

    private final User recipient;

    private final User sender;

    private final Integer amount;

    private final String tranType;

    public Transaction(User recipient, User sender, int amount, String type, UUID uuid) {
        this.uuid = uuid;
        this.amount = amount;
        this.recipient = recipient;
        this.sender = sender;
        this.tranType = type;
    }

    public UUID getUuid() {
        return (uuid);
    }

    public User getRecipient() {
        return (recipient);
    }

    public User getSender() {
        return (sender);
    }

    public Integer getAmount() {
        return (amount);
    }

    public String getType() {
        return (tranType);
    }
}

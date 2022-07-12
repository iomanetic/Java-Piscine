import java.util.UUID;

public class Transaction {

    private final UUID uuid;

    private final User recipient;

    private final User sender;

    private final Integer amount;

    private enum cardType {
        DEBIT,
        CREDIT
    }

    private final cardType type;

    public Transaction(User recipient, User sender, int amount) {
        this.uuid = UUID.randomUUID();
        this.amount = amount;
        if(amount < 0) {
            this.recipient = recipient;
            this.sender = sender;
            if(sender.getBalance() - amount * -1 >= 0) {
                sender.setBalance(sender.getBalance() - amount * -1);
                recipient.setBalance(recipient.getBalance() + amount * -1);
            }
            this.type = cardType.CREDIT;
        } else {
            this.recipient = sender;
            this.sender = recipient;
            if(recipient.getBalance() - amount >= 0) {
                recipient.setBalance(recipient.getBalance() - amount);
                sender.setBalance(sender.getBalance() + amount);
            }
            this.type = cardType.DEBIT;
        }
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
        return (type == cardType.DEBIT ? "DEBIT" : "CREDIT");
    }
}

import java.util.UUID;

public interface TransactionsList {

    public void addTransaction(Transaction transaction);

    public void deleteTransactionByIndeficator(UUID indeficator) throws TransactionNotFoundException;

    public Transaction[] convertListToArray(TransactionsList list);
}

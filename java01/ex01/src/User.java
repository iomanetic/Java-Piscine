
public class User {
    private final Integer id;

    private Integer countId;

    private String name;

    private Integer balance;

    public User(String name, int balance) {
        this.name = name;
        if(name.length() == 0)
            this.name = "Anonimus";
        this.balance = balance;
        if(this.balance < 0)
            this.balance = 0;
        this.id = UserIdsGenerator.getInstance().generateId();
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
        this.balance = balance;
    }
}

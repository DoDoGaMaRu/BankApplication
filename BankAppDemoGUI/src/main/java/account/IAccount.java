package account;

public interface IAccount {
    public int getAccountNumber();

    public int getBalance();

    public void deposit(int amount);

    public void withdraw(int amount) throws Exception;

    public void transfer(Account target, int amount) throws Exception;

    public boolean validatePIN(int pin);

    public String toString();
}

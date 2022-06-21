package account;

public class MinusAccount extends Account {

    private int creditLimit;

    public MinusAccount(int pin, int amount, int creditLimit) {
        super(pin, amount);
        this.creditLimit = creditLimit;
    }

    @Override
    public String toString() {
        return String.format(super.toString() + "\t마이너스 계좌 한도 : %d₩", creditLimit);
    }
}

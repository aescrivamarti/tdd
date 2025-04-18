package alexescriva.demo.tdd;

public class Account {

    private int balance;

    public int getBalance() {
        return balance;
    }

    public void deposit(int amount) {
        if (amount < 0 || amount > 3000) {
            balance = 0;
        } else {
            balance += amount;
        }
    }

    public void withdrawal(int amount) {
        if (amount <= balance && amount > 0 && amount <= 3000) {
            balance -= amount;
        }
    }

    public void transfer(int amount, Account destinationaccount) {
        if (amount < balance && amount > 0 && amount <= 1500) {
            balance -= amount;
            destinationaccount.deposit(amount);
        }
    }
}


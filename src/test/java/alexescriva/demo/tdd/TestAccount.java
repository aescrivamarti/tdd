package alexescriva.demo.tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestAccount {

    @Test
    void newAccountBalanceIs0() {
        Account account = new Account();

        assertEquals(0, account.getBalance());
    }

    @Test
    void depositSetsBalanceTo10WhenDepositing10InEmptyAccount() {
        Account account = new Account();
        account.deposit(10);

        assertEquals(10, account.getBalance());
    }

    @Test
    void depositSetsBalanceTo2000WhenDepositing2000InEmptyAccount() {
        Account account = new Account();
        account.deposit(2000);

        assertEquals(2000, account.getBalance());
    }

    @Test
    void depositSetsBalanceTo2600WhenDepositing2500InAccountWith100() {
        Account account = new Account();
        account.deposit(100);
        account.deposit(2500);

        assertEquals(2600, account.getBalance());
    }

    @Test
    void depositSetsBalanceTo0WhenDepositingNegative10InEmptyAccount() {
        Account account = new Account();
        account.deposit(-10);

        assertEquals(0, account.getBalance());
    }

    @Test
    void depositSetsBalanceTo3000WhenDepositing3000InEmptyAccount() {
        Account account = new Account();
        account.deposit(3000);

        assertEquals(3000, account.getBalance());
    }

    @Test
    void depositSetsBalanceTo0WhenDepositing3001InEmptyAccount() {
        Account account = new Account();
        account.deposit(3001);

        assertEquals(0, account.getBalance());
    }

    @Test
    void withrawalSetsBalanceTo490WhenWithrawing10InAccountWith500(){
        Account account = new Account();
        account.deposit(500);
        account.withrawal(10);

        assertEquals(490, account.getBalance());
    }

    @Test
    void withrawalSetsBalanceTo100WhenWithrawing300InAccountWith100(){
        Account account = new Account();
        account.deposit(100);
        account.withrawal(300);

        assertEquals(100, account.getBalance());
    }

    @Test
    void withrawalSetsBalanceTo300WhenWithrawingNegative10InAccountWith300(){
        Account account = new Account();
        account.deposit(300);
        account.withrawal(-10);

        assertEquals(300, account.getBalance());
    }

    @Test
    void withrawalSetsBalanceTo1000WhenWithrawing3000InAccountWith4000(){
        Account account = new Account();
        account.deposit(2000);
        account.deposit(2000);
        account.withrawal(3000);

        assertEquals(1000, account.getBalance());
    }

    @Test
    void withrawalSetsBalanceTo4000WhenWithrawing3001InAccountWith4000(){
        Account account = new Account();
        account.deposit(2000);
        account.deposit(2000);
        account.withrawal(3001);

        assertEquals(4000, account.getBalance());
    }

}


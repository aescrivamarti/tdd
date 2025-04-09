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
    void withdrawalSetsBalanceTo490WhenWithdrawing10InAccountWith500(){
        Account account = new Account();
        account.deposit(500);
        account.withdrawal(10);

        assertEquals(490, account.getBalance());
    }

    @Test
    void withdrawalSetsBalanceTo100WhenWithdrawing300InAccountWith100(){
        Account account = new Account();
        account.deposit(100);
        account.withdrawal(300);

        assertEquals(100, account.getBalance());
    }

    @Test
    void withdrawalSetsBalanceTo300WhenWithdrawingNegative10InAccountWith300(){
        Account account = new Account();
        account.deposit(300);
        account.withdrawal(-10);

        assertEquals(300, account.getBalance());
    }

    @Test
    void withdrawalSetsBalanceTo1000WhenWithdrawing3000InAccountWith4000(){
        Account account = new Account();
        account.deposit(2000);
        account.deposit(2000);
        account.withdrawal(3000);

        assertEquals(1000, account.getBalance());
    }

    @Test
    void withdrawalSetsBalanceTo4000WhenWithdrawing3001InAccountWith4000(){
        Account account = new Account();
        account.deposit(2000);
        account.deposit(2000);
        account.withdrawal(3001);

        assertEquals(4000, account.getBalance());
    }

    @Test
    void transferSetsSourceAccountBalanceTo290AndDestinationAccount410() {
        Account sourceaccount = new Account();
        sourceaccount.deposit(300);
        Account destinationaccount = new Account();
        destinationaccount.deposit(400);

        sourceaccount.transfer(10, destinationaccount);

        assertEquals(290, sourceaccount.getBalance());
        assertEquals(410, destinationaccount.getBalance());
    }

    @Test
    void transferSetsSourceAccountBalanceTo200AndDestinationAccount400() {
        Account sourceaccount = new Account();
        sourceaccount.deposit(300);
        Account destinationaccount = new Account();
        destinationaccount.deposit(400);

        sourceaccount.transfer(100, destinationaccount);

        assertEquals(200, sourceaccount.getBalance());
        assertEquals(500, destinationaccount.getBalance());
    }

    @Test
    void transferSetsSourceAccountBalanceTo300AndDestinationAccount40() {
        Account sourceaccount = new Account();
        sourceaccount.deposit(300);
        Account destinationaccount = new Account();
        destinationaccount.deposit(40);

        sourceaccount.transfer(-10, destinationaccount);

        assertEquals(300, sourceaccount.getBalance());
        assertEquals(40, destinationaccount.getBalance());
    }

    @Test
    void transferSetsSourceAccountBalanceTo1000AndDestinationAccount2000() {
        Account sourceaccount = new Account();
        sourceaccount.deposit(2500);
        Account destinationaccount = new Account();
        destinationaccount.deposit(500);

        sourceaccount.transfer(1500, destinationaccount);

        assertEquals(1000, sourceaccount.getBalance());
        assertEquals(2000, destinationaccount.getBalance());
    }

    @Test
    void transferSetsSourceAccountBalanceTo2500AndDestinationAccount500() {
        Account sourceaccount = new Account();
        sourceaccount.deposit(2500);
        Account destinationaccount = new Account();
        destinationaccount.deposit(500);

        sourceaccount.transfer(1501, destinationaccount);

        assertEquals(2500, sourceaccount.getBalance());
        assertEquals(500, destinationaccount.getBalance());
    }

    @Test
    void transferSetsSourceAccountBalanceTo300AndDestinationAccount2700() {
        Account sourceaccount = new Account();
        sourceaccount.deposit(2500);
        Account destinationaccount = new Account();
        destinationaccount.deposit(500);

        sourceaccount.transfer(1000, destinationaccount);
        sourceaccount.transfer(1200, destinationaccount);

        assertEquals(300, sourceaccount.getBalance());
        assertEquals(2700, destinationaccount.getBalance());
    }

    @Test
    void withdrawalSetsBalanceTo0WhenWithdrawing1000InAccountWith1000(){
        Account account = new Account();
        account.deposit(1000);
        account.withdrawal(1000);

        assertEquals(0, account.getBalance());
    }
}


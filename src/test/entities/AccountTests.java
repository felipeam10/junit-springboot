package test.entities;

import entities.Account;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tests.factory.AccountFactory;

public class AccountTests {

    @Test
    public void depositShouldIncreaseBalanceWhenPositiveAmount() {
        /* o depósito deve aumentar o saldo quando o valor for positivo */
        double amount = 200.0;
        double expectedValue = 196.0;
        Account acc = AccountFactory.createEmptyAccount();

        acc.deposit(amount);

        Assertions.assertEquals(expectedValue, acc.getBalance());

    }

    @Test
    public void depositShouldDoNothingNegativeAmount() {
        /* o depósito não deve fazer nada com valor negativo */
        double expectedValue = 100.0;
        Account acc = AccountFactory.createAccount(expectedValue);
        double amount = -200.0;

        acc.deposit(amount);

        Assertions.assertEquals(expectedValue, acc.getBalance());

    }

    @Test
    public void fullWithdrawShouldClearBalanceAndReturnFullBalance() {
        /* A retirada total deve compensar o saldo e devolver o saldo total */
        double expectedValue = 0.0;
        double initialBalance = 800.0;
        Account acc = AccountFactory.createAccount(initialBalance);

        double result = acc.fullWithdraw();

        Assertions.assertTrue(expectedValue == acc.getBalance());
        Assertions.assertTrue(result == initialBalance);
    }

    @Test
    public void withdrawShouldDecreaseBalanceWhenSufficientBalance() {
        /* sacar deve diminuir o saldo quando houver saldo suficiente */
        double expectedValue = 300.0;
        double initialBalance = 800.0;
        Account acc = AccountFactory.createAccount(initialBalance);

        acc.withdraw(500.0);
        Assertions.assertEquals(expectedValue, acc.getBalance());
    }

    @Test
        public void withdrawShouldThrowExceptionWhenInsufficientBalance() {
        /* sacar deve lançar exceção quando saldo insuficiente */
        double initialBalance = 800.0;
        Account acc = AccountFactory.createAccount(initialBalance);
        double withdrawAmount = 801.0;

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            acc.withdraw(withdrawAmount);
        });
    }

}

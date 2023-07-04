package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SavingAccountTest {

    @Test
    public void shouldAddLessThanMaxBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(3_000);

        Assertions.assertEquals(2_000 + 3_000, account.getBalance());
    }
    @Test
    public void shouldDeductLessThanInitialBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(-1_000);

        Assertions.assertEquals(2_000 - 1_000, account.getBalance());
    }
    @Test
    public void shouldDeductInitialBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                0,
                10_000,
                5
        );

        account.add(-2_000);

        Assertions.assertEquals(2_000 - 2_000, account.getBalance());
    }

        SavingAccount account = new SavingAccount(
            2_000,
            1_000,
            50_000,
            3);

    // Выводим начальный баланс.
    @Test
    public void shouldGetInitialBalance() {
        int expected = 2_000;
        int actual = account.getBalance();

        Assertions.assertEquals(expected, actual);
    }

    //Выводим минимальный баланс.
    @Test
    public void shouldGetMinBalance() {
        int expected = 1_000;
        int actual = account.getMinBalance();

        Assertions.assertEquals(expected, actual);
    }

    // Выводим максимальный баланс.
    @Test
    public void shouldGetMaxBalance() {
        int expected = 50_000;
        int actual = account.getMaxBalance();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldAnExceptionMustBeThrownWhenMinGreaterMax() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(
                    1_000,
                    55_000,
                    20_000,
                    3);
        });
    }
    @Test
    public void shouldAnExceptionMustBeThrownWhenInitialLessMin() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(
                    1_000,
                    3_000,
                    50_000,
                    3);
        });
    }

    @Test
    public void shouldAnExceptionMustBeThrownWhenInitialGreaterMax() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(
                    50_000,
                    15_000,
                    45_000,
                    3);
        });
    }
}


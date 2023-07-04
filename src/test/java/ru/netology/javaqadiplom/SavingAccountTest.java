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


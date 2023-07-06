package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreditAccountTest {

    @Test
    public void shouldAddToPositiveBalance() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.add(3_000);

        Assertions.assertEquals(3_000, account.getBalance());
    }

    @Test
    public void IllegalArgumentExceptionTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount account = new CreditAccount(
                    -2_000,
                    -5_000,
                    -15
            );
        });

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount account = new CreditAccount(
                    -2_000,
                    5_000,
                    15
            );
        });

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount account = new CreditAccount(
                    2_000,
                    -5_000,
                    15
            );
        });

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount account = new CreditAccount(
                    3_000,
                    5_000,
                    -15
            );
        });

    }

    @Test
    void payTest() {
        CreditAccount account = new CreditAccount(
                3_000,
                5_000,
                15
        );

        account.pay(50);
        int expected = 2950;

        Assertions.assertEquals(expected, account.getBalance());
    }


    @Test
    void add() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        Assertions.assertTrue(account.add(50));
        Assertions.assertFalse(account.add(-50));
        account.add(50);
        int expexted = 100;

        Assertions.assertEquals(expexted, account.getBalance());
    }

    @Test
    void yearChange() {
        CreditAccount account = new CreditAccount(
                200,
                5_000,
                15
        );
        int expected = 0;

        Assertions.assertEquals(expected, account.yearChange());
        account.pay(200);
        expected = 0;
        Assertions.assertEquals(expected, account.yearChange());
    }

}

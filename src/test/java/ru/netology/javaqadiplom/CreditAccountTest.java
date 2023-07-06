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
        //проверка на добавление
        account.add(3_000);

        Assertions.assertEquals(3_000, account.getBalance());
    }

    @Test
    public void IllegalArgumentExceptionTest() {
        //проверка на выброс исключения при вводе отрицательных значенний у объекта
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount account = new CreditAccount(
                    -2_000,
                    -5_000,
                    -15
            );
        });
    }

    @Test
    void payTest() {
        CreditAccount account = new CreditAccount(
                3_050,
                5_000,
                15
        );

        //проверка на снятие обычной суммы в размере 50 с карты на которой находится сумма в 3050
        account.pay(50);
        int expected = 3_000;
        Assertions.assertEquals(expected, account.getBalance());
        //проверка на снятие отрицательной суммы в размере 50
        Assertions.assertFalse(account.pay(-50));
        //проверка на снятие суммы превышающей максимально допустимую сумму,которую можно задолжать
        Assertions.assertFalse(account.pay(10_000));
    }


    @Test
    void add() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        //роверка возврата True при добавлении на счёт стандартной суммы
        Assertions.assertTrue(account.add(50));
        //проверка возврата False при добавлении на счёт отрицательной суммы
        Assertions.assertFalse(account.add(-50));
        //проверка возврата False при добавлении на счёт нулевой суммы
        Assertions.assertFalse(account.add(0));
        //проверка соответствия баланса на счету ожидаемой сумме
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
        //проверка расчета процентов, если на счету положительное значение
        int expected = 0;
        Assertions.assertEquals(expected, account.yearChange());
        //проверка расчета процентов, если на счету нулевое значение
        account.pay(200);
        expected = 0;
        Assertions.assertEquals(expected, account.yearChange());
        //проверка расчета процентов, если на счету отрицательное значение
        expected = -30;
        account.pay(200);
        Assertions.assertEquals(expected, account.yearChange());
    }

}

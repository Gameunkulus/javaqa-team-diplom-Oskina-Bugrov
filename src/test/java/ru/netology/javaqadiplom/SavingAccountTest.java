package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SavingAccountTest {


    //Операции по счету:

    //Пополнение счета
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

    //Пополнение на 0 руб, сумма баланса остается не измененной:
    @Test
    public void shouldReturnNewBalanceForNullAmountAdd() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(0);

        int expected = 2_000;
        int actual = account.getBalance();

        Assertions.assertEquals(expected, actual);
    }

    //Попытка пополнить баланс на отрицательное число:
    @Test
    public void shouldTryTopUpNegativeAmountAdd() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(-1_000);

        int expected = 2_000;
        int actual = account.getBalance();

        Assertions.assertEquals(expected, actual);
    }

    //Пополнение на сумму больше максимального баланса
    @Test
    public void shouldTopUpAmountWhenNewBalanceGreaterMax() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(55_000);

        int expected = 2_000;
        int actual = account.getBalance();

        Assertions.assertEquals(expected, actual);
    }


    //Покупка на сумму в пределах текущего баланса на положительную сумму покупки
    @Test
    public void shouldDeductLessThanInitialBalance() {
        SavingAccount account = new SavingAccount(
                5_000,
                0,
                100_000,
                5);

        account.pay(1_000);

        int expected = 4_000;
        int actual = account.getBalance();

        Assertions.assertEquals(expected, actual);
    }

    //При покупке на положительное число равному текущему балансу
    @Test
    public void shouldDeductInitialBalance() {
        SavingAccount account = new SavingAccount(
                5_000,
                0,
                100_000,
                5);

        account.pay(5_000);

        int expected = 0;
        int actual = account.getBalance();

        Assertions.assertEquals(expected, actual);
    }

    //При покупке на 0 руб, баланс не должен изменится
    @Test
    public void shouldReturnNewBalanceForNullAmountPay() {
        SavingAccount account = new SavingAccount(
                5_000,
                0,
                100_000,
                5);

        account.pay(0);

        int expected = 5_000;
        int actual = account.getBalance();

        Assertions.assertEquals(expected, actual);
    }

    // При покупке на отрицательное число рублей операция не пройдет и баланс не изменится:
    @Test
    public void shouldReturnNewBalanceForNegativeAmountPay() {
        SavingAccount account = new SavingAccount(
                5_000,
                0,
                100_000,
                5);

        account.pay(-5_000);

        int expected = 5_000;
        int actual = account.getBalance();

        Assertions.assertEquals(expected, actual);
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
    //Должно выкидываться исключение в случае, если минимальный баланс больше максимального

    @Test
    public void shouldAnExceptionMustBeThrownWhenMinGreaterMax() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(
                    1_000,
                    55_000,
                    20_000,
                    5);
        });
    }

    //Должно выкидываться исключение в случае, если начальный баланс меньше минимального
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

    //Должно выкидываться исключение в случае, если начальный баланс больше максимального
    @Test
    public void shouldAnExceptionMustBeThrownWhenInitialGreaterMax() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(
                    25_000,
                    5_000,
                    15_000,
                    3);
        });
    }

    //Должно выкидываться исключение в случае, если указан отрицательный процент
    @Test
    public void shouldAnExceptionMustBeThrownWhenNegativePercent() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(
                    25_000,
                    1_000,
                    50_000,
                    -3);
        });
    }

    //Расчет % на остаток
    @Test
    public void shouldCalculateYearChange() {
        SavingAccount account = new SavingAccount(
                25_000,
                1_000,
                50_000,
                5);

        int expected = 1_250;
        int actual = account.yearChange();

        Assertions.assertEquals(expected, actual);
    }

}


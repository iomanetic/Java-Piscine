package edu.school21.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

public class NumberWorkerTest {

    NumberWorker numberWorker;

    @BeforeEach
    void getNewObject() {
        numberWorker = new NumberWorker();
    }

    @ParameterizedTest
    @ValueSource(ints = {127, 131 ,137, 139, 149, 151, 157, 163, 167, 173})
    void isPrimeForPrimes(int num) {
        Assertions.assertTrue(numberWorker.isPrime(num));
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 6, 8, 9, 10, 12, 14, 15, 16, 18})
    void isPrimeForNotPrimes(int num) {
        Assertions.assertFalse(numberWorker.isPrime(num));
    }

    @ParameterizedTest
    @ValueSource(ints = {-4, -6, 0, 1, -10, -12, -14, -15, -16, -18})
    void isPrimeForIncorrectNumbers(int num) {
        Assertions.assertThrows(IllegalArgumentsException.class, () -> numberWorker.isPrime(num));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/data.csv", delimiter = ',')
    void sumOfNumber(int x, int y) {
        Assertions.assertEquals(numberWorker.digitSum(x), y);
    }
}

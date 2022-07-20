package edu.school21.numbers;

public class NumberWorker {

    public boolean isPrime(int number) {
        int numDel = 2;

        if (number < 2) {
            throw new IllegalArgumentsException("number < 2");
        }
        while (numDel * numDel <= number) {
            if (number % numDel == 0) {
                return (false);
            }
            numDel++;
        }
        return (true);
    }

    public int digitSum(int number) {
        int sum = 0;

        while(number != 0) {
            sum += number % 10;
            number /= 10;
        }
        return (sum);
    }
}

class IllegalArgumentsException extends RuntimeException {
    public IllegalArgumentsException(String message) {
        super(message);
    }
}
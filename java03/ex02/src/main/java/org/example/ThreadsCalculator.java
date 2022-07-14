package org.example;

public class ThreadsCalculator extends Thread {

    private int sumOfThread;

    private int startIndex;

    private int endIndex;

    public ThreadsCalculator(int startIndex, int endIndex) {
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    public synchronized static void SumOfNumbers() {

    }

}

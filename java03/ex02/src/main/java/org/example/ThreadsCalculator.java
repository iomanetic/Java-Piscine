package org.example;

import java.util.ArrayList;
import java.util.List;

public class ThreadsCalculator extends Thread {

    private int endIndex;

    private int sumOfNumber;

    private final int numOfThreads;

    private final List<Integer> arrayList;

    private final int threadNumber;

    private final int startIndex;

    public ThreadsCalculator(int startIndex, int endIndex, int threadNumber, List<Integer> arrayList, int numOfThreads) {
        this.startIndex = startIndex;
        if(endIndex > arrayList.size()) {
            this.endIndex = arrayList.size();
        } else {
            this.endIndex = endIndex;
        }
        this.arrayList = arrayList;
        this.sumOfNumber = 0;
        this.threadNumber = threadNumber + 1;
        this.numOfThreads = numOfThreads;
    }

    @Override
    public void run() {
        for(int count = startIndex; count < endIndex; count++) {
            sumOfNumber += arrayList.get(count);
        }
        if(this.numOfThreads == threadNumber) {
            this.endIndex++;
        }
        printMessage();
    }

    public synchronized void printMessage() {
        System.out.println("Thread " + this.threadNumber + ": "
                            + "from " + this.startIndex + " to " + (this.endIndex - 1)
                            + " sum is " + sumOfNumber);
    }

    public int getSumOfNumber() {
        return (this.sumOfNumber);
    }

}

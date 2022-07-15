package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Program {
    public static void main(String[] args) throws InterruptedException {
        List<Integer> arrayNumbs;
        ThreadsCalculator[] threads;

        Random randomNum = new Random();
        int num;
        int lenOfArray;
        int numOfThreads;
        int sum;

        if(args.length != 2 || !(args[0].startsWith("--arraySize=")
                                && args[1].startsWith("--threadsCount"))) {
            System.err.println("Invalid arguments");
            System.exit(-1);
        }

        lenOfArray = Integer.parseInt(args[0].substring(12));
        numOfThreads = Integer.parseInt(args[1].substring(15));
        if((numOfThreads <= 0 || lenOfArray <= 0) || lenOfArray < numOfThreads) {
            System.err.println("Invalid arguments");
            System.exit(-1);
        }
        arrayNumbs = new ArrayList<>(lenOfArray);
        threads = new ThreadsCalculator[numOfThreads];

        sum = 0;
        for(int count = 0; count < lenOfArray - 1; count++) {
            num = randomNum.nextInt() % 1000;
            if(num < 0)
                num *= -1;
            arrayNumbs.add(num);
            sum += num;
        }
        System.out.println("Sum: " + sum);

        int mod = lenOfArray % numOfThreads;
        int to = 0;
        int range;
        int from;
        for(int count = 0; count < numOfThreads; count++) {
            from = to;
            if(mod != 0) {
                range = (lenOfArray - (numOfThreads - 1)) / (numOfThreads - 1);
                if(range == 0) {
                    range = 1;
                }
                to = (count + 1) * range;
                if(count + 1 == numOfThreads) {
                    to = (count + 1) * (lenOfArray / numOfThreads + 1);
                }
            } else {
                to = (count + 1) * (lenOfArray / numOfThreads);
            }
            threads[count] = new ThreadsCalculator(from, to, count, arrayNumbs, numOfThreads);
            threads[count].start();
        }

        for(int count = 0; count < numOfThreads; count++) {
            threads[count].join();
        }

        sum = 0;
        for(int count = 0; count < numOfThreads; count++) {
            sum += threads[count].getSumOfNumber();
        }
        System.out.println("Sum by threads: " + sum);
    }
}
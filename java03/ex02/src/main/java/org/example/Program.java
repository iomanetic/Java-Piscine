package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Program {
    public static void main(String[] args) {
        List<Integer> arrayNumbs;
        Random randomNum = new Random();
        int num;
        int lenOfArray;
        int numOfThreads;

        if(args.length != 2 || !(args[0].startsWith("--arraySize=")
                                && args[1].startsWith("--threadsCount"))) {
            System.err.println("Invalid arguments");
            System.exit(-1);
        }

        lenOfArray = Integer.parseInt(args[0].substring(12));
        numOfThreads = Integer.parseInt(args[1].substring(15));
        System.out.println(lenOfArray);
        System.out.println(numOfThreads);
        arrayNumbs = new ArrayList<>(lenOfArray);

        for(int count = 0; count < lenOfArray; count++) {
            num = randomNum.nextInt() % 1000;
            if(num < 0)
                num *= -1;
            arrayNumbs.add(num);
        }
        System.out.println(arrayNumbs);
    }
}
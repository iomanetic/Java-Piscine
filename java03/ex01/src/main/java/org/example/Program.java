package org.example;

public class Program {
    public static void main(String[] args) {
        int numOfPrint;
        MyThread eggThread;
        MyThread henThread;

        if(args.length != 1 || !args[0].startsWith("--count=")) {
            System.err.println("Invalid argument");
            System.exit(-1);
            return ;
        }
        numOfPrint = Integer.parseInt(args[0].substring(8));
        if(numOfPrint < 0) {
            System.err.println("Argument can't be negative");
            System.exit(-1);
        }

        eggThread = new MyThread(numOfPrint, "Egg");
        henThread = new MyThread(numOfPrint, "Hen");

        eggThread.start();
        henThread.start();

        try {
            henThread.join();
            eggThread.join();
        } catch (InterruptedException exc) {
            exc.printStackTrace();
        }

        printHuman(numOfPrint);
    }

    private static void printHuman(int numOfPrint) {
        for(int lNumOfPrint = 0; lNumOfPrint < numOfPrint; lNumOfPrint++) {
            System.out.println("Human");
        }
    }
}
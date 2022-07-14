package org.example;

public class MyThread extends Thread {

    private final int numOfPrint;
    private final String message;

    public MyThread(int numOfPrint, String message) {
        this.numOfPrint = numOfPrint;
        this.message = message;
    }

    @Override
    public void run() {
        for(int numOfPrint = 0; numOfPrint < this.numOfPrint; numOfPrint++) {
            System.out.println(message);
        }
    }
}

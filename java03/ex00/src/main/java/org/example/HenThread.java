package org.example;

public class HenThread extends Thread {

    private final int numOfPrint;

    public HenThread(int numOfPrint) {
        this.numOfPrint = numOfPrint;
    }

    @Override
    public void run() {
        for(int numOfPrint = 0; numOfPrint < this.numOfPrint; numOfPrint++) {
            System.out.println("Hen");
        }
    }
}

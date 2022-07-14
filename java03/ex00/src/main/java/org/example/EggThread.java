package org.example;

public class EggThread extends Thread {

    private final int numOfPrint;

    public EggThread(int numOfPrint) {
        this.numOfPrint = numOfPrint;
    }

    @Override
    public void run() {
        for(int numOfPrint = 0; numOfPrint < this.numOfPrint; numOfPrint++) {
            System.out.println("Egg");
        }
    }
}

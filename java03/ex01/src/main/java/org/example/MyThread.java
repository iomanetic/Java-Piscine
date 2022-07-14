package org.example;

public class MyThread extends Thread {

    private final int numOfPrint;
    
    private final String message;

    private final static Object mutex = new Object();

    public MyThread(int numOfPrint, String message) {
        this.numOfPrint = numOfPrint;
        this.message = message;
    }

    @Override
    public void run() {
        synchronized (mutex) {
            for(int count = 0; count < numOfPrint; count++) {
                System.out.println(message);
                mutex.notify();
                try {
                    mutex.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            mutex.notify();
        }
    }
}

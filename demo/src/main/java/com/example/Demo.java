package com.example;


public class Demo implements Runnable {
    public void run() {
        System.out.println("Hello from Demo");
    }
    public void start() {
        Thread t = new Thread(this);
        t.start();
    }


    
}
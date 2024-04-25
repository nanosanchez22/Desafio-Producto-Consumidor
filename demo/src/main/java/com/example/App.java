package com.example;

import java.util.Queue;
import java.util.concurrent.Semaphore;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        int max = 30;
        Queue<int[]> buffer = new Queue<>();
        Semaphore mutuaExclusion = new Semaphore(1);
        Semaphore estaLleno = new Semaphore(max);
        Semaphore estaVacio = new Semaphore(0);

        Productor prod1 = new Productor();
        Productor prod2 = new Productor();
        Productor prod3 = new Productor();
        Productor prod4 = new Productor();

        Consumidor cons1 = new Consumidor();
        Consumidor cons2 = new Consumidor();
        Consumidor cons3 = new Consumidor();
        Consumidor cons4 = new Consumidor();
        Thread p1 = new Thread(prod1, "Productor 1");
        Thread p2 = new Thread(prod2, "Productor 1");
        Thread p3 = new Thread(prod3, "Productor 1");
        Thread p4 = new Thread(prod4, "Productor 1");
        Thread c1 = new Thread(cons1, "Productor 1");
        Thread c2 = new Thread(cons2, "Productor 1");
        Thread c3 = new Thread(cons3, "Productor 1");
        Thread c4 = new Thread(cons4, "Productor 1");

    }
}


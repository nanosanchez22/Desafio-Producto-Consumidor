package com.example;

import java.util.Queue;
import java.util.concurrent.Semaphore;


public class App 
{
    static int max = 5;
    static CircularQueue<Integer> buffer = new CircularQueue<Integer>(max);
    static Semaphore mutuaExclusion = new Semaphore(1);
    static Semaphore estaLleno = new Semaphore(5);
    static Semaphore estaVacio = new Semaphore(0);

    public static void main( String[] args )
    {
        Productor prod1 = new Productor(buffer, mutuaExclusion, estaLleno, estaVacio);
        Productor prod2 = new Productor(buffer, mutuaExclusion, estaLleno, estaVacio);
        Productor prod3 = new Productor(buffer, mutuaExclusion, estaLleno, estaVacio);
        Productor prod4 = new Productor(buffer, mutuaExclusion, estaLleno, estaVacio);

        Consumidor cons1 = new Consumidor(buffer, mutuaExclusion, estaLleno, estaVacio);
        Consumidor cons2 = new Consumidor(buffer, mutuaExclusion, estaLleno, estaVacio);
        Consumidor cons3 = new Consumidor(buffer, mutuaExclusion, estaLleno, estaVacio);
        Consumidor cons4 = new Consumidor(buffer, mutuaExclusion, estaLleno, estaVacio);

    }
}


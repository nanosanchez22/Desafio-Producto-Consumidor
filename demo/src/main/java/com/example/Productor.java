package com.example;
import java.util.Random;

public class Productor implements Runnable{
    //numero random
    private int numero;


    @Override
    public void run(){
        //generar numero random
        numero = (int) (Math.random() * 10) + 1;
        System.out.println("Numero generado: " + numero);

    }
    
}
package com.example;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.Arrays;

public class Productor implements Runnable{

    CircularQueue<Integer> buffer;
    Semaphore mutuaExclusion;
    Semaphore estaLleno;
    Semaphore estaVacio;

    //numero random
    private int numero;
    //constructor
    public Productor(CircularQueue<Integer> buffer, Semaphore ME, Semaphore EL, Semaphore EV){
        this.buffer = buffer; 
        this.mutuaExclusion = ME;
        this.estaLleno = EL;
        this.estaVacio = EV;
        new Thread(this).start();

    }

    @Override
    public void run(){
        while(true){
            try{
                //producir
                numero = Producir();
                
                
                //esperar a que haya espacio en el buffer
                estaLleno.acquire();
                System.out.println("El buffer tiene: " + estaLleno.availablePermits() + " espacios disponibles.");
                //esperar a que no haya mas de un hilo accediendo al buffer
                mutuaExclusion.acquire();
                //agregar al buffer
                System.out.println("Agregó " + numero + " al buffer");
                buffer.enqueue(numero);
                //liberar el acceso al buffer
                mutuaExclusion.release();
                //avisar que hay un elemento en el buffer
                estaVacio.release();
                //dormir
                Thread.sleep(500);

            }catch(InterruptedException e){
                System.out.println("Hubo un error");
            }
        }    
    }

    public void imprimirBuffer()
    {
        System.out.println("Productor Buffer: ");
        for(int i=0; i < buffer.getSize(); i++){
            System.out.println(buffer.getElement(i));
        }
    }

    public int Producir()
    {
        numero = (int) (Math.random() * 10) + 1;
        
        return numero;
    }
    
}
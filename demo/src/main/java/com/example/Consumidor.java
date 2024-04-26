package com.example;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class Consumidor implements Runnable
{
        CircularQueue<Integer> buffer;
        Semaphore mutuaExclusion;
        Semaphore estaLleno;
        Semaphore estaVacio;
        Integer dato;

        public Consumidor(CircularQueue<Integer> buffer, Semaphore ME, Semaphore lleno, Semaphore vacio){
        this.buffer = buffer; 
        this.mutuaExclusion = ME;
        this.estaLleno = lleno;
        this.estaVacio = vacio;
        new Thread(this).start();
        }

        @Override
        public void run()
        {
            while(true)
            {
                try
                {
                    estaVacio.acquire();
                    mutuaExclusion.acquire();
                    dato = buffer.dequeue();
                    Consumir();
                    mutuaExclusion.release();
                    estaLleno.release();
                    System.out.println("El buffer tiene: " + estaLleno.availablePermits() + " espacios disponibles.");
                    //imprimirBuffer();
                    Thread.sleep(1000);
                    
                }
                catch (InterruptedException e)
                {
                    System.out.println("Hubo un error");
                }
            }

        }   

        public void imprimirBuffer()
        {        
            System.out.println("Consumidor Buffer: ");
            for(int i=0; i < buffer.getSize() - 1; i++){
                System.out.println(buffer.getElement(i));
            } 
        }

                public void Consumir()
        {   
            System.out.println("Consume el buffer");
        }

}

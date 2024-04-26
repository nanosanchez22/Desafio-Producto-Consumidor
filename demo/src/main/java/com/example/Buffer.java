package com.example;
import java.util.concurrent.Semaphore;

class Buffer {
    private int[] buffer;
    private int size, in, out, producidos, consumidos;
    private Semaphore mutex;
    private Semaphore empty;
    private Semaphore full;

    public Buffer(int size) {
        this.size = size;
        buffer = new int[size];
        for(int i = 0; i < size; i++)
        {
            buffer[i] = 0;
        }
        in = 0;
        out = 0;
        mutex = new Semaphore(1);
        empty = new Semaphore(size);
        full = new Semaphore(0);
        System.out.println("El buffer inicial es: ");
        print();
    }

    public void produce(int item, String producerName) throws InterruptedException {
        try
        {
            empty.acquire();
            mutex.acquire();
            System.out.println("El productor " + producerName + " produce: " + item);
            if(buffer[in] == 0)
            {
                buffer[in] = item;
            }
            else
            {
                System.out.println("Error al producir, la cola esta llena.");
                buffer[in] = item;
            }
            producidos++;
            in = (in + 1) % size;
            print();
            mutex.release();
            full.release();    
        }
        catch(InterruptedException e)
        {
            return;
        }
    }

    public int consume(String consumerName){
        try
        {
            full.acquire();
            mutex.acquire();
            int item = buffer[out];
            buffer[out] = 0;
            consumidos++;
            out = (out + 1) % size;
            System.out.println("El consumidor " + consumerName + " consume: " + item);
            print();
            mutex.release();
            empty.release();
            return item;
        }
        catch(InterruptedException e)
        {
            return 0;
        }
        
    }

    public void print()
    {
        for(int i = 0; i < size - 1; i++)
        {
            System.out.print("[" + buffer[i] + "] ");    
        }
        System.out.println("[" + buffer[size - 1] + "] \n"); 
    }

    public int porcentajeProd()
    {
        int result = 50;
        int total = producidos + consumidos;
        if (total != 0)
        {
            result = (producidos*100)/total;
        }
        return result;
    }

    public int porcentajeCons()
    {
        return 100 - porcentajeProd();
    }
}
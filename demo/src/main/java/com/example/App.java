package com.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) throws InterruptedException {
        Buffer buffer = new Buffer(100); // Tamaño del buffer

        Producer producer1 = new Producer(buffer, "P1", 2000);
        Producer producer2 = new Producer(buffer, "P2", 4000);
        Producer producer3 = new Producer(buffer, "P3", 3000);
        Producer producer4 = new Producer(buffer, "P4", 5500);
        Producer producer5 = new Producer(buffer, "P5", 5000);
        Producer producer6 = new Producer(buffer, "P6", 6000);
        Producer producer7 = new Producer(buffer, "P7", 4500);
        Producer producer8 = new Producer(buffer, "P8", 5000);

        Consumer consumer1 = new Consumer(buffer, "C1", 8000);
        Consumer consumer2 = new Consumer(buffer, "C2", 9000);
        Consumer consumer3 = new Consumer(buffer, "C3", 8500);
        Consumer consumer4 = new Consumer(buffer, "C4", 6340);
        Consumer consumer5 = new Consumer(buffer, "C5", 7500);
        Consumer consumer6 = new Consumer(buffer, "C6", 8300);
        Consumer consumer7 = new Consumer(buffer, "C7", 12000);
        Consumer consumer8 = new Consumer(buffer, "C8", 9000);
        

        producer1.start();
        producer2.start();
        producer3.start();
        producer4.start();
        producer5.start();
        producer6.start();
        producer7.start();
        producer8.start();
        consumer1.start();
        consumer2.start();
        consumer3.start();
        consumer4.start();
        consumer5.start();
        consumer6.start();
        consumer7.start();
        consumer8.start();
        
        Thread.sleep(20000);

        producer1.interrupt();
        producer2.interrupt();
        producer3.interrupt();
        producer4.interrupt();
        producer5.interrupt();
        producer6.interrupt();
        producer7.interrupt();
        producer8.interrupt();
        consumer1.interrupt();
        consumer2.interrupt();
        consumer3.interrupt();
        consumer4.interrupt();
        consumer5.interrupt();
        consumer6.interrupt();
        consumer7.interrupt();
        consumer8.interrupt();
        
        System.out.println(
            "Fin de la operación, resultados: " + 
            buffer.porcentajeProd() + "% producción y " + 
            buffer.porcentajeCons() + "% consumo."
        );
    }
}

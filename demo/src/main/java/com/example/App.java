package com.example;

public class App 
{
    public static void main(String[] args) throws InterruptedException {
        Buffer buffer = new Buffer(30); // Tamaño del buffer
        Buffer buffer2 = new Buffer(30); // Tamaño del buffer

        Proceso1 proceso1 = new Proceso1(buffer, "P1", 500);
        Proceso2 proceso2 = new Proceso2(buffer, "P2", 2000);
        Proceso3 proceso3 = new Proceso3(buffer, buffer2, "P3", 3000);
        Proceso4 proceso4 = new Proceso4(buffer2, "P4", 4000);

        proceso1.start();
        proceso2.start();
        proceso3.start();
        proceso4.start();

        Thread.sleep(20000);

        proceso1.interrupt();
        proceso2.interrupt();
        proceso3.interrupt();
        proceso4.interrupt();

       
        
        System.out.println(
            "Fin de la operación, resultados: " + 
            buffer.porcentajeProd() + "% producción y " + 
            buffer.porcentajeCons() + "% consumo."
        );
    }
}


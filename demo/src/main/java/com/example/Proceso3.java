package com.example;

class Proceso3 extends Thread{
    private Buffer buffer1;
    private Buffer buffer2;
    private String name;
    private int delay;

    public Proceso3(Buffer buffer1, Buffer buffer2, String name, int delay){
        this.buffer1 = buffer1;
        this.buffer2 = buffer2;
        this.name = name;
        this.delay = delay;       
    }
    public void run() {
        try {
            while (true) {
                int x1 = buffer1.consume(name);
                int x2 = buffer1.consume(name);
                int result = x1+x2;
                buffer2.produce(result, name);
                Thread.sleep((int) (Math.random() * delay)); // Espera aleatoria (Otras tareas asíncronas)
            }
        } catch (InterruptedException e) {
            return;
        }
    }   

    
}
package com.example;

class Proceso2 extends Thread{
    private Buffer buffer;
    private String name;
    private int delay;

    public Proceso2(Buffer buffer, String name, int delay){
        this.buffer = buffer;
        this.name = name;
        this.delay = delay;       
    }
    public void run() {
        try {
            while (true) {
                int x = buffer.consume(name);
                buffer.produce(x*x, name);
                Thread.sleep((int) (Math.random() * delay)); // Espera aleatoria (Otras tareas asíncronas)
            }
        } catch (InterruptedException e) {
            return;
        }
    }   

    
}

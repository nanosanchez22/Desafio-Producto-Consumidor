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
                int result = x*x;
                if(result < 0) result = x; // Si al elevarlo al cuadrado, hay overflow, que guarde el número sin elevar.
                buffer.produce(result, name);
                Thread.sleep((int) (Math.random() * delay)); // Espera aleatoria (Otras tareas asíncronas)
            }
        } catch (InterruptedException e) {
            return;
        }
    }   

    
}

package com.example;

class Proceso4 extends Thread{
    private Buffer buffer2;
    private String name;
    private int delay;

    public Proceso4(Buffer buffer2, String name, int delay){
        this.buffer2 = buffer2;
        this.name = name;
        this.delay = delay;       
    }
    public void run() {
        try {
            while (true) {
                int x = buffer2.consume(name);
                System.out.println("Proceso 4: " + x);
                Thread.sleep((int) (Math.random() * delay)); // Espera aleatoria (Otras tareas asíncronas)
            }
        } catch (InterruptedException e) {
            return;
        }
    }   

    
}

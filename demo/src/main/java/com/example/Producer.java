package com.example;

class Producer extends Thread {
    private Buffer buffer;
    private String name;
    private int delay;

    public Producer(Buffer buffer, String name, int delay) {
        this.buffer = buffer;
        this.name = name;
        this.delay = delay;
    }

    public void run() {
        try {
            while (true) {
                int item = (int) (Math.random() * 100); // Genera un entero aleatorio (Tarea Asíncrona)
                buffer.produce(item, name);
                Thread.sleep((int) (Math.random() * delay)); // Espera aleatoria (Otras tareas asíncronas)
            }
        } catch (InterruptedException e) {
            return;
        }
    }
}

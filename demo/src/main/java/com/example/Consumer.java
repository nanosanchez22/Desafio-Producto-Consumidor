package com.example;

class Consumer extends Thread {
    private Buffer buffer;
    private String name;
    private int delay;

    public Consumer(Buffer buffer, String name, int delay) {
        this.buffer = buffer;
        this.name = name;
        this.delay = delay;
    }

    public void run() {
        try {
            while (true) {
                buffer.consume(name);
                Thread.sleep((int) (Math.random() * delay)); // Espera aleatoria (Otras tareas asíncronas)
            }
        } catch (InterruptedException e) {
            return;
        }
    }
}

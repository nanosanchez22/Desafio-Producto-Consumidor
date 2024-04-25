package com.example;
import java.util.Queue;
import java.util.concurrent.Semaphore;
import java.util.ArrayList;



public class CircularQueue<T> {
    public ArrayList<T> queue;
    private int size;
    private int front;
    private int rear;

    public CircularQueue(int size) {
        this.size = size;
        this.queue = new ArrayList<>(size);
        this.front = 0;
        this.rear = 0;
    }

    public boolean isEmpty() {
        return front == rear && queue.isEmpty();
    }

    public boolean isFull() {
        return front == rear && !queue.isEmpty();
    }

    public void enqueue(T item) {
        if (isFull()) {
            System.out.println("La cola está llena.");
            return;
        }

        queue.add(rear, item);
        rear = (rear + 1) % size;
    }

    public T dequeue() {
        if (isEmpty()) {
            System.out.println("La cola está vacía.");
            return null;
        }

        T item = queue.get(front);
        front = (front + 1) % size;
        return item;
    }

    public T peek() {
        if (isEmpty()) {
            System.out.println("La cola está vacía.");
            return null;
        }

        return queue.get(front);
    }

    public int getSize()
    {
        return queue.size();
    }

    public T getElement(int index)
    {
        return queue.get(index); 
    }
    
}



package HW5;

import java.util.concurrent.locks.Lock;


public class Philosopher implements Runnable {
    private final int id;
    private final Lock leftFork;
    private final Lock rightFork;
    private final int mealsToEat;
    private int mealsEaten = 0;

   
    public Philosopher(int id, Lock leftFork, Lock rightFork, int mealsToEat) {
        this.id = id;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
        this.mealsToEat = mealsToEat;
    }

    
    @Override
    public void run() {
        try {
            while (mealsEaten < mealsToEat) {
                think();
                eat();
            }
            System.out.println("Философ " + id + " закончил ужин.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Философ " + id + " останвовлен.");
        }
    }

   
    private void think() throws InterruptedException {
        System.out.println("Философ " + id + " глубоко размышляет.");
        Thread.sleep((long) (Math.random() * 1000));
    }

    
    private void eat() throws InterruptedException {
        leftFork.lock();
        rightFork.lock();
        try {
            mealsEaten++;
            System.out.println("Философ " + id + " ест. Еда № " + mealsEaten);
            Thread.sleep((long) (Math.random() * 1000));
        } finally {
           
            leftFork.unlock();
            rightFork.unlock();
        }
    }
}
package org.example.epam.entity;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Port {
    private final Semaphore semaphore;
    private final long maxCapacity;
    private long currentLoad;


    public Port(long maxCapacity, int numberOfBerths) {
        this.maxCapacity = maxCapacity;
        this.semaphore = new Semaphore(numberOfBerths);
        this.currentLoad = 0;
    }

    public void process(Ship ship) {
        try {
            ReentrantLock locker = new ReentrantLock();
            Condition condition = locker.newCondition();
            semaphore.acquire();
            locker.lock();
            while (!isAvailable(ship)) {
                condition.await();
            }
            System.out.println(ship.getName() + " is processing...");
            currentLoad  += ship.getWeightToUnload() - ship.getWeightToLoad();
            TimeUnit.SECONDS.sleep(ship.getWeightToLoad() + ship.getWeightToUnload());
            System.out.println(ship.getName() + " finished processing. Current load : " + currentLoad);
            TimeUnit.SECONDS.sleep(5);
            locker.unlock();
            semaphore.release();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean isAvailable(Ship ship) {
        return ship.getWeightToUnload() + currentLoad <= maxCapacity && currentLoad + ship.getWeightToLoad() >= 0;
    }
}

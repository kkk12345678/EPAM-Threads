package org.example.epam;

import org.example.epam.entity.Port;
import org.example.epam.entity.Ship;

public class ShipProcessThread implements Runnable {
    private final Ship ship;

    private final Port port;

    public ShipProcessThread(final Port port, final Ship ship) {
        this.ship = ship;
        this.port = port;
    }

    @Override
    public void run() {
        System.out.println(ship.getName() + " is put in the queue.");
        port.process(ship);
    }
}

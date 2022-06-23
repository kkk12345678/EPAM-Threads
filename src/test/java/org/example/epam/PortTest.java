package org.example.epam;

import org.example.epam.entity.Port;
import org.example.epam.entity.Ship;


public class PortTest {
    private static final int NUMBER_OF_BERTHS = 3;

    public static void main(String[] args) {


        Port port = new Port(1000, NUMBER_OF_BERTHS);


        new Thread(new ShipProcessThread(port, new Ship("Ship 1", 10, 15))).start();
        new Thread(new ShipProcessThread(port, new Ship("Ship 2", 10, 20))).start();
        new Thread(new ShipProcessThread(port, new Ship("Ship 3", 10, 25))).start();
        new Thread(new ShipProcessThread(port, new Ship("Ship 4", 10, 30))).start();
        new Thread(new ShipProcessThread(port, new Ship("Ship 5", 10, 35))).start();
        new Thread(new ShipProcessThread(port, new Ship("Ship 6", 10, 40))).start();
        new Thread(new ShipProcessThread(port, new Ship("Ship 7", 10, 45))).start();
        new Thread(new ShipProcessThread(port, new Ship("Ship 8", 10, 50))).start();

    }
}

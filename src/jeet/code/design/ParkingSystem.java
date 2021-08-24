package jeet.code.design;

import java.util.concurrent.atomic.AtomicInteger;

public class ParkingSystem {

    AtomicInteger big = null;
    AtomicInteger medium = null;
    AtomicInteger small = null;

    public ParkingSystem(int big, int medium, int small) {
        this.big = new AtomicInteger(big);
        this.medium = new AtomicInteger(medium);
        this.small = new AtomicInteger(small);
    }

    private boolean check(int current) {
        return (current > 0) ? true : false;
    }

    public boolean addCar(int carType) {
        if (carType < 1 || carType > 3) {
            return false;
        }

        if (1 == carType) {
            int current = big.getAndDecrement();
            return check(current);
        } else if (2 == carType) {
            int current = medium.getAndDecrement();
            return check(current);
        } else if (3 == carType) {
            int current = small.getAndDecrement();
            return check(current);
        }

        return false;
    }
}

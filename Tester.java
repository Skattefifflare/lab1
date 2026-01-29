import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;


public class Tester {

    @Test
    public void testMove() {
        var car = new Saab95();
        car.startEngine();
        car.move();
        assertEquals(0.1, car.getX());

    }

    public static void main(String[] args) {

        Tester t = new Tester();
        t.testMove();
    }

    @Test
    public void testTurnLeft() {
        var car = new Saab95();
        car.startEngine();
        car.move();
        car.turnLeft();
        assertTrue(car.getRight() == 1 && car.getDown() == -1);
        car.turnLeft();
        assertTrue(car.getRight() == 0 && car.getDown() == -1);
        car.turnLeft();
        assertTrue(car.getRight() == -1 && car.getDown() == -1);
        car.turnLeft();
        assertTrue(car.getRight() == -1 && car.getDown() == 0);
        car.turnLeft();
        assertTrue(car.getRight() == -1 && car.getDown() == 1);
        car.turnLeft();
        assertTrue(car.getRight() == 0 && car.getDown() == 1);
        car.turnLeft();
        assertTrue(car.getRight() == 1 && car.getDown() == 1);
        car.turnLeft();
        assertTrue(car.getRight() == 1 && car.getDown() == 0);
    }

    @Test
    public void testTurnRight() {
        var car = new Saab95();
        car.startEngine();
        car.move();
        car.turnRight();
        assertTrue(car.getRight() == 1 && car.getDown() == 0);
        car.turnRight();
        assertTrue(car.getRight() == 1 && car.getDown() == 1);
        car.turnRight();
        assertTrue(car.getRight() == 0 && car.getDown() == 1);
        car.turnRight();
        assertTrue(car.getRight() == -1 && car.getDown() == 1);
        car.turnRight();
        assertTrue(car.getRight() == -1 && car.getDown() == 0);
        car.turnRight();
        assertTrue(car.getRight() == -1 && car.getDown() == -1);
        car.turnRight();
        assertTrue(car.getRight() == 0 && car.getDown() == -1);
        car.turnRight();
        assertTrue(car.getRight() == 1 && car.getDown() == -1);

    }
}


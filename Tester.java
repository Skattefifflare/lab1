import static org.junit.jupiter.api.Assertions.*;


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
        assertEquals(3, car.getDirection());
        car.turnLeft();
        assertEquals(2, car.getDirection());
        car.turnLeft();
        assertEquals(1, car.getDirection());
        car.turnLeft();
        assertEquals(0, car.getDirection());

    }

    @Test
    public void testTurnRight() {
        var car = new Saab95();
        car.startEngine();
        car.move();
        car.turnRight();
        assertEquals(1, car.getDirection());
        car.turnRight();
        assertEquals(2, car.getDirection());
        car.turnRight();
        assertEquals(3, car.getDirection());
        car.turnRight();
        assertEquals(0, car.getDirection());



    }


}


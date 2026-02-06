package cars;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class Tester {

    @Test
    public void testMove() {
        var car = new Saab95();
        car.startEngine();
        car.move();
        assertEquals(0.1, car.getY());
    }

    public static void main(String[] args) {

    }
    @Test
    public void testGasAndBrake(){
        var car2 = new Volvo240();
        var car3 = new Volvo240();
        car2.startEngine();
        car2.move();
        var old_speed = car2.getCurrentSpeed();
        car2.gas(0.9);
        assertTrue(old_speed < car2.getCurrentSpeed());//Gas
        var incSpeed = car2.getCurrentSpeed();
        car2.brake(0.4);
        assertTrue(incSpeed > car2.getCurrentSpeed());//Brake
    }


    @Test
    public void testTurnLeft() {
        var car = new Saab95();
        car.startEngine();


        car.turnLeft();
        assertEquals(3, car.getDirection());
        car.move();
        assertEquals(-0.1, car.getX());
        assertEquals(0.0, car.getY());

        car.turnLeft();
        assertEquals(2, car.getDirection());
        car.move();
        assertEquals(-0.1, car.getX());
        assertEquals(-0.1, car.getY());

        car.turnLeft();
        assertEquals(1, car.getDirection());
        car.move();
        assertEquals(0.0, car.getX());
        assertEquals(-0.1, car.getY());

        car.turnLeft();
        assertEquals(0, car.getDirection());
        car.move();
        car.move();
        assertEquals(0.0, car.getX());
        assertEquals(0.1, car.getY());
    }

    @Test
    public void testTurnRight() {
        var car = new Saab95();
        car.startEngine();

        car.turnRight();
        assertEquals(1, car.getDirection());
        car.move();
        assertEquals(0.1, car.getX());
        assertEquals(0.0, car.getY());

        car.turnRight();
        assertEquals(2, car.getDirection());
        car.move();
        assertEquals(0.1, car.getX());
        assertEquals(-0.1, car.getY());

        car.turnRight();
        assertEquals(3, car.getDirection());
        car.move();
        assertEquals(0.0, car.getX());
        assertEquals(-0.1, car.getY());

        car.turnRight();
        assertEquals(0, car.getDirection());
        car.move();
        car.move();
        assertEquals(0.0, car.getX());
        assertEquals(0.1, car.getY());
    }
    @Test
    public void testTurbo(){
        var saab = new Saab95();
        saab.setTurboOn();
        saab.gas(1);
        assertEquals(1.625, saab.getCurrentSpeed());
    }

    @Test
    public void testFlak(){
        var scania = new Scania();
        scania.IncrementFlak();
        assertEquals(1, scania.getFlakAngle());
    }
}


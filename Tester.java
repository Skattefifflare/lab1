import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;


public class Tester {

    @Test
    public void testMove(){
        var car = new Saab95();
        car.startEngine();
        car.move();
        assertEquals(0.1, car.getX());
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




    public static void main (String[] args){

        Tester t = new Tester();
        t.testMove();
    }
    
}
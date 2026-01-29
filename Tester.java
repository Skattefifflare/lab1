import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;


public class Tester {

    @Test
    public void testMove(){
        var car = new Saab95();
        car.startEngine();
        car.move();
        assertEquals(0.1, car.x_pos);
    }

    @Test
    public void testGas(){
        var car2 = new Volvo240();
        car2.startEngine();
        assertTrue(car2.getCurrentSpeed() < car2.incrementSpeed());


    }

    public static void main (String[] args){

        Tester t = new Tester();
        t.testMove();
    }
    
}

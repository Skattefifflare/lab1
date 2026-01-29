import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;


public class Tester {

    @Test
    public void testMove(){
        var car = new Saab95();
        car.startEngine();
        car.move();
        assertEquals(0.1, car.GetXPos());

    }
    public static void main (String[] args){

        Tester t = new Tester();
        t.testMove();
    }
    @Test
    public void testTurnLeft() {
        var car = new Saab95();
        car.startEngine();
        car.move();
        car.turnLeft();
        assertTrue(getRight()==1 && getDown() == -1);
        car.turnLeft();
        assertTrue(getRight()==0 && getDown() == -1);
        car.turnLeft();
        assertTrue(getRight()==-1 && getDown() == -1);
        car.turnLeft();
        assertTrue(getRight()==-1 && getDown() == 0);
        car.turnLeft();
        assertTrue(getRight()==-1 && getDown() == 1);
        car.turnLeft();
        assertTrue(getRight()==0 && getDown() == 1);
        car.turnLeft();
        assertTrue(getRight()==1 && getDown() == 1);
        car.turnLeft();
        assertTrue(getRight()==1 && getDown() == 0);
    }@Test
    public void testTurnRight() {
        var car = new Saab95();
        car.startEngine();
        car.move();
        car.turnRight();
        assertTrue(getRight()==1 && getDown() == 0);
        car.turnRight();
        assertTrue(getRight()==1 && getDown() == 1);
        car.turnRight();
        assertTrue(getRight()==0 && getDown() == 1);
        car.turnRight();
        assertTrue(getRight()==-1 && getDown() == 1);
        car.turnRight();
        assertTrue(getRight()==-1 && getDown() == 0);
        car.turnRight();
        assertTrue(getRight()==-1 && getDown() == -1);
        car.turnRight();
        assertTrue(getRight()==0 && getDown() == -1);
        car.turnRight();
        assertTrue(getRight()==1 && getDown() == -1);

    }


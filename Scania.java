import java.awt.*;

public class Scania extends Car implements Truck  {


    public Scania(int nrDoors, double enginePower, Color color, String modelName){
        super(nrDoors, enginePower, color, modelName);
    }

    private int flakAngle;
    public int getFlakAngle() {
        return flakAngle;
    }

    @Override
    public double speedFactor(){
        return 1;
    }


    public void DecrementFlak() {
        if(getCurrentSpeed() == 0){
            if (flakAngle > 0){
                flakAngle -= 1;
            }
        }
    }

    public void IncrementFlak() {
        if(getCurrentSpeed() == 0){
            if(flakAngle < 70) {
                flakAngle += 1;
            }
        }
    }
}
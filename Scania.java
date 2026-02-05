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

    }

    @Override
    public double getCurrentSpeed(){
        if(getFlakAngle() == 0){
            return Math.min(Math.max(0, getCurrentSpeed()), getEnginePower());
        } else {return 0;}
    }

    @Override
    public void DecrementFlak(int amount) {
        if(getCurrentSpeed() == 0){
            if(getFlakAngle() - amount >= 0 || getFlakAngle() - amount <= 70){
                flakAngle = getFlakAngle() -  amount;
            }

        }
    }

    @Override
    public void IncrementFlak(int amount) {
        if(getCurrentSpeed() == 0){
            if(getFlakAngle() + amount >= 0 || getFlakAngle() + amount <= 70){
                flakAngle = getFlakAngle() + amount;
            }
        }
    }
}
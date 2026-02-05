import java.awt.*;

public class Transportbil extends Car implements Truck  {

    CarCargo<Car> car;

    public Transportbil(){
        super(2, 1500, Color.green, "Transportbil");
    }

    private boolean flakAngle;
    public boolean getFlakAngle() {
        return flakAngle;
    }

    @Override
    public double speedFactor(){
        if (flakAngle) return 0;
        else return 1;
    }


    public void DecrementFlak() {
        if(getCurrentSpeed() == 0){
            if (flakAngle){
                flakAngle = false;
            }
        }
    }

    public void IncrementFlak() {
        if(getCurrentSpeed() == 0){
            if(!flakAngle) {
                flakAngle = true;
            }
        }
    }
    public void loadCars(){

    }
    public void deloadCars(){

    }
}
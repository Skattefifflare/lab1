import java.awt.*;

public class Transportbil extends Car implements Truck  {

    CarCargo cargo;

    public Transportbil(int nrDoors, double enginePower, Color color, String modelName){
        super(nrDoors, enginePower, color, modelName);
        cargo = new CarCargo<Car>(); // antal i flaket ska vara en constructor parameter?

    }

    private boolean flakUp;
    public boolean getFlakAngle() {
        return flakUp;
    }

    @Override
    public double speedFactor(){
        if (flakUp) return 0;
        else return 1;
    }


    public void DecrementFlak() {
        if(getCurrentSpeed() == 0){
            if (flakUp){
                flakUp = false;
            }
        }
    }

    public void IncrementFlak() {
        if(getCurrentSpeed() == 0){
            if(!flakUp) {
                flakUp = true;
            }
        }
    }
    public void loadCar(){
        if (!flakUp) cargo.Add
    }
    public void deloadCars(){

    }
}
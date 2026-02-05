import java.awt.*;

public class Transportbil extends Car implements Truck  {

    CarCargo cargo;


    public Transportbil(){
        super(2, 1500, Color.green, "Transportbil");
        cargo = new CarCargo<Car>(7); // antal i flaket ska vara en constructor parameter?
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
    public void loadCar(Car car){
        double lenght = Math.sqrt((Math.pow(this.getX()-car.getX(),2)+Math.pow(this.getY()-car.getY(),2)));
        if (!flakUp && lenght<10){
            cargo.Add(car);}
    }
    public void deloadCars(){
        if (flakUp){
            var car = cargo.Remove();
            car.sync();

        }
    }
}
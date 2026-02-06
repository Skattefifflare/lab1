package towing;
import cars.Truck;
import java.awt.*;

public class Transportbil extends Car implements Truck {

    Cargo<Car> cargo;


    public Transportbil(){
        super(2, 1500, Color.green, "towing.Transportbil");
        cargo = new Cargo<Car>(7); // antal i flaket ska vara en constructor parameter?
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
        double length = Math.sqrt((Math.pow(this.getX()-car.getX(),2)+Math.pow(this.getY()-car.getY(),2)));
        if (!flakUp && length<10) {
            cargo.Add(car);
            car.StartTowing();
        }
    }
    public void deloadCar(){
        if (flakUp){
            var car = cargo.Remove();
            car.SetPos(this.getX()-10, this.getY());
            car.StopTowing();
        }
    }

    public void Tow(){
        for (Car car : cargo.car_list){
            car.SetPos(this.getX(), this.getY());
        }
    }
}
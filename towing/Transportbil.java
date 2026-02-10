package towing;
import cars.Truck;
import java.awt.*;
import java.util.List;

public class Transportbil extends Car implements Truck {

    Flak<Car> flak;
    public List<Car> getCargo(){
        return flak.car_list;
    }

    public Transportbil(){
        super(2, 200, Color.green, "towing.Transportbil");
        flak = new Flak<Car>(7);
    }

    private boolean flakUp = true;
    public boolean getFlakState() {
        return flakUp;
    }


    // ser till att bilen inte kan köra med flaket nere
    @Override
    public double speedFactor(){
        if (flakUp) return 0;
        else return 1;
    }
    @Override
    public void startEngine(){
        if (!flakUp) return;
        super.startEngine();
    }


    public void LowerFlak(){
        if(getCurrentSpeed() == 0){
            if (flakUp) {
                flakUp = false;
            }
        }
    }
    public void RaiseFlak(){
        if(getCurrentSpeed() == 0){
            if(!flakUp) {
                flakUp = true;
            }
        }
    }
    public void loadCar(Car car){
        double length = Math.sqrt((Math.pow(this.getX()-car.getX(),2)+Math.pow(this.getY()-car.getY(),2)));
        if (!flakUp && length<1) {
            flak.Add(car);
            car.StartTowing();
        }
    }
    public Car deloadCar(){
        if (!flakUp){
            var car = flak.Remove();
            car.SetPos(this.getX()-10, this.getY());
            car.StopTowing();
            return car;
        }
        throw new IllegalStateException("flak uppe");
    }

    private void Tow(){
        for (Car car : flak.car_list){
            car.SetPos(this.getX(), this.getY());
        }
    }
    @Override
    public void move(){
        super.move();
        Tow();
    }
}
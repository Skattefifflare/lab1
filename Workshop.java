import towing.Car;
import towing.Flak;

public class Workshop<E extends Car> {
    private Flak<E> cars;

    public Workshop(int max_cars){
        cars = new Flak<E>(max_cars);
    }
    public void LeaveCar(E car){
        cars.Add(car);
    }
    public E GetCar(){
        return cars.Remove();
    }
}

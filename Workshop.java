import towing.Car;
import towing.Cargo;

public class Workshop<E extends Car> {
    private Cargo<E> cars;

    public Workshop(){
        cars = new Cargo<E>(10);
    }
}

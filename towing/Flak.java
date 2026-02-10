package towing;
import java.util.ArrayList;
import java.util.List;
import cars.Truck;


public class Flak<E extends Car> {
    int max_cars;
    ArrayList<E> car_list;

    public Flak(int max_cars){
        this.max_cars = max_cars;

        car_list = new ArrayList<>();

    }

    public void Add(E car){
        if (car instanceof Truck || car_list.size() == max_cars) return;
        car_list.add(car);
    }
    public E Remove(){
        int index = car_list.size()-1;
        E car = car_list.get(index);
        car_list.remove(car);
        return car;
    }
}

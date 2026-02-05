import java.util.List;
import java.util.Stack;


public class CarCargo<E> {
    int amount;
    Stack<E> cargo;

    public CarCargo(int amount){
        this.amount = amount;

        cargo = new Stack<>();
    }

    public void Add(E car){
        if (car instanceof Truck || cargo.size() == amount) return;
        cargo.add(car);
    }
    public E Remove(){
        return cargo.pop();
    }
}

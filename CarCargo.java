import java.util.List;
import java.util.Stack;


public class CarCargo<E> {
    int amount;
    Stack<E> cargo;
    List<> banned;

    public CarCargo(int amount, List<E> banned){
        this.amount = amount;

        cargo = new Stack<>();
        this.banned = banned;
    }

    public void Add(E car){
        if (banned.contains(car) || cargo.size() == amount) return;
        cargo.add(car);
    }
    public E Remove(){
        return cargo.pop();
    }
}

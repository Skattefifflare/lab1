import java.awt.*;


public abstract class Car implements Movable {
	protected int nrDoors;          // Number of doors on the car
    protected double enginePower;   // Engine power of the car
    protected double currentSpeed;  // The current speed of the car
    protected Color color;          // Color of the car
    protected String modelName;     // The car model name

    public double x_pos = 0;
    public double y_pos = 0;
    protected int going_right = 1;
    protected int going_down = 0;

    public int getNrDoors(){
        return nrDoors;
    }
    public double getEnginePower(){
        return enginePower;
    }

    public double getCurrentSpeed(){
        return Math.min(Math.max(0, currentSpeed), enginePower);
    }

    public Color getColor(){
        return color;
    }

    public void setColor(Color clr){
	    color = clr;
    }

    public void startEngine(){
	    currentSpeed = 0.1;
    }

    public void stopEngine(){
	    currentSpeed = 0;
    }


    public void gas(double amount){
        if (amount <= 0 || amount >= 1 ) throw new Error("invalid gas parameter");

        var old_speed = getCurrentSpeed();
        incrementSpeed(amount);
        if (old_speed > getCurrentSpeed()) throw new Error("incrementSpeed decreased the speed");
        LimitSpeed();
    }
    public void brake(double amount){
        if (amount <= 0 || amount >= 1 ) throw new Error("invalid brake parameter");

        var old_speed = getCurrentSpeed();
        decrementSpeed(amount);
        if (old_speed > getCurrentSpeed()) throw new Error("decrementSpeed increased the speed");
        LimitSpeed();
    }
    void LimitSpeed(){
        currentSpeed = Math.min(Math.max(0, currentSpeed), enginePower);
    }

    protected abstract double speedFactor();
    protected abstract void incrementSpeed(double amount);
    protected abstract void decrementSpeed(double amount);



    // implementar Movable här:
    public void move(){
        x_pos = going_right * getCurrentSpeed();
        y_pos = going_down * getCurrentSpeed();
    }
    public void turnLeft(){ //45 degree turns
        switch(going_right){
            case 0:
                going_right = (going_down == 1 ? 1 : -1);
                break;
            case 1:
                going_right = (going_down == -1 ? 0 : going_right);
                break;
            case -1:
                going_right = (going_down == 1 ? 0 : going_right);
        }
        switch(going_down){
            case 0:
                going_down = (going_right == -1 ? 1 : -1);
                break;
            case 1:
                going_down = (going_right == 1 ? 0 : going_down);
                break;
            case -1:
                going_down = (going_right == -1 ? 0 : going_down);
        }
    }
    public void turnRight(){ //45 degree turns
        switch(going_right){
            case 0:
                going_right = (going_down == 1 ? -1 : 1);
                break;
            case -1:
                going_right = (going_down == -1 ? 0 : going_right);
                break;
            case 1:
                going_right = (going_down == 1 ? 0 : going_right);
        }
        switch(going_down){
            case 0:
                going_down = (going_right == -1 ? -1 : 1);
                break;
            case -1:
                going_down = (going_right == 1 ? 0 : going_down);
                break;
            case 1:
                going_down = (going_right == -1 ? 0 : going_down);
        }
    }

}
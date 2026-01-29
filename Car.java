import java.awt.*;


public abstract class Car implements Movable {
	private int nrDoors;          // Number of doors on the car
    private double enginePower;   // Engine power of the car
    private double currentSpeed;  // The current speed of the car
    private Color color;          // Color of the car
    private String modelName;     // The car model name

    public Car(int nrDoors, double enginePower, Color color, String modelName){
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
    }
    private double x_pos = 0;
    private double y_pos = 0;
    private int going_right = 1;
    private int going_down = 0;
    public double getX(){return x_pos;}
    public double getY(){return y_pos;}
    public int getRight(){return going_right;}
    public int getDown(){return going_down;}

    public int getNrDoors(){
        return nrDoors;
    }
    public double getEnginePower(){
        return enginePower;
    }
    public String getModelName(){
        return modelName;
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

    public void incrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() + speedFactor() * amount;
    }

    public void decrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() - speedFactor() * amount;
    }


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
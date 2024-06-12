import java.io.Serial;
import java.io.Serializable;

public abstract class Equipment implements Serializable {
    // Declaration of private instance variables representing attributes of equipment.
    private final String name;
    private int price;
    private double attack;
    private double defence;
    private double health;
    private double speed;
    @Serial
    private static final long serialVersionUID = 7896356060120723561L; // serialVersionUID for serialization.

    // Constructor to initialize equipment with a specified name.
    public Equipment(String name){
        this.name = name;
    }

    // Setter methods to set various attributes of the equipment.
    public void setPrice(int price) {
        this.price = price;
    }

    public void setAttack(double attack) {
        this.attack = attack;
    }

    public void setDefence(double defence) {
        this.defence = defence;
    }

    public void setHealth(double health){
        this.health = health;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    // Getter method to retrieve the name of the equipment.
    public String getName() {
        return name;
    }

    // Getter methods to retrieve various attributes of the equipment.
    public int getPrice() {
        return this.price;
    }

    public double getDefence() {
        return defence;
    }

    public double getAttack() {
        return attack;
    }

    public double getHealth() {
        return health;
    }

    public double getSpeed() {
        return speed;
    }
}
import java.io.Serial;
import java.io.Serializable;

public abstract class Character implements Serializable, Cloneable {
    // Declaration of private instance variables representing attributes of a Character.
    private final String name;
    private int price;
    private double attack;
    private double defence;
    private double health;
    private double speed;
    private String characterType;
    private Artefact artefact; // Artefact equipped by the Character.
    public int artefactCount = 0; // Counter for the number of Artefacts equipped.
    private Armour armour; // Armour equipped by the Character.
    public int armourCount = 0; // Counter for the number of Armour equipped.

    // Static final variable to hold the serialVersionUID for serialization purposes.
    @Serial
    private static final long serialVersionUID = 8787261772055597799L;

    // Constructor to initialize a Character with a specified name.
    public Character(String name){
        this.name = name;
    }

    // Getter method to retrieve the name of the Character.
    public String getName() {
        return name;
    }

    // Getter methods to retrieve various attributes of the Character.
    public int getPrice() {
        return price;
    }

    public double getAttack() {
        return attack;
    }

    public double getDefence() {
        return defence;
    }

    public double getHealth() {
        return health;
    }

    public double getSpeed() {
        return speed;
    }

    // Getter methods to retrieve the Artefact and Armour equipped by the Character.
    public Artefact getArtefact() {
        return artefact;
    }

    public Armour getArmour() {
        return armour;
    }

    // Setter method to set the health of the Character, ensuring it's not negative.
    public void setHealth(double health) {
        if (health <= 0){
            this.health = 0;
        }
        else {
            this.health = (double) Math.round(health * 100) /100; // Round the health to two decimal places.
        }
    }

    // Setter methods to set various attributes of the Character.
    public void setPrice(int price) {
        this.price = price;
    }

    public void setDefence(double defence) {
        this.defence = defence;
    }

    public void setAttack(double attack) {
        this.attack = attack;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    // Setter methods to equip an Artefact or Armour to the Character.
    public void setArtefact(Artefact artefact) {
        this.artefact = artefact;
        // Update the attributes of the Character based on the equipped Artefact.
        this.setAttack(this.getAttack() + artefact.getAttack());
        this.setDefence(this.getDefence() + artefact.getDefence());
        this.setHealth(this.getHealth() + artefact.getHealth());
        this.setSpeed(this.getSpeed() + artefact.getSpeed());
        artefactCount++; // Increment the Artefact count.
    }

    public void setArmour(Armour armour) {
        this.armour = armour;
        // Update the attributes of the Character based on the equipped Armour.
        this.setAttack(this.getAttack() + armour.getAttack());
        this.setDefence(this.getDefence() + armour.getDefence());
        this.setHealth(this.getHealth() + armour.getHealth());
        this.setSpeed(this.getSpeed() + armour.getSpeed());
        armourCount++; // Increment the Armour count.
    }

    // Method to create a shallow copy of the Character object.
    @Override
    public Character clone() {
        try {
            Character cloned = (Character) super.clone(); // Call the clone method of the superclass.
            // Copy fields if needed (not implemented here).
            return cloned; // Return the cloned Character object.
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(); // Can't happen
        }
    }

    // Getter method to retrieve the type of Character.
    public String getCharacterType() {
        return characterType;
    }

    // Setter method to set the type of Character, if not already set.
    public void setCharacterType(String characterType) {
        if (this.characterType == null) {
            this.characterType = characterType;
        }
    }
}
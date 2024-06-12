public class Archer extends Character {
    // Constructor for creating an Archer with a specified name.
    public Archer(String name){
        super(name); // Call the constructor of the superclass (Character) with the given name.
        this.createArcher(name); // Initialize the Archer with the specified name.
    }

    // Method to initialize the attributes of the Archer based on its name.
    private void createArcher(String name){
        // Switch statement to set attributes based on the given name.
        switch (name){
            case "shooter": // If the name is "shooter"...
                // Set the attributes of the Archer with appropriate values.
                this.setPrice(80);
                this.setAttack(11);
                this.setDefence(4);
                this.setHealth(6);
                this.setSpeed(9);
                this.setCharacterType("Highlander");
                break;
            case "ranger": // If the name is "ranger"...
                // Set the attributes of the Archer with appropriate values.
                this.setPrice(115);
                this.setAttack(14);
                this.setDefence(5);
                this.setHealth(8);
                this.setSpeed(10);
                this.setCharacterType("Highlander");
                break;
            case "sunfire": // If the name is "sunfire"...
                // Set the attributes of the Archer with appropriate values.
                this.setPrice(160);
                this.setAttack(15);
                this.setDefence(5);
                this.setHealth(8);
                this.setSpeed(14);
                this.setCharacterType("SunChild");
                break;
            case "saggitarius": // If the name is "saggitarius"...
                // Set the attributes of the Archer with appropriate values.
                this.setPrice(230);
                this.setAttack(18);
                this.setDefence(7);
                this.setHealth(12);
                this.setSpeed(17);
                this.setCharacterType("Mystic");
                break;
            case "zing": // If the name is "zing"...
                // Set the attributes of the Archer with appropriate values.
                this.setPrice(200);
                this.setAttack(16);
                this.setDefence(9);
                this.setHealth(11);
                this.setSpeed(14);
                this.setCharacterType("SunChild");
                break;
        }
    }
}

public class Armour extends Equipment {
    // Constructor for creating Armour with a specified name.
    public Armour(String name){
        super(name); // Call the constructor of the superclass (Equipment) with the given name.
        createArmour(name); // Initialize the Armour with the specified name.
    }

    // Method to initialize the attributes of the Armour based on its name.
    private void createArmour(String name){
        // Switch statement to set attributes based on the given name.
        switch (name){
            case "chainmail": // If the name is "chainmail"...
                // Set the attributes of the Armour with appropriate values.
                this.setPrice(70);
                this.setAttack(0);
                this.setDefence(1);
                this.setHealth(0);
                this.setSpeed(-1);
                break;
            case "regalia": // If the name is "regalia"...
                // Set the attributes of the Armour with appropriate values.
                this.setPrice(105);
                this.setAttack(0);
                this.setDefence(1);
                this.setHealth(0);
                this.setSpeed(0);
                break;
            case "fleece": // If the name is "rleece"...
                // Set the attributes of the Armour with appropriate values.
                this.setPrice(150);
                this.setAttack(0);
                this.setDefence(2);
                this.setHealth(1);
                this.setSpeed(-1);
                break;
        }
    }
}

public class Artefact extends Equipment {
    // Constructor for creating Artefact with a specified name.
    public Artefact(String name) {
        super(name); // Call the constructor of the superclass (Equipment) with the given name.
        this.createArmour(name);
    }

    // Method to initialize the attributes of the Artefact based on its name.
    private void createArmour(String name){
        // Switch statement to set attributes based on the given name.
        switch (name){
            case "excalibur": // If the name is "excalibur"...
                // Set the attributes of the Artefact with appropriate values.
                this.setPrice(150);
                this.setAttack(2);
                this.setDefence(0);
                this.setHealth(0);
                this.setSpeed(0);
                break;
            case "amulet": // If the name is "amulet"...
                // Set the attributes of the Artefact with appropriate values.
                this.setPrice(200);
                this.setAttack(1);
                this.setDefence(-1);
                this.setHealth(1);
                this.setSpeed(1);
                break;
            case "crystal": // If the name is "fleece"...
                // Set the attributes of the Artefact with appropriate values.
                this.setPrice(210);
                this.setAttack(2);
                this.setDefence(1);
                this.setHealth(-1);
                this.setSpeed(-1);
                break;
        }
    }
}
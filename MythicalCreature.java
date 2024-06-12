public class MythicalCreature extends Character {

    // Constructor for creating a MythicalCreature object with a specified name
    public MythicalCreature(String name){
        super(name); // Call the constructor of the superclass Character with the given name
        this.createArcher(name); // Call the method to initialize attributes based on the creature's name
    }

    // Method to set attributes based on the name of the mythical creature
    private void createArcher(String name){
        switch (name){
            case "dragon":
                // Set attributes for a dragon
                this.setPrice(120);
                this.setAttack(12);
                this.setDefence(14);
                this.setHealth(15);
                this.setSpeed(8);
                this.setCharacterType("Sunchild");
                break;
            case "basilisk":
                // Set attributes for a basilisk
                this.setPrice(165);
                this.setAttack(15);
                this.setDefence(11);
                this.setHealth(10);
                this.setSpeed(12);
                this.setCharacterType("Marshlander");
                break;
            case "hydra":
                // Set attributes for a hydra
                this.setPrice(205);
                this.setAttack(12);
                this.setDefence(16);
                this.setHealth(15);
                this.setSpeed(11);
                this.setCharacterType("Marshlander");
                break;
            case "phoenix":
                // Set attributes for a phoenix
                this.setPrice(275);
                this.setAttack(17);
                this.setDefence(13);
                this.setHealth(17);
                this.setSpeed(19);
                this.setCharacterType("Sunchild");
                break;
            case "pegasus":
                // Set attributes for a pegasus
                this.setPrice(340);
                this.setAttack(14);
                this.setDefence(18);
                this.setHealth(20);
                this.setSpeed(20);
                this.setCharacterType("Mystic");
                break;
        }
    }
}
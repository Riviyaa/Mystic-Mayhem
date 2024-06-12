public class Knight extends Character {
    // Constructor to initialize a Knight with a specified name.
    public Knight(String name){
        super(name); // Call to the superclass constructor.
        this.createArcher(name); // Method call to create a Knight character based on the given name.
    }

    // Method to create a Knight character based on the given name.
    private void createArcher(String name){
        // Switch statement to initialize attributes based on the given name.
        switch (name){
            case "squire":
                // Setting attributes for the "squire" Knight.
                this.setPrice(85);
                this.setAttack(8);
                this.setDefence(9);
                this.setHealth(7);
                this.setSpeed(8);
                this.setCharacterType("Marshlander");
                break;
            case "cavalier":
                // Setting attributes for the "cavalier" Knight.
                this.setPrice(110);
                this.setAttack(10);
                this.setDefence(12);
                this.setHealth(7);
                this.setSpeed(10);
                this.setCharacterType("Highlander");
                break;
            case "templar":
                // Setting attributes for the "templar" Knight.
                this.setPrice(155);
                this.setAttack(14);
                this.setDefence(16);
                this.setHealth(12);
                this.setSpeed(12);
                this.setCharacterType("Sunchild");
                break;
            case "zoro":
                // Setting attributes for the "zoro" Knight.
                this.setPrice(180);
                this.setAttack(17);
                this.setDefence(16);
                this.setHealth(13);
                this.setSpeed(14);
                this.setCharacterType("Highlander");
                break;
            case "swiftblade":
                // Setting attributes for the "swiftblade" Knight.
                this.setPrice(250);
                this.setAttack(18);
                this.setDefence(20);
                this.setHealth(17);
                this.setSpeed(13);
                this.setCharacterType("Marshlander");
                break;
        }
    }
}
public class Healer extends Character {
    // Constructor to initialize a Healer with a specified name.
    public Healer(String name){
        super(name); // Call to the superclass constructor.
        this.createArcher(name); // Method call to create a Healer character based on the given name.
    }

    // Method to create a Healer character based on the given name.
    private void createArcher(String name){
        // Switch statement to initialize attributes based on the given name.
        switch (name){
            case "soother":
                // Setting attributes for the "soother" Healer.
                this.setPrice(95);
                this.setAttack(10);
                this.setDefence(8);
                this.setHealth(9);
                this.setSpeed(6);
                this.setCharacterType("Sunchild");
                break;
            case "medic":
                // Setting attributes for the "medic" Healer.
                this.setPrice(125);
                this.setAttack(12);
                this.setDefence(9);
                this.setHealth(10);
                this.setSpeed(7);
                this.setCharacterType("Highlander");
                break;
            case "alchemist":
                // Setting attributes for the "alchemist" Healer.
                this.setPrice(150);
                this.setAttack(13);
                this.setDefence(13);
                this.setHealth(13);
                this.setSpeed(13);
                this.setCharacterType("Marshlander");
                break;
            case "saint":
                // Setting attributes for the "saint" Healer.
                this.setPrice(200);
                this.setAttack(16);
                this.setDefence(14);
                this.setHealth(17);
                this.setSpeed(9);
                this.setCharacterType("Mystic");
                break;
            case "lightbringer":
                // Setting attributes for the "lightbringer" Healer.
                this.setPrice(260);
                this.setAttack(17);
                this.setDefence(15);
                this.setHealth(19);
                this.setSpeed(12);
                this.setCharacterType("Sunchild");
                break;
        }
    }
}
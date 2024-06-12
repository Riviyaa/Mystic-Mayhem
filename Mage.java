public class Mage extends Character {
    public Mage(String name){
        super(name); // Call superclass constructor
        this.createArcher(name); // Call createArcher method
    }

    // Method to create Archer based on name
    private void createArcher(String name){
        switch (name){
            case "warlock":
                // Set attributes for warlock
                this.setPrice(100);
                this.setAttack(12);
                this.setDefence(7);
                this.setHealth(10);
                this.setSpeed(12);
                this.setCharacterType("Marshlander");
                break;
            case "illusionist":
                // Set attributes for illusionist
                this.setPrice(120);
                this.setAttack(13);
                this.setDefence(8);
                this.setHealth(12);
                this.setSpeed(14);
                this.setCharacterType("Mystic");
                break;
            case "enchanter":
                // Set attributes for enchanter
                this.setPrice(160);
                this.setAttack(16);
                this.setDefence(10);
                this.setHealth(13);
                this.setSpeed(16);
                this.setCharacterType("Highlander");
                break;
            case "conjurer":
                // Set attributes for conjurer
                this.setPrice(195);
                this.setAttack(18);
                this.setDefence(15);
                this.setHealth(14);
                this.setSpeed(12);
                this.setCharacterType("Highlander");
                break;
            case "eldritch":
                // Set attributes for eldritch
                this.setPrice(270);
                this.setAttack(19);
                this.setDefence(17);
                this.setHealth(18);
                this.setSpeed(14);
                this.setCharacterType("Mystic");
                break;
        }
    }

}

import java.util.*;

/**
 * The War class represents a war between two users in a game.
 * Each user has an army of characters, and the war is conducted in turns.
 * The characters in the army can attack, defend, and heal.
 */
public class War {
    User initialChallenger; // The user who initiates the war
    User initialOpponent; // The user who is challenged to the war
    Vector<Character> challengerArmy; // The army of the challenger
    Vector<Character> opponentArmy; // The army of the opponent


    // The following vectors are used for sorting the army characters
    private Vector<Character> challengerArmyAttackingArray;
    private Vector<Character> opponentArmyAttackingArray;
    private Vector<Character> challengerArmyDefendingArray;
    private Vector<Character> opponentArmyDefendingArray;
    private Vector<Character> opponentArmyHealingArray;
    private Vector<Character> challengerArmyHealingArray;

    /**
     * The constructor for the War class.
     * It initializes the challenger and opponent, and starts the war.
     */
    public War(User initialChallenger,User initialOpponent){
        this.initialChallenger = initialChallenger;
        this.initialOpponent = initialOpponent;
        this.startWar();
    }

    /**
     * This method initializes the attacking, defending, and healing arrays for both armies.
     * It sorts the characters in the armies based on their speed and type.
     */
    private void initialingArrays(Vector<Character> challengerArmy, Vector<Character> opponentArmy){
        this.challengerArmyAttackingArray = new Vector<>(attackPriorityCheck(challengerArmy));
        this.opponentArmyAttackingArray = new Vector<>(attackPriorityCheck(opponentArmy));
        this.opponentArmyDefendingArray = new Vector<>(defencePriorityCheck(opponentArmy));
        this.challengerArmyDefendingArray = new Vector<>(defencePriorityCheck(challengerArmy));
        this.opponentArmyHealingArray = new Vector<>(opponentArmy);
        this.challengerArmyHealingArray = new Vector<>(challengerArmy);
        this.opponentArmyHealingArray.sort(Comparator.comparingDouble(Character::getHealth));
        this.challengerArmyHealingArray.sort(Comparator.comparingDouble(Character::getHealth));
    }

    /**
     * This method sorts the characters in an army based on their speed and type.
     * It is used to determine the order of attack.
     */
    public Vector<Character> attackPriorityCheck(Vector<Character> list){
        list.sort(Comparator.comparingDouble(Character::getSpeed)
                .thenComparing(character -> {
                    if (character instanceof Healer) return 1;
                    else if (character instanceof Mage) return 2;
                    else if (character instanceof MythicalCreature) return 3;
                    else if (character instanceof Knight) return 4;
                    else return 5;
                }).reversed());
        return list;
    }

    /**
     * This method sorts the characters in an army based on their defence and type.
     * It is used to determine the order of defence.
     */
    public Vector<Character> defencePriorityCheck(Vector<Character> list){
        list.sort(Comparator.comparingDouble(Character::getDefence)
                .thenComparing(character -> {
                    if (character instanceof Mage) return 1;
                    else if (character instanceof Knight) return 2;
                    else if (character instanceof Archer) return 3;
                    else if (character instanceof MythicalCreature) return 4;
                    else return 5;
                }));
        return list;
    }

    /**
     * This method starts the war.
     * It clones the armies of the challenger and opponent, and adjusts the attributes of the characters based on the home ground of the opponent.
     * It then initializes the attacking, defending, and healing arrays for both armies.
     */
    void startWar(){
        this.challengerArmy = new Vector<>();
        for (Character character : initialChallenger.getArmy()) {
            this.challengerArmy.add(character.clone());
        }
        this.opponentArmy = new Vector<>();
        for (Character character : initialOpponent.getArmy()) {
            this.opponentArmy.add(character.clone());
        }
        for (Character character : challengerArmy){
            switch (initialOpponent.getHomeGround()) {
                case "Hillcrest" -> {
                    if (character.getCharacterType().equals("Highlander")) {
                        character.setAttack(character.getAttack() + 1);
                        character.setDefence(character.getDefence() + 1);
                    }
                    if (character.getCharacterType().equals("Marshlander")) {
                        character.setSpeed(character.getSpeed() - 1);
                    }
                    if (character.getCharacterType().equals("Sunchild")) {
                        character.setSpeed(character.getSpeed() - 1);
                    }
                }
                case "Marshland" -> {
                    if (character.getCharacterType().equals("Marshlander")) {
                        character.setDefence(character.getDefence() + 2);
                    }
                    if (character.getCharacterType().equals("Sunchild")) {
                        character.setAttack(character.getAttack() - 1);
                    }
                    if (character.getCharacterType().equals("Mystic")) {
                        character.setSpeed(character.getSpeed() - 1);
                    }
                }
                case "Desert" -> {
                    if (character.getCharacterType().equals("Marshlander")) {
                        character.setHealth(character.getHealth() - 1);
                    }
                    if (character.getCharacterType().equals("Sunchild")) {
                        character.setAttack(character.getAttack() + 1);
                    }
                }
                case "Arcane" -> {
                    if (character.getCharacterType().equals("Mystic")) {
                        character.setAttack(character.getAttack() + 2);
                    }
                    if (character.getCharacterType().equals("Highlander")) {
                        character.setSpeed(character.getSpeed() - 1);
                        character.setDefence(character.getDefence() - 1);
                    }
                    if (character.getCharacterType().equals("Marshlander")) {
                        character.setSpeed(character.getSpeed() - 1);
                        character.setDefence(character.getDefence() - 1);
                    }
                }
            }
        }
        for(Character character:opponentArmy){
            switch (initialOpponent.getHomeGround()) {
                case "Hillcrest" -> {
                    if (character.getCharacterType().equals("Highlander")) {
                        character.setAttack(character.getAttack() + 1);
                        character.setDefence(character.getDefence() + 1);
                    }
                    if (character.getCharacterType().equals("Marshlander")) {
                        character.setSpeed(character.getSpeed() - 1);
                    }
                    if (character.getCharacterType().equals("Sunchild")) {
                        character.setSpeed(character.getSpeed() - 1);
                    }
                }
                case "Marshland" -> {
                    if (character.getCharacterType().equals("Marshlander")) {
                        character.setDefence(character.getDefence() + 2);
                    }
                    if (character.getCharacterType().equals("Sunchild")) {
                        character.setAttack(character.getAttack() - 1);
                    }
                    if (character.getCharacterType().equals("Mystic")) {
                        character.setSpeed(character.getSpeed() - 1);
                    }
                }
                case "Desert" -> {
                    if (character.getCharacterType().equals("Marshlander")) {
                        character.setHealth(character.getHealth() - 1);
                    }
                    if (character.getCharacterType().equals("Sunchild")) {
                        character.setAttack(character.getAttack() + 1);
                    }
                }
                case "Arcane" -> {
                    if (character.getCharacterType().equals("Mystic")) {
                        character.setAttack(character.getAttack() + 2);
                    }
                    if (character.getCharacterType().equals("Highlander")) {
                        character.setSpeed(character.getSpeed() - 1);
                        character.setDefence(character.getDefence() - 1);
                    }
                    if (character.getCharacterType().equals("Marshlander")) {
                        character.setSpeed(character.getSpeed() - 1);
                        character.setDefence(character.getDefence() - 1);
                    }
                }
            }
        }
        initialingArrays(challengerArmy, opponentArmy);

        Iterator<Character> challengerHealingIterator = challengerArmyHealingArray.iterator();
        while (challengerHealingIterator.hasNext()) {
            Character character = challengerHealingIterator.next();
            if (character instanceof Healer) {
                challengerHealingIterator.remove();
            }
        }

        Iterator<Character> opponentHealingIterator = opponentArmyHealingArray.iterator();
        while (opponentHealingIterator.hasNext()) {
            Character character = opponentHealingIterator.next();
            if (character instanceof Healer) {
                opponentHealingIterator.remove();
            }
        }
        boolean attackingSide = false;
        int turn = 1;
        double previousHealth = opponentArmyDefendingArray.getFirst().getHealth();
        int ci = 0;
        int oi = 0;

        System.out.println("\n\n" + initialChallenger.getUserName() + "  V/S  " + initialOpponent.getUserName() + "\n");

        while (true) {
            if (!attackingSide) {
                System.out.println("\nTurn " + turn + ": " + initialChallenger.getUserName());

                if(!(challengerArmyAttackingArray.get(ci) instanceof Healer)) {
                    System.out.println(String.format("** %s's %s attacks %s's %s **",
                            initialChallenger.getUserName(),
                            challengerArmyAttackingArray.get(ci).getName(),
                            initialOpponent.getUserName(),
                            opponentArmyDefendingArray.getFirst().getName()));

                    double damage = 0.5 * (challengerArmyAttackingArray.get(ci).getAttack()) - 0.1 * (opponentArmyDefendingArray.getFirst().getDefence());

                    opponentArmyDefendingArray.get(0).setHealth(opponentArmyDefendingArray.get(0).getHealth() - damage);

                    //System.out.println(opponentArmyDefendingArray.getFirst().getName()+"'s health reduce by " + damage + " by the attack of " + challengerArmyAttackingArray.get(ci).getName());

                    if(initialChallenger.getHomeGround().equals("Hillcrest") && challengerArmyAttackingArray.get(ci).getCharacterType().equals("Highlander")){
                        double bonusDamage = 0.5 * (challengerArmyAttackingArray.get(ci).getAttack()*0.2) - 0.1 * (opponentArmyDefendingArray.get(0).getDefence());

                        opponentArmyDefendingArray.get(0).setHealth(opponentArmyDefendingArray.get(0).getHealth() - bonusDamage);
                    }
                    if (turn != 1){
                        if(initialChallenger.getHomeGround().equals("Arcane") && opponentArmyDefendingArray.get(0).getCharacterType().equals("Mystics")){
                            opponentArmyDefendingArray.get(0).setHealth(previousHealth*1.1);
                        }
                    }
                    System.out.println(String.format("-- %s's %s's health: %s",
                            initialOpponent.getUserName(),
                            opponentArmyDefendingArray.getFirst().getName(),
                            opponentArmyDefendingArray.getFirst().getHealth()));

                    System.out.println(String.format("-- %s's %s's health: %s",
                            initialChallenger.getUserName(),
                            challengerArmyAttackingArray.get(ci).getName(),
                            challengerArmyAttackingArray.get(ci).getHealth()));

                    if(opponentArmyDefendingArray.getFirst().getHealth() <= 0){
                        System.out.println(initialOpponent.getUserName() + "'s " + opponentArmyDefendingArray.getFirst().getName()+" Died!");

                        Character deadCharacter = opponentArmyDefendingArray.getFirst();

                        opponentArmyDefendingArray.remove(deadCharacter);
                        opponentArmyHealingArray.remove(deadCharacter);
                        opponentArmyAttackingArray.remove(deadCharacter);

                        if (opponentArmyAttackingArray.isEmpty()){
                            break;
                        }
                    }

                }
                else{
                    challengerArmyHealingArray.sort(Comparator.comparingDouble(Character::getHealth));;

                    double healvalue = 0.1*(challengerArmyHealingArray.get(0).getAttack());

                    challengerArmyHealingArray.get(0).setHealth(challengerArmyHealingArray.get(0).getHealth() + healvalue);

                    System.out.println(String.format("** %s's %s heals %s's %s **",
                            initialChallenger.getUserName(),
                            challengerArmyAttackingArray.get(ci).getName(),
                            initialChallenger.getUserName(),
                            challengerArmyHealingArray.getFirst().getName()));


                    Character healedchar = challengerArmyHealingArray.get(0);

                    for (Character character : opponentArmyDefendingArray) {
                        if(character.getName().equals(healedchar.getName())){
                            character.setHealth(character.getHealth()+healvalue);
                        }
                    }

                    System.out.println(String.format("-- %s's %s's health: %s",
                            initialChallenger.getUserName(),
                            challengerArmyHealingArray.getFirst().getName(),
                            challengerArmyHealingArray.getFirst().getHealth()));

                    System.out.println(String.format("-- %s's %s's health: %s",
                            initialChallenger.getUserName(),
                            challengerArmyAttackingArray.get(ci).getName(),
                            challengerArmyAttackingArray.get(ci).getHealth()));
                }
                attackingSide = true;
                ci++;
            }
            else{
                System.out.println("\nTurn " + turn + ": " + initialOpponent.getUserName());

                if(!(opponentArmyAttackingArray.get(oi) instanceof Healer)) {
                    System.out.println(String.format("** %s's %s attacks %s's %s **",
                            initialOpponent.getUserName(),
                            opponentArmyAttackingArray.get(oi).getName(),
                            initialChallenger.getUserName(),
                            challengerArmyDefendingArray.getFirst().getName()));

                    //calculates damage
                    double dmg = 0.5 * (opponentArmyAttackingArray.get(oi).getAttack()) - 0.1 * (challengerArmyDefendingArray.get(0).getDefence());

                    challengerArmyDefendingArray.get(0).setHealth(challengerArmyDefendingArray.get(0).getHealth() - dmg);
                    //System.out.println(challengerArmyDefendingArray.get(0).getName() + "'s health reduce by " + dmg + " by the attack of " + opponentArmyAttackingArray.get(oi).getName());

                    if(initialChallenger.getHomeGround().equals("Hillcrest") && opponentArmyAttackingArray.get(0).getCharacterType().equals("Highlander")){

                        double bonusdmg = 0.5 * (opponentArmyAttackingArray.get(oi).getAttack()*0.2) - 0.1 * (challengerArmyDefendingArray.get(0).getDefence());

                        opponentArmyDefendingArray.get(0).setHealth(opponentArmyDefendingArray.get(0).getHealth() - bonusdmg);
                    }
                    if(turn != 1){
                        if(initialChallenger.getHomeGround().equals("Arcane") && challengerArmyDefendingArray.get(0).getCharacterType().equals("Mystics")){
                            challengerArmyDefendingArray.get(0).setHealth(previousHealth*1.1);
                        }
                    }

                    System.out.println(String.format("-- %s's %s's health: %s",
                            initialChallenger.getUserName(),
                            challengerArmyDefendingArray.getFirst().getName(),
                            challengerArmyDefendingArray.getFirst().getHealth()));

                    System.out.println(String.format("-- %s's %s's health: %s",
                            initialOpponent.getUserName(),
                            opponentArmyAttackingArray.get(oi).getName(),
                            opponentArmyAttackingArray.get(oi).getHealth()));

                    if(challengerArmyDefendingArray.get(0).getHealth() <= 0){
                        System.out.println(initialChallenger.getUserName() + "'s " + challengerArmyDefendingArray.get(0).getName()+" Died!");

                        Character deadCharacter = challengerArmyDefendingArray.getFirst();

                        challengerArmyDefendingArray.remove(deadCharacter);
                        challengerArmyHealingArray.remove(deadCharacter);
                        challengerArmyAttackingArray.remove(deadCharacter);

                        if (challengerArmyDefendingArray.isEmpty()){
                            break;
                        }
                    }
                }
                else{
                    double healvalue = 0.1*(challengerArmyHealingArray.get(0).getAttack());

                    challengerArmyHealingArray.get(0).setHealth(challengerArmyHealingArray.get(0).getHealth()+healvalue);

                    System.out.println(String.format("** %s's %s heals %s's %s **",
                            initialOpponent.getUserName(),
                            opponentArmyAttackingArray.get(oi).getName(),
                            initialOpponent.getUserName(),
                            opponentArmyHealingArray.getFirst().getName()));

                    Character healedchar=challengerArmyHealingArray.get(0);

                    for (Character character : challengerArmyDefendingArray) {
                        if(character.getName().equals(healedchar.getName())){
                            character.setHealth(character.getHealth()+healvalue);
                        }
                    }

                    System.out.println(String.format("-- %s's %s's health: %s",
                            initialOpponent.getUserName(),
                            opponentArmyHealingArray.getFirst().getName(),
                            opponentArmyHealingArray.getFirst().getHealth()));

                    System.out.println(String.format("-- %s's %s's health: %s",
                            initialOpponent.getUserName(),
                            opponentArmyAttackingArray.get(oi).getName(),
                            opponentArmyAttackingArray.get(oi).getHealth()));

                }

                if (!opponentArmyDefendingArray.isEmpty()) {
                    previousHealth = opponentArmyDefendingArray.get(0).getHealth();
                }
                challengerArmyHealingArray.sort(Comparator.comparingDouble(Character::getHealth));
                opponentArmyHealingArray.sort(Comparator.comparingDouble(Character::getHealth));
                attackingSide = false;
                turn++;
                oi++;

            }
            if (oi >= opponentArmyAttackingArray.size()){
                oi = 0;
            }

            if (ci >= challengerArmyAttackingArray.size()){
                ci = 0;
            }

            if(turn > 10){
                break;
            }
        }

        System.out.println("\n-------War Ended------\n");
        System.out.println("------Result----------");
        if(opponentArmyAttackingArray.isEmpty()) {
            System.out.println(initialChallenger.getName().toUpperCase() + " Won!" );
            initialChallenger.setXp(1);
            initialChallenger.setCoins((int) (initialOpponent.getCoins()*0.1));
            initialOpponent.setCoins((int)(-initialOpponent.getCoins()*0.1));
        } else if (challengerArmyAttackingArray.isEmpty()) {
            System.out.println(initialOpponent.getName().toUpperCase() +" Won! " );
            initialOpponent.setXp(1);
            initialOpponent.setCoins((int) (initialChallenger.getCoins()*0.1));
            initialChallenger.setCoins((int) (-initialChallenger.getCoins()*0.1));
        }
        else{
            System.out.println("Drawn!");
        }
        System.out.println("----------------------");
        System.out.println(initialChallenger.getUserName()  + " | XP: " + Math.round(initialChallenger.getXp()) + " | gold coins: " + Math.round(initialChallenger.getCoins()));
        System.out.println(initialOpponent.getUserName() + " | XP: " + Math.round(initialOpponent.getXp()) + " | gold coins: " + Math.round(initialOpponent.getCoins()));
        System.out.println();
    }
}
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;

/**
 * This class represents the main menu of the game.
 * It implements the MenuInterface and contains methods for displaying the menu, saving and loading user data, creating new profiles, and initiating battles.
 */
public class Menu implements MenuInterface{
    // Lists to store user data and character names
    static List<User> userList = new ArrayList<>();
    static List<String> userNames = new ArrayList<>();
    // Lists to store the names of different types of characters
    private final List<String> archers = List.of("shooter", "ranger", "sunfire", "zing", "saggitarius");
    private final List<String> knights = List.of("squire", "cavalier", "templar", "zoro", "swiftblade");
    private final List<String> mages = List.of("warlock", "illusionist", "enchanter", "conjurer", "eldritch");
    private final List<String> healers = List.of("soother", "medic", "alchemist", "saint", "lightbringer");
    private final List<String> mythicalCreatures = List.of("dragon", "basilisk", "hydra", "phoenix", "pegasus");
    private final List<String> armours = List.of("chainmail", "regalia", "fleece");
    private final List<String> artefacts = List.of("excalibur", "amulet", "crystal");

    // Scanner to read user input
    private Scanner scanner = new Scanner(System.in);

    // Current user and challenger in the game
    private User currentUser;
    private User challenger;

    /**
     * Constructor for the Menu class.
     * It loads the user data from the file when a new Menu object is created.
     */
    public Menu() {
        loadFile();
    }

    /**
     * This method displays the main menu of the game and handles user input to navigate through the menu.
     */
    public void displayMenu() {
        while (true) {
            System.out.println(""
                    + "╔═══════════════════╗\n"
                    + "  M A I N  M E N U \n"
                    + "╚═══════════════════╝\n"
                    + "1. New Adventure\n"
                    + "2. Add a Custom Profile\n"
                    + "3. Load Profile\n"
                    + "4. View Profile\n"
                    + "5. View Army\n"
                    + "6. Reinforce Army\n"
                    + "7. Initiate a Battle\n"
                    + "8. Exit Arena\n"
                    + "═════════════════════");
            try {
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        clearScreen();
                        this.createNewProfile();
                        break;
                    case 2:
                        clearScreen();
                        this.createCustomProfile();
                        break;
                    case 3:
                        clearScreen();
                        this.loadProfile();
                        break;
                    case 4:
                        clearScreen();
                        this.printUserData(currentUser);
                        this.waitForInput();
                        break;
                    case 5:
                        clearScreen();
                        this.printUserDetailsinWar(currentUser);
                        this.waitForInput();
                        break;
                    case 6:
                        clearScreen();
                        this.reinforceArmy();
                        this.waitForInput();
                        break;
                    case 7:
                        clearScreen();
                        this.initiateBattle();
                        break;
                    case 8:
                        saveUserList();
                        System.out.println("Exiting program...");
                        System.exit(0);
                    default:
                        System.out.println("\nInvalid choice, Please enter a digit from 1 to 8\n");
                }
            } catch (InputMismatchException e) {
                System.out.println("\nInvalid input, Please enter a digit from 1 to 8\n");
                scanner.next();
            }
        }
    }

    /**
     * This method saves the list of users to a file.
     */
    public void saveUserList(){
        try{
            FileOutputStream data = new FileOutputStream("gamesave.ser");
            ObjectOutputStream obj = new ObjectOutputStream(data);
            obj.writeObject(userList);
            obj.close();
        }
        catch (IOException e) {
            System.out.println("Could not save the game file...");
        }
    }

    /**
     * This method loads the list of users from a file.
     */
    public void loadFile() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("gamesave.ser"))){
            userList = (List<User>) in.readObject();
            userNames.clear(); // Clear the list before populating
            for (User user : userList) {
                userNames.add(user.getUserName()); // Add each user's username to the list
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Game save not found. Welcome to Mystic Mayhem...");
        }
    }

    /**
     * This method creates a new user profile.
     */
    private void createNewProfile() {
        // Prompt the user to enter their name
        System.out.print("Enter Your Name: ");
        String name = scanner.next();

        // Prompt the user to enter a unique username
        String userName;
        System.out.println("Now choose a USERNAME. This must be UNIQUE and you can't change this later.");
        while (true) {
            System.out.print("Enter Username: ");
            userName = scanner.next();
            // Check if the username already exists
            if (userNames.contains(userName)) {
                System.out.println("Username Already Exists!");
            } else {
                // If the username is unique, add it to the list of usernames and break the loop
                userNames.add(userName);
                break;
            }
        }

        // Prompt the user to choose a home ground for their army
        System.out.println("Now choose a home ground for your army\n" +
                "1. Hillcrest\n" +
                "2. Marshland\n" +
                "3. Desert\n" +
                "4. Arcane");

        // Get the user's choice for the home ground
        int homeGroundChoice = 0;
        while (true) {
            try {
                homeGroundChoice = scanner.nextInt();
                // Check if the user's choice is valid
                if (homeGroundChoice >= 1 && homeGroundChoice <= 4) {
                    break; // Exit the loop if a valid choice is made
                } else {
                    System.out.println("\nInvalid Choice, Please enter a digit from 1 to 4");
                }
            } catch (InputMismatchException e) {
                System.out.println("\nInvalid Input, Please enter a digit from 1 to 4");
                scanner.next(); // Clear the invalid input from the scanner buffer
            }
        }

        // Create a new user based on the user's inputs
        User newUser;
        if (homeGroundChoice == 1) {
            newUser = new User(name, userName, "Hillcrest");
        } else if (homeGroundChoice == 2) {
            newUser = new User(name, userName, "Marshland");
        } else if (homeGroundChoice == 3) {
            newUser = new User(name, userName, "Desert");
        } else {
            newUser = new User(name, userName, "Arcane");
        }

        // Prompt the user to enforce their army by selecting characters
        System.out.println("\nPerfect! You're on the verge of your first battle. Let's now enforce your army");
        System.out.println("Here's a detailed table about troops. Be mindful to choose only one character from each type\n");
        Table.displayTroopsTable();
        System.out.println("\nYou have only " + Math.round(newUser.getCoins()) + " gc in your treasure");
        System.out.println("Embark on your journey by selecting characters from above categories\n");

        // Loop until the user's army is complete
        while (newUser.getArmy().size() < 5) {
            System.out.print("Provide a name to bring it to life: ");
            String characterName = scanner.next().toLowerCase();
            Character newCharacter = null;
            // Check the type of the character and create a new character of that type
            if (archers.contains(characterName)) {
                newCharacter = new Archer(characterName);
            } else if (knights.contains(characterName)) {
                newCharacter = new Knight(characterName);
            } else if (mages.contains(characterName)) {
                newCharacter = new Mage(characterName);
            } else if (healers.contains(characterName)) {
                newCharacter = new Healer(characterName);
            } else if (mythicalCreatures.contains(characterName)) {
                newCharacter = new MythicalCreature(characterName);
            } else {
                System.out.println("Enter a valid name!!");
                continue;
            }

            // Check if the user has enough coins to add the character to their army
            if (newUser.getCoins() < newCharacter.getPrice()) {
                System.out.println("\nYou don't have enough coins to add this troop. You have " + Math.round(newUser.getCoins()) + " coins and the troop costs " + newCharacter.getPrice() + " coins.");
                System.out.print("Do you want to continue (c) or start adding troops from the beginning (s)? ");
                String decision = "";
                while (true) {
                    try {
                        decision = scanner.next();
                        // Check if the user's decision is valid
                        if (decision.equalsIgnoreCase("s") || decision.equalsIgnoreCase("c")) {
                            break; // Exit the loop if a valid input is provided
                        } else {
                            System.out.println("Invalid input. Please enter 's' or 'c'.");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input. Please enter 's' or 'c'.");
                        scanner.next(); // Clear the invalid input from the scanner buffer
                    }
                }

                // If the user decides to start over, reset their coins and clear their army
                if (decision.equalsIgnoreCase("s")) {
                    System.out.println();
                    newUser.setCoins(500 - newUser.getCoins());
                    newUser.getArmy().clear();
                    // continue with the rest of the code
                } else if (decision.equalsIgnoreCase("c")) {
                    // If the user decides to continue, skip this iteration and move on to the next one
                    continue;
                }
            } else {
                // If the user has enough coins, add the character to their army
                newUser.addTroopToArmy(newCharacter);
                System.out.println("You have only " + Math.round(newUser.getCoins()) + " coins remaining\n");
            }
        }

        // Once the user's army is complete, add the user's profile to the userList and save it to the file
        System.out.println("PERFECT!! Your legion is now complete");
        userList.add(newUser);
        saveUserList();
        System.out.println("\nWELCOME to the world of Mystic Mayhem" + "\nYou are all set to go\n");
        printUserData(newUser);
        printArmy(newUser);
        setCurrentUser(newUser);

        // Prompt the user to initiate a battle or return to the main menu
        System.out.println("\n" +
                "════════════════════\n" +
                "1. Initiate a Battle\n" +
                "2. Back to Main Menu\n" +
                "════════════════════");
        while (true) {
            try {
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        clearScreen();
                        initiateBattle();
                        saveUserList();
                        break;
                    case 2:
                        System.out.println("Returning to the main menu...\n");
                        displayMenu();
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please try again.");
                scanner.next();
            }
        }
    }

    /**
     * This method creates a custom user profile.
     */
    private void createCustomProfile(){
        // Prompt the user to enter their name
        System.out.print("Enter Your Name: ");
        String name = scanner.next();

        // Prompt the user to enter a unique username
        String userName;
        System.out.println("Now choose a USERNAME. This must be UNIQUE and you can't change this later.");
        while (true) {
            System.out.print("Enter Username: ");
            userName = scanner.next();
            // Check if the username already exists
            if (userNames.contains(userName)) {
                System.out.println("Username Already Exists!");
            } else {
                // If the username is unique, add it to the list of usernames and break the loop
                userNames.add(userName);
                break;
            }
        }

        // Prompt the user to choose a home ground for their army
        System.out.println("Now choose a home ground for your army\n" +
                "1. Hillcrest\n" +
                "2. Marshland\n" +
                "3. Desert\n" +
                "4. Arcane");

        // Get the user's choice for the home ground
        int homeGroundChoice = 0;
        while (true) {
            try {
                homeGroundChoice = scanner.nextInt();
                // Check if the user's choice is valid
                if (homeGroundChoice >= 1 && homeGroundChoice <= 4) {
                    break; // Exit the loop if a valid choice is made
                } else {
                    System.out.println("\nInvalid Input, Please enter a digit from 1 to 4");
                }
            } catch (InputMismatchException e) {
                System.out.println("\nInvalid Input, Please enter a digit from 1 to 4");
                scanner.next(); // Clear the invalid input from the scanner buffer
            }
        }

        // Create a new user based on the user's inputs
        User newUser;
        if (homeGroundChoice == 1) {
            newUser = new User(name, userName, "Hillcrest");
        } else if (homeGroundChoice == 2) {
            newUser = new User(name, userName, "Marshland");
        } else if (homeGroundChoice == 3) {
            newUser = new User(name, userName, "Desert");
        } else {
            newUser = new User(name, userName, "Arcane");
        }

        // Set the current user to the new user
        setCurrentUser(newUser);

        // Prompt the user to enter their XP value
        int xp = 0;
        while (true) {
            System.out.print("\nEnter the XP value: ");
            try {
                xp = scanner.nextInt();
                // Check if the user's XP value is valid
                if (xp > 0) {
                    newUser.setXp(xp);
                    break; // Exit the loop if a valid XP value is entered
                } else {
                    System.out.println("Invalid input. Please enter a positive integer.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a positive integer.");
                scanner.next(); // Clear the invalid input from the scanner buffer
            }
        }

        // Prompt the user to enforce their army by selecting characters
        System.out.println("\nPerfect! You're on the verge of your first battle. Let's now enforce your army");
        System.out.println("Here's a detailed table about troops. Be mindful to choose only one character from each type\n");
        Table.displayTroopsTable();
        System.out.println("Embark on your journey by selecting characters from above categories\n");

        // Loop until the user's army is complete
        while (newUser.getArmy().size() < 5) {
            System.out.print("Provide a name to bring it to life: ");
            String characterName = scanner.next().toLowerCase();
            // Check the type of the character and add a new character of that type to the user's army for free
            if (archers.contains(characterName)) {
                newUser.addTroopFree(new Archer(characterName));
            } else if (knights.contains(characterName)) {
                newUser.addTroopFree(new Knight(characterName));
            } else if (mages.contains(characterName)) {
                newUser.addTroopFree(new Mage(characterName));
            } else if (healers.contains(characterName)) {
                newUser.addTroopFree(new Healer(characterName));
            } else if (mythicalCreatures.contains(characterName)) {
                newUser.addTroopFree(new MythicalCreature(characterName));
            } else {
                System.out.println("Enter a valid name!!");
            }
        }

        // Prompt the user to enter their coin amount
        int goldCoins = 0;
        while (true) {
            System.out.print("\nEnter the coin amount: ");
            try {
                goldCoins = scanner.nextInt();
                // Check if the user's coin amount is valid
                if (goldCoins > 0) {
                    newUser.setCoins(goldCoins-500);
                    break; // Exit the loop if a valid coin amount is entered
                } else {
                    System.out.println("Invalid input. Please enter a positive integer.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a positive integer.");
                scanner.next(); // Clear the invalid input from the scanner buffer
            }
        }

        // Once the user's army is complete, add the user's profile to the userList and save it to the file
        System.out.println("PERFECT!! Your legion is now complete");
        userList.add(newUser);
        setCurrentUser(newUser);
        saveUserList();
        System.out.println("\nWELCOME to the world of Mystic Mayhem" + "\nYou are all set to go\n");
        printUserData(newUser);
        System.out.println();
        printArmy(newUser);

        // Prompt the user to initiate a battle or return to the main menu
        System.out.println("\n" +
                "════════════════════\n" +
                "1. Initiate a Battle\n" +
                "2. Back to Main Menu\n" +
                "════════════════════");
        while (true) {
            try {
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        clearScreen();
                        initiateBattle();
                        saveUserList();
                        break;
                    case 2:
                        System.out.println("Returning to the main menu...\n");
                        displayMenu();
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please try again.");
                scanner.next();
            }
        }
    }

    /**
     * This method loads a user profile.
     */
    public void loadProfile() {
        // Flag to check if a valid username has been entered
        boolean validUsernameEntered = false;

        // Check if there are any users in the userList
        if (!userList.isEmpty()){
            // Loop until a valid username is entered
            while (!validUsernameEntered) {
                // Display all the available profiles
                System.out.println("Select a profile to load from below");
                for (User user : userList) {
                    System.out.print(user.getUserName() + "  " + Math.round(user.getXp()) + " Xp \n");
                }

                // Prompt the user to enter the username of the profile they want to load
                System.out.print("\nEnter the username of the profile you want to load: ");
                String userNameToLoad = scanner.next();

                // Loop through the userList to find the profile with the entered username
                for (User user : userList) {
                    // If the profile is found, load it and exit the loop
                    if (user.getUserName().equals(userNameToLoad)) {
                        System.out.println("\nProfile loaded successfully!\n");
                        setCurrentUser(user);
                        printUserData(user);
                        validUsernameEntered = true; // Valid username entered, exit the loop
                        break;
                    }
                }

                // If the profile is not found, display an error message and prompt the user to try again
                if (!validUsernameEntered) {
                    System.out.println("\nProfile with username '" + userNameToLoad + "' not found. Please try again.\n");
                }
            }
        } else {
            // If there are no users in the userList, display a message
            System.out.println("No users!");
        }

        // Wait for the user to press Enter before continuing
        waitForInput();

        // Display the main menu
        displayMenu();
    }

    /**
     * This method allows the user to change the characters in their army.
     */
    public void changeCharacters(User curretUser) {
        // Check if the current user is not null
        if (curretUser != null) {
            // Print the current user's army
            printArmy(curretUser);
            System.out.println();

            // Display the troops table
            Table.displayTroopsTable();

            // Prompt the user to choose the type of character to replace
            System.out.println("\nChoose replacing character type.\n" +
                    "1. Archer\n" +
                    "2. Knight\n" +
                    "3. Mage\n" +
                    "4. Healer\n" +
                    "5. Mythical Creature");

            try {
                // Get the user's choice for the character type
                int charactertype = scanner.nextInt();

                // Check if the user's choice is valid
                while (1 > charactertype || charactertype > 5) {
                    System.out.println("Select a number from 1 to 5\n");
                    changeCharacters(curretUser);
                }

                // Loop until a valid character name is entered
                while (true) {
                    // Prompt the user to enter the name of the character to replace the current character
                    System.out.print("Enter character name to replace with the current character: ");
                    String newCharacterName = scanner.next().toLowerCase().strip();

                    // Check the type of the character and replace the current character with a new character of that type
                    if (charactertype == 1) {
                        if (archers.contains(newCharacterName)) {
                            curretUser.replaceTroop(curretUser.getMyArmyMap().get("Archer"), new Archer(newCharacterName));
                            break;
                        }
                    } else if (charactertype == 2) {
                        if (knights.contains(newCharacterName)) {
                            curretUser.replaceTroop(curretUser.getMyArmyMap().get("Knight"), new Knight(newCharacterName));
                            break;
                        }
                    } else if (charactertype == 3) {
                        if (mages.contains(newCharacterName)) {
                            curretUser.replaceTroop(curretUser.getMyArmyMap().get("Mage"), new Mage(newCharacterName));
                            break;
                        }
                    } else if (charactertype == 4) {
                        if (healers.contains(newCharacterName)) {
                            curretUser.replaceTroop(curretUser.getMyArmyMap().get("Healer"), new Healer(newCharacterName));
                            break;
                        }
                    } else {
                        if (mythicalCreatures.contains(newCharacterName)) {
                            curretUser.replaceTroop(curretUser.getMyArmyMap().get("MythicalCreature"), new MythicalCreature(newCharacterName));
                            break;
                        }
                    }
                }

                // Save the updated userList
                saveUserList();

                // Wait for the user to press Enter before continuing
                waitForInput();

                // Display the main menu
                displayMenu();
            } catch (InputMismatchException e) {
                // If the user enters an invalid input, display an error message and prompt the user to try again
                System.out.println("Select a number from 1 to 5\n");
                scanner.next();
                changeCharacters(curretUser);
            }
        } else {
            // If the current user is null, display a message and prompt the user to create a new profile or load a profile
            System.out.println("You don't have an active profile yet\n"+
                    "Please create a new profile or load a profile to change troops\n");
            waitForInput();
            System.out.println("Directing back to Main Menu...\n");
            displayMenu();
        }
    }

    /**
     * This method allows the user to add equipment to their characters.
     */
    public void addEquipments() {
        System.out.println("You currently have: ");
        for (Character character : currentUser.getArmy()) {
            System.out.println("                 " + character.getName().toUpperCase() + " [" + character.getClass().getSimpleName() + "]" + " with " + character.armourCount + " armour and "
                    + character.artefactCount + " artefact");
        }
        System.out.println("Select the character to enforce with equipment\n");
        try {
            System.out.println("ARCHER [enter 1], KNIGHT [enter 2], MAGE [enter 3], HEALER [enter 4], MYTHICAL CREATURE [enter 5]: ");
            int choice = scanner.nextInt();
            System.out.println("\nDelve into the extensive selection of available equipment detailed below\n");
            Table.displayEquipmentTable();
            System.out.print("\nEnter the name of the equipment: ");
            String equipment = scanner.next().toLowerCase();
            Armour armour = null;
            Artefact artefact = null;

            if (armours.contains(equipment)) {
                armour = new Armour(equipment);
            } else if (artefacts.contains(equipment)) {
                artefact = new Artefact(equipment);
            } else {
                System.out.println("Equipment not found. Prompt Again ");
                addEquipments();
                return;
            }

            switch (choice) {
                case 1:
                    if (currentUser.addEquipment(currentUser.getMyArmyMap().get("Archer"), armour != null ? armour : artefact)) {
                        System.out.println("Equipment added successfully.");
                    }
                    break;
                case 2:
                    if (currentUser.addEquipment(currentUser.getMyArmyMap().get("Knight"), armour != null ? armour : artefact)) {
                        System.out.println("Equipment added successfully.");
                    }
                    break;
                case 3:
                    if (currentUser.addEquipment(currentUser.getMyArmyMap().get("Mage"), armour != null ? armour : artefact)) {
                        System.out.println("Equipment added successfully.");
                    }
                    break;
                case 4:
                    if (currentUser.addEquipment(currentUser.getMyArmyMap().get("Healer"), armour != null ? armour : artefact)) {
                        System.out.println("Equipment added successfully.");
                    }
                    break;
                case 5:
                    if (currentUser.addEquipment(currentUser.getMyArmyMap().get("MythicalCreature"), armour != null ? armour : artefact)) {
                        System.out.println("Equipment added successfully.");
                    }
                    break;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }
            waitForInput();
            System.out.println("\nDirecting back to main menu...\n");
            saveUserList();
        } catch(InputMismatchException e){
            System.out.println("Invalid input!");
            scanner.next();
            addEquipments();// Clear the scanner buffer
        }
    }

    /**
     * This method returns the current user.
     */
    public User getCurrentUser() {
        return currentUser;
    }

    /**
     * This method sets the current user.
     */
    public void setCurrentUser(User user) {
        this.currentUser = user;
    }

    /**
     * This method prints the data of a user.
     */
    public void printUserData(User user) {
        try {
            System.out.println("═════PROFILE══════");
            System.out.println("Username: " + user.getUserName());
            System.out.println("UserID: " + user.getUserID());
            System.out.println("Coins: " + Math.round(user.getCoins()) + " gc");
            System.out.println("Battle Xp: " + Math.round(user.getXp()));
            System.out.println("══════════════════\n");
        } catch (NullPointerException e){
            System.out.println("Sorry you haven't created any profiles yet");
            displayMenu();
        }
    }

    /**
     * This method prints the details of a user in a war.
     */
    public void printUserDetailsinWar(User user) {
        clearScreen();
        try {
            System.out.println("═══════PROFILE═══════");
            System.out.println("Username: " + user.getUserName());
            System.out.println("XP: " + Math.round(user.getXp()));
            System.out.println("Characters:");
            int i = 1;
            for (Character character : user.getArmy()) {
                System.out.println("   " + i + ". " + character.getName().toUpperCase());
                i++;
            }
            System.out.println("╚═════════════════════╝");
        } catch (NullPointerException e){
            System.out.println("Please create or load a profile to view army\n");
            displayMenu();
        }
    }

    /**
     * This method prints the army of a user.
     */
    public void printArmy(User user) {
        System.out.println("️══ Your Legion ══");
        for (Character character : user.getArmy()) {
            String characterType = "";
            if (character instanceof Archer) {
                characterType = "Archer";
            } else if (character instanceof Knight) {
                characterType = "Knight";
            } else if (character instanceof Mage) {
                characterType = "Mage";
            } else if (character instanceof Healer) {
                characterType = "Healer";
            } else if (character instanceof MythicalCreature) {
                characterType = "Mythical Creature";
            }

            System.out.println(characterType.toUpperCase() + ": " + character.getName().toUpperCase() +
                    " --> Price " + character.getPrice() + " | Attack " + character.getAttack() +
                    " | Defence " + character.getDefence() + " | Health " + character.getHealth() +
                    " | Speed " + character.getSpeed());
        }
        System.out.println();
    }

    /**
     * This method returns an opponent for the current user.
     */
    private User getOpponent() {
        if (userList.size() < 2) {
            System.out.println("There are not enough users to challenge. Please add more users.");
            return null;
        }

        List<User> availableOpponents = new ArrayList<>(userList);
        availableOpponents.remove(currentUser);

        if (availableOpponents.isEmpty()) {
            System.out.println("No available opponents to challenge.");
            return null;
        }

        Random random = new Random();
        User opponent = availableOpponents.get(random.nextInt(availableOpponents.size()));

        printUserDetailsinWar(opponent);

        while (true) {
            System.out.print("Challenge , Skip or Exit to Main Menu (C/S/E): ");
            String decision = scanner.next();
            System.out.println();
            if (decision.equalsIgnoreCase("c")) {
                challenger = opponent;
                return challenger;
            } else if (decision.equalsIgnoreCase("s")) {
                opponent = availableOpponents.get(random.nextInt(availableOpponents.size()));
                printUserDetailsinWar(opponent);
            } else if (decision.equalsIgnoreCase("e")) {
                displayMenu();
                return null;
            } else {
                System.out.println("Enter 'c' to challenge , 's' to skip or 'e' to exit to main menu");
            }
        }
    }

    /**
     * This method allows the user to reinforce their army.
     */
    public void reinforceArmy(){
        System.out.println("\n════════════════════\n" +
            "1. Replace Troops\n" +
            "2. GearUp Troops\n" +
            "3. Back to Main Menu\n" +
            "════════════════════");
        if (currentUser != null) {
            while (true) {
                try {
                    int choice = scanner.nextInt();
                    if (choice == 1 || choice == 2){
                        if (choice == 1) {
                            changeCharacters(currentUser);
                        } else {
                            addEquipments();
                        }
                        reinforceArmy();
                    } else if (choice == 3){
                        displayMenu();
                        break;
                    } else {
                        System.out.println("Invalid choice, choose a number from 1 to 3");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input, choose a number from 1 to 3");
                    scanner.next();
                }
            }
        }
        else {
            System.out.println("You don't have an active profile yet\n"+
                    "Please create a new profile or load a profile to change troops\n");
            System.out.println("Directing back to Main Menu...\n");
            displayMenu();
        }
        saveUserList();
    }

    /**
     * This method initiates a battle.
     */
    public void initiateBattle(){
        if (currentUser != null) {
            System.out.println("\n═════════════════════\n" +
                "1. Find a Battle\n" +
                "2. Back to Main Menu\n" +
                "═════════════════════");
            while (true) {
                try {
                    int choice = scanner.nextInt();
                    if (choice == 1) {
                        User opponent = getOpponent();
                        War war = new War(currentUser,opponent);
                        waitForInput();
                        displayMenu();
                        break;
                    } else if (choice == 2) {
                        displayMenu();
                        break;
                    } else {
                        System.out.println("\nInvalid choice, choose a number from 1 to 3");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("\nInvalid input, choose a number from 1 to 3");
                    scanner.next();
                }
            }
        }
        else {
            System.out.println("You don't have an active profile yet\n"+
                    "Please create a new profile or load a profile\n");
            System.out.println("Directing back to Main Menu...\n");
            displayMenu();
        }
        saveUserList();
    }

    /**
     * This method clears the screen.
     */
    public static void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (IOException | InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * This method waits for the user to press Enter to continue.
     */
    private void waitForInput() {
        System.out.println("Press Enter to continue...");
        try {
            System.in.read(); // Wait for user to press Enter
            return;
        } catch (IOException e) {
            System.out.println("Error reading input");
            return;
        }
    }
}
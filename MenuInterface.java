public interface MenuInterface{
    // Method to display the menu options
    void displayMenu();

    // Method to save the user list
    void saveUserList();

    // Method to load the user list
    void loadFile();

    // Method to change characters in the current user's army
    void changeCharacters(User currentUser);

    // Method to load a user profile
    void loadProfile();

    // Method to add equipment to characters in the current user's army
    void addEquipments();

    // Method to initiate a battle
    void initiateBattle();

    // Method to reinforce the current user's army
    void reinforceArmy();

    // Method to print user data
    void printUserData(User user);

    // Method to print user details during a war
    void printUserDetailsinWar(User user);

    // Method to print the current user's army
    void printArmy(User user);

    // Method to get the current user
    User getCurrentUser();

    // Method to set the current user
    void setCurrentUser(User user);
}
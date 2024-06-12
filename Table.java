public class Table {

    public static void displayTroopsTable() {
        String[] creatures = {"Archers", "Knights", "Mages", "Healers", "Mythical Creatures"};

        String[] name1 = {"Shooter", "Squire", "Warlock", "Soother", "Dragon"};
        String[] price1 = {"80 gc", "85 gc", "100 gc", "95 gc", "120 gc"};
        String[] attack1 = {"11", "8", "12", "10", "12"};
        String[] defense1 = {"4", "9", "7", "8", "14"};
        String[] health1 = {"6", "7", "10", "9", "15"};
        String[] speed1 = {"9", "8", "12", "6", "8"};

        String[] name2 = {"Ranger", "Cavalier", "Illusionist", "Medic", "Basilisk"};
        String[] price2 = {"115 gc", "110 gc", "120 gc", "125 gc", "165 gc"};
        String[] attack2 = {"14", "10", "13", "12", "15"};
        String[] defense2 = {"5", "12", "8", "9", "11"};
        String[] health2 = {"8", "7", "12", "10", "10"};
        String[] speed2 = {"10", "10", "14", "7", "12"};

        String[] name3 = {"Sunfire", "Templar", "Enchanter", "Alchemist", "Hydra"};
        String[] price3 = {"160 gc", "155 gc", "160 gc", "150 gc", "205 gc"};
        String[] attack3 = {"15", "14", "16", "13", "12"};
        String[] defense3 = {"5", "16", "10", "13", "16"};
        String[] health3 = {"7", "12", "13", "13", "15"};
        String[] speed3 = {"14", "12", "16", "13", "11"};

        String[] name4 = {"Zing", "Zoro", "Conjurer", "Saint", "Phoenix"};
        String[] price4 = {"200 gc", "180 gc", "195 gc", "200 gc", "275 gc"};
        String[] attack4 = {"16", "17", "18", "16", "17"};
        String[] defense4 = {"9", "16", "15", "14", "13"};
        String[] health4 = {"11", "13", "14", "17", "17"};
        String[] speed4 = {"14", "14", "12", "9", "19"};

        String[] name5 = {"Saggitarius", "Swiftblade", "Eldritch", "Lightbringer", "Pegasus"};
        String[] price5 = {"230 gc", "250 gc", "270 gc", "260 gc", "340 gc"};
        String[] attack5 = {"18", "18", "19", "17", "14"};
        String[] defense5 = {"7", "20", "17", "15", "18"};
        String[] health5 = {"12", "17", "18", "19", "20"};
        String[] speed5 = {"17", "13", "14", "12", "20"};

        // Print table header
        System.out.println("══════════════════════════════════════════════════════════════════════════════════════");
        System.out.printf("%-15s %-15s %-15s %-15s %-15s %-15s\n", "Name", "Price", "Attack", "Defense", "Health", "Speed");
        System.out.println("══════════════════════════════════════════════════════════════════════════════════════");
        for (int i = 0; i <= 4; i++) {
            System.out.println(creatures[i]);
            System.out.println("-----------");
            System.out.printf("%-15s %-15s %-15s %-15s %-15s %-15s\n", name1[i], price1[i], attack1[i], defense1[i], health1[i], speed1[i]);
            System.out.printf("%-15s %-15s %-15s %-15s %-15s %-15s\n", name2[i], price2[i], attack2[i], defense2[i], health2[i], speed2[i]);
            System.out.printf("%-15s %-15s %-15s %-15s %-15s %-15s\n", name3[i], price3[i], attack3[i], defense3[i], health3[i], speed3[i]);
            System.out.printf("%-15s %-15s %-15s %-15s %-15s %-15s\n", name4[i], price4[i], attack4[i], defense4[i], health4[i], speed4[i]);
            System.out.printf("%-15s %-15s %-15s %-15s %-15s %-15s\n", name5[i], price5[i], attack5[i], defense5[i], health5[i], speed5[i]);
            System.out.println("-------------------------------------------------------------------------------------");
        }
        System.out.println("══════════════════════════════════════════════════════════════════════════════════════");
    }

    public static void displayEquipmentTable() {
        String[] armourNames = {"Chainmail", "Regalia", "Fleece"};
        String[] armourPrices = {"70 gc", "105 gc", "150 gc"};
        String[] armourAttack = {"no change", "no change", "no change"};
        String[] armourDefense = {"+1", "+1", "+2"};
        String[] armourHealth = {"no change", "no change", "+1"};
        String[] armourSpeed = {"-1", "no change", "-1"};

        // Artefact data
        String[] artefactNames = {"Excalibur", "Amulet", "Crystal"};
        String[] artefactPrices = {"150 gc", "200 gc", "210 gc"};
        String[] artefactAttack = {"+2", "+1", "+2"};
        String[] artefactDefense = {"no change", "-1", "+1"};
        String[] artefactHealth = {"no change", "+1", "-1"};
        String[] artefactSpeed = {"no change", "no change", "-1"};

        // Print table header
        System.out.println("══════════════════════════════════════════════════════════════════════════════════════");
        System.out.printf("%-12s %-12s %-12s %-12s %-12s %-12s %-12s\n", "", "Name", "Price", "Attack", "Defense", "Health", "Speed");
        System.out.println("══════════════════════════════════════════════════════════════════════════════════════");

        // Print Armour data
        System.out.println("Armour:");
        for (int i = 0; i < armourNames.length; i++) {
            System.out.printf("%-12s %-12s %-12s %-12s %-12s %-12s %-12s\n", "", armourNames[i], armourPrices[i], armourAttack[i], armourDefense[i], armourHealth[i], armourSpeed[i]);
        }
        System.out.println("----------------------------------------------------------------------------------------");

        // Print Artefact data
        System.out.println("Artefacts:");
        for (int i = 0; i < artefactNames.length; i++) {
            System.out.printf("%-12s %-12s %-12s %-12s %-12s %-12s %-12s\n", "", artefactNames[i], artefactPrices[i], artefactAttack[i], artefactDefense[i], artefactHealth[i], artefactSpeed[i]);
        }
        System.out.println("----------------------------------------------------------------------------------------");
    }

}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poerandomizer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Manny
 */
public class PoeRandomizer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {

        final int NUMBER_OF_SKILLS = 85;
        final String filename = "resources/skillgems.poe";
        final String[] skillGems = new String[NUMBER_OF_SKILLS];
        Scanner input = new Scanner(System.in);
        String inputReader = "";

        // Read in all of the names - there are 2000 different names
        try {
            Scanner fin = new Scanner(new File(filename));
            for (int i = 0; i < NUMBER_OF_SKILLS; i++) {
                skillGems[i] = fin.nextLine();
            }
            fin.close();
        } catch (FileNotFoundException e) {
            System.out.println("Exception caught: " + e.getMessage());
            System.exit(-1);
        }

        String classes[] = {"Witch", "Scion", "Templar", "Shadow", "Marauder", "Duelist"};

        int firstCase = 0;

        System.out.println("****************************************");
        System.out.println("*************POE RANDOMIZER*************");
        System.out.println("****************************************");
        System.out.println("Let the fun begin! - Created By Path Of Exile Player: HanMandler");
        while (true) {

            Random randomClass = new Random();
            Random randomSkill = new Random();

            int classIndex = randomClass.nextInt(6);
            int skillIndex = randomSkill.nextInt(85);

            if (firstCase <= 0) {
                System.out.println("\nYour class is : " + classes[classIndex]);
                System.out.println("Your skill gem of choice is : " + skillGems[skillIndex]);
                System.out.print("Would you like another spin [Y]es [N]o: ");
                inputReader = input.nextLine();
            }

            if (firstCase > 0) {
                System.out.print("Would you like another spin [Y]es [N]o: ");
                inputReader = input.nextLine();
            }

            firstCase++;

            if ("N".equals(inputReader.toUpperCase())) {
                /**
                 * Leave the loop when I press X
                 */
                break;

            } else if ("Y".equals(inputReader.toUpperCase())) {

                classIndex = randomClass.nextInt(6);
                skillIndex = randomSkill.nextInt(85);

                System.out.println("\nYour class is : " + classes[classIndex]);
                System.out.println("Your skill gem of choice is : " + skillGems[skillIndex]);

            } else {
                System.out.println("Sorry could not read your input please try again");

            }

            firstCase++;
        }

    }
}

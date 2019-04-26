import java.util.Scanner;

/**
 * Seperate Pokemon maker class for a Pokedex function.
 * @author Matthew Marabellas
 * @since 4/25/2019
 */
public class MakePokemon
{
   /**
	 * makeChoice method.
    * Listens for the user input.
	 * @return returns an integer for use in selecting the pokemon to make.
	 */
   public static int makeChoice()
   {
      Scanner userIn = new Scanner(System.in);
      boolean endLoop = false;
      String inString = new String("");
      int choice = 0;
      
      while (!endLoop)
      {
      	//Menu text
         printMenuChoice();
      	//Read input from the user as a String and trim it.
         inString = userIn.nextLine();
         inString = inString.trim();
         
      	//Convert String to int.
         try
         {
            choice = Integer.parseInt(inString);
         }
         catch (NumberFormatException nfe)
         {
            choice = 0;
         }
         //If it is not an String, set to 0 and ask user for number input.
         if (choice > 0 && choice <= 9)
         {
            endLoop = true;
         }     
      }
      return choice;
   }
	/**
    * printMenuChoice method prints the menu for the user.
    */
   public static void printMenuChoice()
   {
      System.out.println("Choose a Pokemon to add:");
      System.out.println("1 for Bulbasaur");
      System.out.println("2 for Ivysaur");
      System.out.println("3 for Venusaur");
      System.out.println("4 for Charmander");
      System.out.println("5 for Charmeleon");
      System.out.println("6 for Charizard");
      System.out.println("7 for Squirtle");
      System.out.println("8 for Wartortle");
      System.out.println("9 for Blastoise");
   }
   
	/**
    * Pokemon picker method.
    * My eyes are burning but this lets you pick a pokemon.
    */
   public static Pokemon pickAPokemon() {
      Pokemon chosenPokemon; 
      Integer choice = makeChoice();
      String name = getName();
      chosenPokemon = createPokemon(choice, name);
      return chosenPokemon;
   }
   
	/**
	 * getName method.
    * Listens for user input to get the pokemon name.
	 * @return user's pokemon name as String.
	 */
   public static String getName() {
      String hasNameInput = "";
      Scanner userIn = new Scanner(System.in);
      System.out.println("Does the Pokemon have a name Y/N?");
      hasNameInput = userIn.nextLine();
      String name = "";
   
      if (hasNameInput.equals("Y")) {
         System.out.println("What is the Pokemon's name?");
         name =  userIn.nextLine();
      }
      return name;
   }

	/**
	 * createPokemon method.
    * Creates the Pokemon appropriately to the users preference.
	 * @param choice an int choice from menu
	 * @param name is a String that can be empty.
	 * @return the Pokemon the user made.
	 */
   public static Pokemon createPokemon(Integer choice, String name) {
      boolean hasName = name.length() > 0;
      Pokemon newPokemon;
   
      switch(choice) {
         //Bulbasaur
         case 1:
            if (hasName) {
               newPokemon = new Bulbasaur(name);
            } else {
               newPokemon = new Bulbasaur();
            }
            break;
         //Ivysaur
         case 2:
            if (hasName) {
               newPokemon = new Ivysaur(name);
            } else {
               newPokemon = new Ivysaur();
            }
            break;
         //Venusaur
         case 3:
            if (hasName) {
               newPokemon = new Venusaur(name);
            } else {
               newPokemon = new Venusaur();
            }
            break;
         //Charmander
         case 4:
            if (hasName) {
               newPokemon = new Charmander(name);
            } else {
               newPokemon = new Charmander();
            }
            break;
         //Charmeleon
         case 5:
            if (hasName) {
               newPokemon = new Charmeleon(name);
            } else {
               newPokemon = new Charmeleon();
            }
            break;
         //Charizard
         case 6:
            if (hasName) {
               newPokemon = new Charizard(name);
            } else {
               newPokemon = new Charizard();
            }
            break;
         //Squirtle
         case 7:
            if (hasName) {
               newPokemon = new Squirtle(name);
            } else {
               newPokemon = new Squirtle();
            }
            break;
         //Wartortle
         case 8:
            if (hasName) {
               newPokemon = new Wartortle(name);
            } else {
               newPokemon = new Wartortle();
            }
            break;
         //Blastoise
         case 9:
            if (hasName) {
               newPokemon = new Blastoise(name);
            } else {
               newPokemon = new Blastoise();
            }
            break;
         //Default case.
         default: 
            return null;
      }
      return newPokemon;
   }
}
import java.util.Scanner;

/**
 * Main Driver Program for the PokeTree/Node/Dex Environment.
 * @author Matthew Marabellas
 * @param args used in command line.
 * @since 4/25/2019
 */
public class Pokedex
{
   //Create the PokeTree.
   private static PokeTree tree = new PokeTree();
   
   /**
    * Main method for program operations.
    * Allows user to pick a pokemon for use in Pokedex.
    * @param args used in command line.
    */
   public static void main(String[] args)
   {
      //Greeter.
      System.out.println("Pokedex handler program by Matthew Marabellas");
      
      //Set up a scanner for user input.
      Scanner userIn = new Scanner(System.in);
      String inString = new String("");
      boolean mainMenuLoop = false;
      
      //Loop until stop condition is given.
      while (!mainMenuLoop)
      {
         //Print menu to user.
         System.out.println("\nPlease enter the number of your choice:");
         System.out.println("1 - Catch a Pokemon");
         System.out.println("2 - Trade your Pokemon");
         System.out.println("3 - Display your Pokedex");
         System.out.println("4 - Quit the program");
         System.out.print("What would you like to do: ");
      
         //Read and store user input appropriately as inString.
         inString = userIn.nextLine();
         inString = inString.trim();
         
         //Switch for main menu input.
         switch(inString)
         {
            //User decides to catch a Pokemon.
            case "1":
               //Add the made Pokemon to the tree.
               tree.add(MakePokemon.pickAPokemon());
               break;
                              
            //User decides to trade their Pokemon.
            case "2":
               Pokemon t = MakePokemon.pickAPokemon();
               try
               {
                  tree.remove(t);
               }
               catch (PokemonException e)
               {
                  System.out.println("Pokemon does not exist in tree!");
               }
               break;
               
            //User decides to display their Pokedex.
            case "3":
               System.out.println("-------------------------");
               tree.inOrderPrint();
               System.out.println("-------------------------");
               break;
               
            //User decides to exit program.
            case "4":
               mainMenuLoop = true;
               System.out.println("\nGood bye!");
               break;
            
            //User has entered an invalid menu choice.
            default:
               System.out.print("\n****Invalid input");
               System.out.println(", please try again.****");
               break;
         }
      }
   }
}
/**
 * Wartortle Pokemon object class.
 * Subclass of Squirtle
 * @author Matthew Marabellas
 * @version 2.0
 * @since 3/5/2019
 */
public class Wartortle extends Squirtle
{
   /** The minimumm attack power for species. */
   static final int BASE_ATTACK_POWER = 144;
   /** The minimum defense power for species. */
   static final int BASE_DEFENSE_POWER = 176;
   /** The minimum stanimia power for species. */
   static final int BASE_STANIMA_POWER = 118;
   
   /**
    * Constructor with no name.
    */
   public Wartortle()
   {
      super("Wartortle", "Wartortle", 8, 1.0, 22.5, BASE_ATTACK_POWER,
         BASE_DEFENSE_POWER, BASE_STANIMA_POWER);
   }
   
   /**
    * Constructor with name.
    * @param name The user-defined name.
    */
   public Wartortle(String name)
   {
      super("Wartortle", name, 8, 1.0, 22.5, BASE_ATTACK_POWER,
         BASE_DEFENSE_POWER, BASE_STANIMA_POWER);
   }
   
   /**
    * Constructor with species and name for subclasses.
    * @param species The Pokemon's species.
    * @param name The user-defined name.
    * @param num The Pokedex number for this species.
    * @param ht The height of this Pokemon.
    * @param wt The weight of this Pokemon.
    * @param baseAttackPwr The low limit of Attack Power for Species.
    * @param baseDefensePwr The low limit of Defense Power for Species.
    * @param baseStanimaPwr The low limit of Stanima Power for Species.
    */
   protected Wartortle(String species, String name, int num, double ht,
       double wt, int baseAttackPwr, int baseDefensePwr, int baseStanimaPwr)
   {
      super(species, name, num, ht, wt, baseAttackPwr,
         baseDefensePwr, baseStanimaPwr);
   }
}
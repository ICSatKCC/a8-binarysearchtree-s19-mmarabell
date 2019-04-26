/**
 * Blastoise Pokemon object class.
 * Subclass of Wartortle
 * @author Matthew Marabellas
 * @version 2.0
 * @since 3/5/2019
 */
public class Blastoise extends Wartortle
{
   /** The minimumm attack power for species. */
   static final int BASE_ATTACK_POWER = 186;
   /** The minimum defense power for species. */
   static final int BASE_DEFENSE_POWER = 222;
   /** The minimum stanimia power for species. */
   static final int BASE_STANIMA_POWER = 158;
   
   /**
    * Constructor with no name.
    */
   public Blastoise()
   {
      super("Blastoise", "Blastoise", 9, 1.6, 85.5, BASE_ATTACK_POWER,
         BASE_DEFENSE_POWER, BASE_STANIMA_POWER);
   }
   
   /**
    * Constructor with name.
    * @param name The user-defined name.
    */
   public Blastoise(String name)
   {
      super("Blastoise", name, 9, 1.6, 85.5, BASE_ATTACK_POWER,
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
   protected Blastoise(String species, String name, int num, double ht,
       double wt, int baseAttackPwr, int baseDefensePwr, int baseStanimaPwr)
   {
      super(species, name, num, ht, wt, baseAttackPwr,
         baseDefensePwr, baseStanimaPwr);
   }
}
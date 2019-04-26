import java.util.Random;
/**
 * Squirtle Pokemon object class.
 * Single-type Water implements one type interface
 * Parent class to Wartortle
 * @author Matthew Marabellas
 * @version 2.0
 * @since 3/5/2019
 */

public class Squirtle extends Pokemon implements WaterType
{
   /** The minimumm attack power for species. */
   static final int BASE_ATTACK_POWER = 112;
   /** The minimum defense power for species. */
   static final int BASE_DEFENSE_POWER = 142;
   /** The minimum stanimia power for species. */
   static final int BASE_STANIMA_POWER = 88;
   
   /** Indicator for fast attack type. */
   protected boolean fastIsWater = true;
   /** Indicator for special attack type. */
   protected boolean specialIsWater = true;
   
   /**
    * Constructor with no name.
    * Uses Pokemon superclass constructor.
    * Attacks must be set after construction
    * of Pokemon Object because of dependence
    * on type interface.
    */
   public Squirtle()
   {
      super("Squirtle", "Squirtle", 7, WATER_COLOR, 0.5, 9.0,
         WATER_TYPE, "", BASE_ATTACK_POWER,
         BASE_DEFENSE_POWER, BASE_STANIMA_POWER);
      chooseFastAttack();
      chooseSpecialAttack();
   }
   
   /**
    * Constructor with name.
    * Uses Pokemon superclass constructor.
    * Attacks must be set after construction of Pokemon Object
    * because of dependence on type interface.
    * @param name The user - defined name.
    */
   public Squirtle(String name)
   {
      super("Squirtle", name, 7, WATER_COLOR, 0.5, 9.0,
         WATER_TYPE, "", BASE_ATTACK_POWER,
         BASE_DEFENSE_POWER, BASE_STANIMA_POWER);
      chooseFastAttack();
      chooseSpecialAttack();
   }
   
   /**
    * Constructor with species and name for subclasses.
    * @param species The Pokemon's species.
    * @param name The user - defined name.
    * @param num The Pokedex number for this species.
    * @param ht The height of this Pokemon.
    * @param wt The weight of this Pokemon.
    * @param baseAttackPwr The low limit of Attack Power for Species.
    * @param baseDefensePwr The low limit of Defense Power for Species.
    * @param baseStanimaPwr The low limit of Stanima Power for Species.
    */
   protected Squirtle(String species, String name, int num,
       double ht, double wt, int baseAttackPwr, int baseDefensePwr,
       int baseStanimaPwr)
   {
      super(species, name, num, WATER_COLOR, ht, wt, WATER_TYPE,
          "", baseAttackPwr, baseDefensePwr, baseStanimaPwr);
      chooseFastAttack();
      chooseSpecialAttack();
   }
   
   /**
    * Water-type specific fast attack chooser.
    * Randomly picks an attack from type attack arrays.
    */
   protected void chooseFastAttack()
   {
      Random randGen = new Random();
      int index;
      fastIsWater = randGen.nextBoolean();
      index = randGen.nextInt(WATER_FAST_ATTACKS.length);
      fastAttack = WATER_FAST_ATTACKS[index];
      fastAttackPower = WATER_FAST_ATK_POWER[index];
   }
   
   /**
    * Water-type specific special attack chooser.
    * Randomly picks an attack from type interface attack arrays.
    */
   protected void chooseSpecialAttack()
   {
      Random randGen = new Random();
      int index;
      specialIsWater = randGen.nextBoolean();
      index = randGen.nextInt(WATER_SPECIAL_ATTACKS.length);
      specialAttack = WATER_SPECIAL_ATTACKS[index];
      specialAttackPower = WATER_SPECIAL_ATK_POWER[index];
   }
   
   /**
    * Gameplay fast attack simulation.
    * Creates an output String stating attack details.
    * Checks for weakness/strength adjustment based on
    * victim Pokemon's type and attack type.
    * Calls beAttacked method on attacked victims.
    * @param victim The Pokemon being attacked.
    * @return String Explaining attack and effectiveness.
    */
   public String performFastAttack(Pokemon victim)
   {
      Random rand = new Random();
      double damage = 0.0;
      double modifier = 1.0;
      double damageDivisor = 250.0;
      
      String s = "";
      String vType = victim.getType1();
      
      //Random modifier .85 - 1.00
      modifier = (double) (rand.nextInt(16) + 85) / 100.0;
      s = name + " performed " + fastAttack + " on " + victim.getSpecies();
      
      //Checks effectiveness of attack
      if (vType.equals("Fire") || vType.equals("Ground")
          || vType.equals("Rock"))
      {
         s = s + "\n It was super effective!";
         modifier = modifier * 2.0;
      }
      
      else if (vType.equals("Grass") || vType.equals("Dragon"))
      {
         s = s + "\n It was not very effective.";
         modifier = modifier * 0.5;
      }
      
      //Checks for same types for bonus
      if (type1.equals(vType) && type2.equals(victim.getType2()))
      {
         s = s + "\n It was not very effective.";
         modifier = modifier * 1.5;
      }
      
      //Bulbapedia damage formula:
      damage = (((2 * level) + 10 / damageDivisor)
         * attackPower * (specialAttackPower + 2)) * modifier;
      victim.beAttacked((int) damage);
      return s;
   }
   
   /**
    * Gameplay special attack simulation.
    * Creates an output String stating attack details.
    * Check for weakness/strength adjustment based on
    * victim Pokemon's type and attack type.
    * Uses damage formula from:
    * http://bulbapedia.bulbagarden.net/wiki/Damage
    * Calls beAttacked method on attacked victim.
    * @param victim the Pokemon being attacked.
    * @return String Explaining attack and effectiveness.
   */
   public String performSpecialAttack(Pokemon victim)
   {
      Random rand = new Random();
      double damage = 0.0;
      double modifier = 1.0;
      double damageDivisor = 250.0;
      
      String s = "";
      String vType = victim.getType1();
      
      //Random modifier .85 - 1.00
      modifier = (double) (rand.nextInt(16) + 85) / 100.0;
      s = name + " performed " + specialAttack + " on " + victim.getSpecies();
      
      //Checks effectiveness of attack
      if (vType.equals("Fire") || vType.equals("Ground")
          || vType.equals("Rock"))
      {
         s = s + "\n It was super effective!";
         modifier = modifier * 2.0;
      }
      else if (vType.equals("Grass") || vType.equals("Dragon"))
      {
         s = s + "\n It was not very effective.";
         modifier = modifier * 0.5;
      }
      
      //Checks for same types for bonus
      if (type1.equals(vType) && type2.equals(victim.getType2()))
      {
         s = s + "\n It was not very effective.";
         modifier = modifier * 1.5;
      }
      
      //Bulbapedia damage formula:
      damage = (((2 * level) + 10 / damageDivisor)
         * attackPower * (specialAttackPower + 2)) * modifier;
      victim.beAttacked((int) damage);
      return s;
   }
   
   /**
    * Reduces Pokemon's HP by damage/defensePower.
    * Doesn't allow HP to go less than 0.
    * @param damage Hit points to take off HP.
    */
   protected void beAttacked(int damage)
   {
      damage = damage / defensePower;
      if (hP > damage)
      {
         hP = hP - damage;
      }
      else
      {
         hP = 0;
      }
   }
}
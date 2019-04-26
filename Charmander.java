import java.util.Random;
/**
 * Charmander Pokemon object class.
 * Single-type Fire implements one type interface
 * Parent class to Charmeleon & Charizard
 * @author Matthew Marabellas
 * @version 2.0
 * @since 3/5/2019
 */

public class Charmander extends Pokemon implements FireType, FlyingType
{
   /** The minimumm attack power for species. */
   static final int BASE_ATTACK_POWER = 126;
   /** The minimum defense power for species. */
   static final int BASE_DEFENSE_POWER = 126;
   /** The minimum stanimia power for species. */
   static final int BASE_STANIMA_POWER = 90;
   
   /** Indicator for fast attack type. */
   protected boolean fastIsFire = true;
   /** Indicator for special attack type. */
   protected boolean specialIsFire = true;
   
   /**
    * Constructor with no name.
    * Uses Pokemon superclass constructor.
    * Attacks must be set after construction
    * of Pokemon Object because of dependence
    * on type interface.
    */
   public Charmander()
   {
      super("Charmander", "Charmander", 4, FIRE_COLOR, 0.6, 8.5,
         FIRE_TYPE, "", BASE_ATTACK_POWER,
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
   public Charmander(String name)
   {
      super("Charmander", name, 4, FIRE_COLOR, 0.6, 8.5,
         FIRE_TYPE, "", BASE_ATTACK_POWER,
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
   protected Charmander(String species, String name, int num,
       double ht, double wt, int baseAttackPwr, int baseDefensePwr,
       int baseStanimaPwr)
   {
      super(species, name, num, FIRE_COLOR, ht, wt, FIRE_TYPE,
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
      fastIsFire = randGen.nextBoolean();
      index = randGen.nextInt(FIRE_FAST_ATTACKS.length);
      fastAttack = FIRE_FAST_ATTACKS[index];
      fastAttackPower = FIRE_FAST_ATK_POWER[index];
   }
   
   /**
    * Fire-specific special attack chooser.
    * Randomly picks an attack from type interface attack arrays.
    */
   protected void chooseSpecialAttack()
   {
      Random randGen = new Random();
      int index;
      specialIsFire = randGen.nextBoolean();
      index = randGen.nextInt(FIRE_SPECIAL_ATTACKS.length);
      specialAttack = FIRE_SPECIAL_ATTACKS[index];
      specialAttackPower = FIRE_SPECIAL_ATK_POWER[index];
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
      if (vType.equals("Grass") || vType.equals("Ice")
          || vType.equals("Bug") || vType.equals("Steel"))
      {
         s = s  +  "\n It was super effective!";
         modifier = modifier * 2.0;
      }
      else if (vType.equals("Fire") || vType.equals("Water")
          || vType.equals("Rock") || vType.equals("Dragon"))
      {
         s = s  +  "\n It was not very effective.";
         modifier = modifier * 0.5;
      }
   
      //Checks for same types for bonus
      if (type1.equals(vType) && type2.equals(victim.getType2()))
      {
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
      
      //Checks effectivness of attack
      if (vType.equals("Grass") || vType.equals("Ice")
          || vType.equals("Bug") || vType.equals("Steel"))
      {
         s = s  +  "\n It was super effective!";
         modifier = modifier * 2.0;
      }
      else if (vType.equals("Fire") || vType.equals("Water")
          || vType.equals("Rock") || vType.equals("Dragon"))
      {
         s = s  +  "\n It was not very effective.";
         modifier = modifier * 0.5;
      }
      
      //Checks for same types for bonus
      if (type1.equals(vType) && type2.equals(victim.getType2()))
      {
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
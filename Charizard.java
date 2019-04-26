import java.util.Random;
/**
 * Charizard Pokemon object class.
 * Subclass of Charmander
 * @author Matthew Marabellas
 * @version 2.0
 * @since 3/5/2019
 */
public class Charizard extends Charmander implements FlyingType
{
   /** The minimumm attack power for species. */
   static final int BASE_ATTACK_POWER = 212;
   /** The minimum defense power for species. */
   static final int BASE_DEFENSE_POWER = 182;
   /** The minimum stanimia power for species. */
   static final int BASE_STANIMA_POWER = 156;
   
   /** Indicator for fast attack type. */
   protected boolean fastIsFire = true;
   /** Indicator for special attack type. */
   protected boolean specialIsFire = true;
   
   /**
    * Constructor with no name.
    */
   public Charizard()
   {
      super("Charizard", "Charizard", 6, 1.7, 90.5, BASE_ATTACK_POWER,
         BASE_DEFENSE_POWER, BASE_STANIMA_POWER);
      type2 = FLYING_TYPE;
      chooseFastAttack();
      chooseSpecialAttack();
   }
   
   /**
    * Constructor with name.
    * @param name The user-defined name.
    */
   public Charizard(String name)
   {
      super("Charizard", name, 6, 1.7, 90.5, BASE_ATTACK_POWER,
         BASE_DEFENSE_POWER, BASE_STANIMA_POWER);
      type2 = FLYING_TYPE;
      chooseFastAttack();
      chooseSpecialAttack();
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
   protected Charizard(String species, String name, int num, double ht,
       double wt, int baseAttackPwr, int baseDefensePwr, int baseStanimaPwr)
   {
      super(species, name, num, ht, wt, baseAttackPwr,
         baseDefensePwr, baseStanimaPwr);
      type2 = FLYING_TYPE;
      chooseFastAttack();
      chooseSpecialAttack();
   }
   
  /**
   * Fire|Flying-type specific fast attack chooser.
   * Randomly picks whether attack type is Fire or Flying.
   * Randomly picks an attack from type attack arrays.
   */
   protected void chooseFastAttack()
   {
      Random randGen = new Random();
      int index;
      fastIsFire = randGen.nextBoolean();
      
      if (fastIsFire)
      {
         index = randGen.nextInt(FIRE_FAST_ATTACKS.length);
         fastAttack = FIRE_FAST_ATTACKS[index];
         fastAttackPower = FIRE_FAST_ATK_POWER[index];
      }
      else
      {
         index = randGen.nextInt(FLYING_FAST_ATTACKS.length);
         fastAttack = FLYING_FAST_ATTACKS[index];
         fastAttackPower = FLYING_FAST_ATK_POWER[index];
         fastIsFire = false;
      }
   }
   
  /**
   * Fire|Flying-type specific fast attack chooser.
   * Randomly picks whether attack type is Fire or Flying.
   * Randomly picks an attack from type interface attack arrays
   */
   protected void chooseSpecialAttack()
   {
      Random randGen = new Random();
      int index;
      specialIsFire = randGen.nextBoolean();
      
      if (specialIsFire)
      {
         index = randGen.nextInt(FIRE_SPECIAL_ATTACKS.length);
         specialAttack = FIRE_SPECIAL_ATTACKS[index];
         specialAttackPower = FIRE_SPECIAL_ATK_POWER[index];
      }
      else
      {
         index = randGen.nextInt(FLYING_SPECIAL_ATTACKS.length);
         fastAttack = FLYING_SPECIAL_ATTACKS[index];
         fastAttackPower = FLYING_SPECIAL_ATK_POWER[index];
         specialIsFire = false;
      }
   }
   
  /**
   * Game-play fast attack simulation.
   * Creates an output String stating attack details
   * checks for weakness/strength adjustment based on 
   * victim Pokemon's type and attack type
   * (only need to check latter for dual-type)
   * Calls beAttacked method on attacked victim.
   *
   * @param victim the Pokemon being attacked
   * @return String explaining attack and effectiveness
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
      if (fastIsFire)
      {
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
      }
      else
      {
         if (vType.equals("Grass") || vType.equals("Fighting")
             || vType.equals("Bug"))
         {
            s = s  +  "\n It was super effective!";
            modifier = modifier * 2.0;
         }
         else if (vType.equals("Electric") || vType.equals("Rock")
             || vType.equals("Steel"))
         {
            s = s  +  "\n It was not very effective.";
            modifier = modifier * 0.5;
         }
      }
      
      //Checks for same types for bonus
      if (type1.equals(vType) && type2.equals(victim.getType2()))
      {
         modifier = modifier * 1.5;
      }
      
      //Bulbapedia damage formula:
      damage = (((2 * level) + 10 / damageDivisor) * attackPower
         * (specialAttackPower + 2)) * modifier;
      victim.beAttacked((int) damage);
      return s;
   }
   
   /**
   * Game-play special attack simulation.
   * Creates an output String stating attack details
   * checks for weakness/strength adjustment based on 
   * victim Pokemon's type and attack type
   * (only need to check latter for dual-type)
   * uses Damage formula from here: 
   * http://bulbapedia.bulbagarden.net/wiki/Damage
   * Calls beAttacked method on attacked victim.
   * @param victim the Pokemon being attacked.
   * @return String explaining attack and effectiveness.
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
      
      //Check effectiveness of attack
      if (specialIsFire)
      {
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
      }
      else
      {
         if (vType.equals("Grass") || vType.equals("Fighting")
             || vType.equals("Bug"))
         {
            s = s  +  "\n It was super effective!";
            modifier = modifier * 2.0;
         }
         else if (vType.equals("Electric") || vType.equals("Rock")
             || vType.equals("Steel"))
         {
            s = s  +  "\n It was not very effective.";
            modifier = modifier * 0.5;
         }
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
}
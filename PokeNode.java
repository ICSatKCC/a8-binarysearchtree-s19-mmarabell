/**
 * Generic class for a Pokemon node.
 * @author Matthew Marabellas
 * @param <E> The datatype held in Nodes.
 */
public class PokeNode<E> {
   /** Data held in Node. */
   private Pokemon pokeData;
   /** Integer for Key. */
   private int key;
   /** Counter for how many times a Pokemon species has been caught. */
   private int numCaught;
   /** Link to left child Node. */
   private PokeNode lChild;
   /** Link to right child Node. */
   private PokeNode rChild;
   
	/**
	 * Constructor for PokeNode.
	 * @param pokeData The variable to store the Pokemon object.
	 * @param numCaught The counter to record amount of caught.
	 * @param lChild The address of the left child.
	 * @param rChild The address of the right child.
    */
   public PokeNode(Pokemon pokeData, int numCaught, PokeNode lChild, 
       PokeNode rChild) {
      pokeData = new Squirtle();
      numCaught = 1;
      lChild = null;
      rChild = null;
   }
   
	/**
	 * Automatically called by println() or print() method.
	 * @return s containing item data.
	 */
   public String toString() {
      String s = pokeData.toString();
      return s;
   }
   
   /** Get Methods. */
	/**
    * Get Pokemon Method.
	 * @return Pokemon to user.
    */
   public Pokemon getPokemon() {
      return pokeData;
   }
	/**
    * Get Key Method.
	 * @return Key to user.
    */
   public int getKey() {
      return key;
   }
	/**
    * Get NumCaught Method.
	 * @return NumCaught to user.
    */
   public int getNumCaught() {
      return numCaught;
   }
	/**
    * Get Left Child Method.
	 * @return LChild to user.
    */
   public PokeNode getLChild() {
      return lChild;
   }
	/**
    * Get Right Child Method.
	 * @return RChild to user.
    */
   public PokeNode getRChild() {
      return rChild;
   }
   
   /** Set Methods. */
   /**
    * Set increaseNumCaught Method to increment current int.
    */
   public void increaseNumCaught() {
      numCaught++;
   }
   /**
    * Set decreaseNumCaught Method to decrement current int.
    */
   public void decreaseNumCaught() {
      if (numCaught < 1) {
         System.out.println("ERROR");
      }
      else {
         numCaught--;
      }
   }
   /**
    * Set setLChild Method.
    * @param newLChild set to LChild.
    */
   public void setLChild(PokeNode newLChild) {
      lChild = newLChild;
   }
   /**
    * Set setRChild Method.
    * @param newRChild set to LChild.
    */
   public void setRChild(PokeNode newRChild) {
      rChild = newRChild;
   }
}

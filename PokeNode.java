/**
 * Generic class for a Pokemon node.
 * @author Matthew Marabellas
 * @param <Pokemon> The datatype held in Nodes.
 * @since 4/20/2019
 */
public class PokeNode<Pokemon>
{
   /** Data held in Node. */
   private Pokemon pokeData;
   /** Integer for Key. */
   private int key;
   /** Counter for how many times a Pokemon species has been caught. */
   private int numCaught;
   /** Link to left child Node. */
   private PokeNode<Pokemon> lChild;
   /** Link to right child Node. */
   private PokeNode<Pokemon> rChild;
   
	/**
	 * Constructor for PokeNode.
	 * @param pChose The variable to store the Pokemon object.
	 * @param numCaught The counter to record amount of caught.
	 * @param lChild The address of the left child.
	 * @param rChild The address of the right child.
    */
   public PokeNode(Pokemon pChose, int numCaught, PokeNode<Pokemon> lChild, 
       PokeNode<Pokemon> rChild) {
      pokeData = pChose;
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
	 * @return PokeData to user.
    */
   public Pokemon getPokeData() {
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
    * Set PokeData as a called method when needed.
    */
   public void setPokeData(Pokemon pChose)
   {
      pokeData = pChose; 
   }
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
   public void setLChild(PokeNode<Pokemon> newLChild) {
      lChild = newLChild;
   }
   /**
    * Set setRChild Method.
    * @param newRChild set to LChild.
    */
   public void setRChild(PokeNode<Pokemon> newRChild) {
      rChild = newRChild;
   }
}

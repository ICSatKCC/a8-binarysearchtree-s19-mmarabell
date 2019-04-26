/**
 * Generic class for a Pokemon tree.
 * @author Matthew Marabellas
 * @param PokeTree<T> for Pokedex environment.
 * @param <T> Resembling the tree variable.
 * @since 4/24/2019
 */
public class PokeTree<T>
{
   /** Instance Variable for root node. */
   private PokeNode<Pokemon> root = null;
   /** Constructor with no parameter. */
   public PokeTree() { }
   
   /**
    * Adds an item to the tree.
    * Non-recursive wrapper method.
    * @param p the object to be added.
    */
   public void add(Pokemon p)
   {
      root = add(root, p);
   }
    
   /**
    * Recursively add item to the PokeTree.
    * @param node The root of the tree/subtree.
    * @param p The object to be added.
    * @return The current node.
    */
   private PokeNode<Pokemon> add(PokeNode<Pokemon> node, Pokemon p)
   {
      //If the tree is empty, start a new tree (Duh).
      if (node == null)
      {
         return new PokeNode<Pokemon>(p, 1, null, null);
      }
      //Otherwise duplicate the node and throw an exception.
      else if (p.compareTo(node.getPokeData()) == 0)
      {
         throw new PokemonException("Duplicate items is not allowed!!!");      
      }
      //Otherwise move child node to the left.
      else if (p.compareTo(node.getPokeData()) < 0)
      {
         node.setLChild(this.add(node.getLChild(), p));
         return node;
      }
      //Otherwise move the child node to the right.
      else
      {
         node.setRChild(this.add(node.getRChild(), p));
         return node;
      }
   }
   
   /**
    * inOrderPrint method to print tree.
    * @return the tree.
    */
   public String inOrderPrint()
   {
      return this.inOrder(root);
   }
   
   /**
    * inOrder method to display nodes in a ordered style.
    * @param node as the root of the tree.
    * @return nData showing the tree in the ordered style.
    */
   private String inOrder(PokeNode<Pokemon> node)
   {
      String nData = "";
      if (node != null)
      {
         nData = nData + this.inOrder(node.getLChild());
         nData = nData + node.toString() + "\n";
         nData = nData + this.inOrder(node.getRChild());
      }
      return nData;
   }
   
   /**
    * preOrderPrint method.
    * @return a pre order style of tree.
    */
   public String preOrderPrint()
   {
      return this.preOrder(root);
   }
   
   /**
    * preOrder method to display nodes in a pre order style.
    * @param node as the root of the tree.
    * @return nData showing the tree in the pre order style.
    */
   private String preOrder(PokeNode<Pokemon> node)
   {
      String nData = "";
      if (node != null)
      {
         nData = nData + node.toString() + "\n";
         nData = nData + this.preOrder(node.getLChild());
         nData = nData + this.preOrder(node.getRChild());
      }
      return nData;
   }
   
   /**
    * postOrderPrint method. 
    * @return a post order style of tree.
    */
   public String postOrderPrint()
   {
      return this.postOrder(root);
   }
   
   /**
    * postOrder method to display nodes in a post order style.
    * @param node as the root of the tree.
    * @return nData showing the tree in the post order style.
    */
   private String postOrder(PokeNode<Pokemon> node)
   {
      String nData = "";
      if (node != null)
      {
         nData = nData + this.preOrder(node.getLChild());
         nData = nData + this.preOrder(node.getRChild());
         nData = nData + node.toString() + "\n";
      }
      return nData;
   }
   
   /**
    * Pokemon getter that gets an item with the same search key.
    * @param firstKey Object containing the key.
    * @return the data in the tree that matches the key.
    */
   public Pokemon get(Pokemon firstKey)
   {
      return this.get(root, firstKey);
   }
   
   /**
    * Recursive method to get item from tree.
    * @param node being the root of the tree.
    * @param secondKey Object storing the key.
    * @return the data retrieved from tree with the same key.
    * @throws PokemonException if the item is not found.
    */
   private Pokemon get(PokeNode<Pokemon> node, Pokemon secondKey)
   {
      //If the item is not retrived, throw the PokemonException.
      if (node == null)
      {
         throw new PokemonException("Item does not exist!!!");
      }
      //Otherwise the key matches, proceed with item checking.
      else
      {
         //If the key matches the result, return the item data.
         if (secondKey.compareTo(node.getPokeData()) == 0)
         {
            return node.getPokeData();
         }
         //If the key is less than the node, return left subtree.
         else if (secondKey.compareTo(node.getPokeData()) < 0)
         {
            return this.get(node.getLChild(), secondKey);
         }
         //If the key is greater than the node, return right subtree.
         else
         {
            return this.get(node.getRChild(), secondKey);
         }
      }
   }
   
   /**
    * remove method to remove an item from the tree.
    * @param thirdKey Object grabbing the key.
    */
   public void remove(Pokemon thirdKey)
   {
      root = this.remove(root, thirdKey);
   }
   
   /**
    * PokeNode removal method.
    * Recursively removes an item from tree.
    * @param node being the root of the tree.
    * @param fourthKey Object storing the key to remove.
    * @return root of the current subtree.
    * @throws PokemonException if the item not found in tree.
    */
   private PokeNode<Pokemon> remove(PokeNode<Pokemon> node, Pokemon fourthKey)
   {
      //If the item is not found, throw PokemonException.
      if (node == null)
      {
         throw new PokemonException("Item does not exist!!!");
      }
      //If the search key is less than node key, move to left subtree.
      else if (fourthKey.compareTo(node.getPokeData()) < 0)
      {
         node.setLChild(this.remove(node.getLChild(), fourthKey));
         return node;
      }
      //If the seach key is more than node key, move to right subtree.
      else if (fourthKey.compareTo(node.getPokeData()) > 0)
      {
         node.setRChild(this.remove(node.getRChild(), fourthKey));
         return node;
      }
      //If a node is found with an object with the same key, delete it.
      else
      {
         node = this.remove(node);
         return node;
      }
   }
   
   /**
    * remove helper method to remove node out of a tree.
    * @param node being removed.
    * @return the node that replaces the removed node or null.
    */
   private PokeNode<Pokemon> remove(PokeNode<Pokemon> node)
   {
      //If the node is a child node, return null.
      if (node.getLChild() == null && node.getRChild() == null)
      {
         return null;
      }
      //If node has a single left child node, return to left child node.
      else if (node.getRChild() == null)
      {
         return node.getLChild();
      }
      //If node has a single right child node, return to right child node.
      else if (node.getLChild() == null)
      {
         return node.getRChild();
      }
      else
      {
         //If node has two child nodes, grab items.
         Pokemon itemInTree = this.getItemInTree(node.getLChild());
         //Replace the node with item.
         node.setPokeData(itemInTree);
         //Delete the farthest right node in the left child node.
         node.setLChild(this.removeItemInTree(node.getLChild()));
         //return the node.
         return node;
      }
   }
   /**
    * remove interior nodes helper method.
    * Returns the item with largest key in the tree.
    * @param node being the root of the tree.
    * @return the item with largest key.
    */
   private Pokemon getItemInTree(PokeNode<Pokemon> node)
   {
      //If there is no right child node, this node has the largest item.
      if (node.getRChild() == null)
      {
         return node.getPokeData();
      }
      //Otherwise, keep looking at right child nodes until item is found.
      else
      {
         return this.getItemInTree(node.getRChild());
      }
   }
   /**
    * remove interior nodes helper method.
    * Returns the item with largest key in the tree.
    * Remove the node occupied by largest item.
    * @param node being the root of the tree.
    * @return root of tree with node removed.
    */
   private PokeNode<Pokemon> removeItemInTree(PokeNode<Pokemon> node)
   {
      //If a right child node doesn't exist, this node has the largest item.
      if (node.getRChild() == null)
      {
         return node.getLChild();
      }
      //Otherwise, keep looking at right child nodes until item is found.
      else
      {
         node.setRChild(this.removeItemInTree(node.getRChild()));
         return node;
      }
   }
}
package tree;
import list.Iterator;
/**
 * A BinaryTree may have a value, and 0-2 children,
 * each of which is also a Binary Tree
 * @author (sdb)
 * @author (Ryan Schwegel)
 */
public interface BinaryTree<E> {
	//Accessor methods
	/** @return the vlaue of this BinaryTree, or null
	 * if it has no value.
	 */
	E getValue();
	
	/** @return the left child of this BinaryTree */
	BinaryTree<E> getLeft();
	
	/** @return the right child of this BinaryTree */
	BinaryTree<E> getRight();
	
	//Mutator methods
	/** Set the value of this BinaryTree to the given value */
	void setValue(E value);
	
	/** Set the left child of this BinaryTree to 
	 * the given BinaryTree
	 */
	void setLeft(BinaryTree<E> left);
	
	/** Set the right child of this BinaryTree to
	 * the given BinaryTree
	 */
	void setRight(BinaryTree<E> right);
	
	/**@return true iff this BinaryTree is empty. */
	boolean isEmpty();
	
	/** return the size of the family of this BinaryTree */
	int size();
	
	/**
	 * Search the family of this BinaryTree for the given value.
	 * @return the value found, or null if not found.
	 */
	E get (E value);
	
	/** Add the given value to the family of this BinaryTree
	 * @return the resulting BinaryTree.
	 */
	BinaryTree<E> add (E value);
	
	/** @return true iff the given object is in the family of 
	 * this BinaryTree.
	 */
	boolean containsKey(Object obj);
	
	/**
	 * Remove the BinaryTree which has a value equal 
	 * to the given object from the family of this BinaryTree,
	 * if possible.
	 * @return the resulting BinaryTree
	 */
	BinaryTree<E> remove(Object obj);
	
	/**
	 * @return an iterator for this BinaryTree
	 */
	Iterator<E> iterator();
	
	/** @return the height of this BinaryTree */
	int height();
	
	/** @return true iff this BinaryTree is balanced */
	boolean isBalanced();
}

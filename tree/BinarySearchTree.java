package tree;
import list.*;
/** A binaryTree whose left child's value is smaller, and
 * whose right child's value is greater than
 * the value of this BinarySearchTree.
 * All non-empty children re also BinarySearchTrees.
 * @author sdb
 * @author Ryan Schwegel
 */
public class BinarySearchTree<E extends Comparable>
	implements BinaryTree<E> {
	BinaryTree<E> left = new EmptyBinarySearchTree<E>(),
				right = new EmptyBinarySearchTree<E>();
	E value;
	int size = 1; //size of the family
	
	//static fields needed for add and remove
	static boolean removed = false;
	static boolean added = false;
	
	public BinarySearchTree(E value) {
		this.value = value;
	}
	
	public E getValue() {
		return value;
	}

	/** @return the left child of this BinaryTree */
	public BinaryTree<E> getLeft() {
		return left;
	}

	/** @return the right child of this BinaryTree */
	public BinaryTree<E> getRight() {
		return right;
	}

	//Mutator methods
	/** Set the value of this BinaryTree to the given value*/
	public void setValue(E value) {
		this.value = value; 
	}

	/** Set the left child of this BinaryTree to the given BinaryTree */
	public void setLeft(BinaryTree<E> left) {
		this.left = left;
		size = left.size() + right.size() + 1;
	}

	/** Set the right child of this BinaryTree to the given BinaryTree */
	public void setRight(BinaryTree<E> right) {
		this.right = right;
		size = left.size() + right.size() + 1;
	}
	
	
	public boolean isEmpty() {
		if(size < 1)
			return true;
		return false;
	}

	
	public int size() {
		return size;
	}

	
	public E get(E value) {
		int cmp = this.value.compareTo(value);
		if (cmp == 0)
			return this.value;
		if(cmp < 0)
			return right.get(value);
		return left.get(value);
		
	}

	
	public BinaryTree<E> add(E value) {
		added = false;
		return addHelper(value);
	}
	
	private BinaryTree<E> addHelper(E value){
		int cmp = this.value.compareTo(value);
		if (cmp < 0) //add to family of right child
			right = right.add(value);
		if (cmp > 0)
			left = left.add(value);
		if(added)
			size++;
		return this;
	}
	
	public boolean containsKey(Object obj) {
		int cmp = value.compareTo(obj);
		if(cmp ==0)
			return true;
		if(cmp < 0)
			return right.containsKey(obj);
		return left.containsKey(obj);
	}
	
	public BinaryTree<E> remove(Object obj){
		removed = false;
		return removeHelper(obj);
	}
	
	private BinaryTree<E> removeHelper(Object obj){
		int cmp = value.compareTo(obj);
		if (cmp == 0) {
			removed = true;
			List<BinaryTree<E>> kids = children();
			if (kids.size() == 0)
				return new EmptyBinarySearchTree<E>();
			if(kids.size() == 1)
				return kids.get(0);
			BinaryTree<E> successor = getSuccessor();
			removeHelper(successor.getValue());
			setValue(successor.getValue());
			return this;
		}
		if (cmp > 0)
			left = left.remove(obj);
		if (cmp < 0)
			right = right.remove(obj);
		if(removed)
			size--;
		return this;
	}
	
	/**
	 * @return a list of this BinarySearchTree's children
	 */
	private List<BinaryTree<E>> children(){
		List<BinaryTree<E>> result = new ArrayList<BinaryTree<E>>();
		if(! left.isEmpty())
			result.add(left);
		if(! right.isEmpty())
			result.add(right);
		return result;
	}
	
	private BinaryTree<E> getSuccessor(){
		BinaryTree<E> temp = right;
		while(!temp.getLeft().isEmpty())
			temp = temp.getLeft();
		return temp;
	}
	
	public Iterator<E> iterator(){
		return new TreeIterator<E>(this);
	}
	
	public String toString() {
		Iterator<E> it = iterator();
		String out = "[" + it.next();
		while(it.hasNext()) {
			out += "," + it.next();
		}
		return out + "]";
	}
	
	public int height() {
		int leftHeight = left.height();
		int rightHeight = right.height();
		if(leftHeight > rightHeight) {
			return leftHeight + 1;
		} 
		return rightHeight + 1;
	}
	
	public boolean isBalanced() {
		if(Math.abs(left.height()-right.height())<5 
		   && left.isBalanced() && right.isBalanced()) {
			return true;
		}
		return false;
	}
}

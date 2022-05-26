package tree;
/** A BinaryTree which has no value and no children */
public class EmptyBinarySearchTree<E extends Comparable> 
	implements BinaryTree<E>{
	
	public BinaryTree<E> add(E value){
		BinarySearchTree.added = true;
		return new BinarySearchTree<E>(value);
	}
	public boolean containsKey(Object obj) {
		return false;
	}
	public E get(E value) {
		return null;
	}
	public int size() {
		return 0;
	}
	
	public E getValue() {
		return null;
	}
	
	public BinaryTree<E> getLeft() {
		return null;
	}
	
	public BinaryTree<E> getRight() {
		return null;
	}
	
	public void setValue(E value) {}
	
	public void setLeft(BinaryTree<E> left) {}
	
	public void setRight(BinaryTree<E> right) {}
	
	public boolean isEmpty() {
		return true;
	}
	public BinaryTree<E> remove (Object obj){
		return this;
	}
	
	public TreeIterator<E> iterator(){
		return new TreeIterator<E>(this);
	}
	
	public String toString() {
		return "[]";
	}
	
	public int height() {
		return 0;
	}
	
	public boolean isBalanced() {
		return true;
	}
}

package tree;

/** An Expr representing the assignment operator (a = b) 
 * @author Ryan Schwegel */
public class Assign extends Expr {
	
	public Assign(Expr left, Expr right) {
		super(left,right);
	}
	
	public int eval() {
		if(! (left instanceof Variable))
			throw new IllegalArgumentException();
		return ((Variable)left).assign(right.eval());
	}

	public boolean equals(Object obj) {
		if(! (obj instanceof Assign))
			return false;
		Assign other = (Assign)obj;
		return other.right.equals(right) && other.left.equals(left);
	}

	
	public Expr simplify() {
		left = left.simplify();
		right = right.simplify();
		return this;
	}
	
	public String toString() {
		return "(" + left  +  "=" + right + ")";
	}
}

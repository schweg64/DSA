package tree;
/** An Expr which is the Difference of two Exprs 
 * @author Ryan Schwegel */
public class Difference extends Expr {

	public Difference(Expr left, Expr right) {
		super(left,right);
	}
	public int eval() {
		return left.eval() - right.eval();
	}

	
	public boolean equals(Object obj) {
		if(! (obj instanceof Difference))
			return false;
		Difference other = (Difference) obj;
		return left.equals(other.left) 
				&& right.equals(other.right);
	}

	
	public Expr simplify() {
		left = left.simplify();
		right = right.simplify();
		if(right instanceof Constant && right.eval() == 0)  // a - 0 = a
			return left;
		if(left.equals(right))	// a - a = 0
			return new Constant(0);
		return this;
	}
	
	public String toString() {
		return "(" + left + "-" + right + ")";
	}
}

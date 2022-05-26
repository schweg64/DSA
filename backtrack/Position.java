package backtrack;
/** A Position is a row and column number on 
 * a chess board.
 * Row and column numbers begin at 0.
 * @author Ryan Schwegel
 * @author sdb
 */
public class Position {
	int row, col;
	
	public Position (int r, int c) {
		row = r;
		col = c;
	}
	
	public boolean equals(Object obj) {
		Position other = (Position) obj;
		return row == other.row && col == other.col;
	}
	
	/** @return true iff a queen on this position
	 * is attacking a queen on the other position
	 */
	public boolean isAttacking (Position other) {
		return row == other.row||
				col == other.col ||
				row+col == other.row + other.col ||
				row-col == other.row - other.col;
	}
}

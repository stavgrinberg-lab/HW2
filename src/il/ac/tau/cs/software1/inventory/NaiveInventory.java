package il.ac.tau.cs.software1.inventory;

/*
 * A simple array-based Inventory (Question 6).
 */
public class NaiveInventory implements Inventory {

	private static final int INITIAL_CAPACITY = 100;
	private Collectible[] col;
	private int count;

	public NaiveInventory() {
		col = new Collectible[INITIAL_CAPACITY];
	}

	@Override
	public void collect(Collectible collectible) {
		int n = col.length;
		if (count == n){
			Collectible[] col2 = new Collectible[2*n];
			for (int i=0;i<n;i++)
				col2[i] = col[i];
			col = col2;
		}
		col[count] = collectible;
		count+=1;
	}

	@Override
	public float getTotalWeight() {
		float sum = 0;
		for (int i=0; i<count; i++)
			sum+=col[i].getWeight();
		return sum;
	}

	@Override
	public int getCurrentCount() {
		return count;
	}

	// Returns the array of Collectibles that is stored in the field of this class
	public Collectible[] getCollArr() {
		return col;
	}
}

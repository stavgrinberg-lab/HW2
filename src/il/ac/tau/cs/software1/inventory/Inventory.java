package il.ac.tau.cs.software1.inventory;

public interface Inventory {

	void collect(Collectible collectible);
		
	float getTotalWeight();
	
	int getCurrentCount();
}

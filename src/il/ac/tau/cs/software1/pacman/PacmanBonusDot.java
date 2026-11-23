package il.ac.tau.cs.software1.pacman;

import il.ac.tau.cs.software1.components.*;

public class PacmanBonusDot extends PacmanBonus {

	public PacmanBonusDot(PacmanGridComponent initialPosition) {
		super(initialPosition);
		this.imageComponent = new ImageComponent("bonus-dot");
		this.bonusScore = 10;
	}

	// The two methods below belong to the Collectible interface (Question 8)

	@Override
	public float getWeight() {
		return (float)1;
	}

	@Override
	public float getPrice() {
		return (float)12;
	}
}

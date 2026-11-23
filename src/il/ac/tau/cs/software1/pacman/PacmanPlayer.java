package il.ac.tau.cs.software1.pacman;

import il.ac.tau.cs.software1.core.*;
import il.ac.tau.cs.software1.inventory.Collectible;
import il.ac.tau.cs.software1.inventory.InventoryComponent;
import il.ac.tau.cs.software1.components.ImageComponent;
import il.ac.tau.cs.software1.math.Vector2;

public class PacmanPlayer extends PacmanGameObject {
		
	protected int score = 0;
	private InventoryComponent ivco = new InventoryComponent();
	
	public PacmanPlayer(PacmanGridComponent initialPosition) {
		super(initialPosition);
		imageComponent = new ImageComponent("player");
//		transformComponent.scale.multiply(2.f);
	}

	@Override
	public void update() {		
		gridComponent.x += (int)velocityComponent.velocity.x;
		gridComponent.y += (int)velocityComponent.velocity.y;
		if (gridComponent.x < 0) gridComponent.x = PacmanConstants.gridWidth - 1;
		if (gridComponent.x >= PacmanConstants.gridWidth) gridComponent.x = 0;
		if (gridComponent.y < 0) gridComponent.y = PacmanConstants.gridHeight - 1;
		if (gridComponent.y >= PacmanConstants.gridHeight) gridComponent.y = 0;
		this.snapTransformToGrid();
	}
	
	@Override
	public void onHit(GameObject other) {
		if (other instanceof PacmanObstacle) {
			velocityComponent.velocity.x *= -1.f;
			velocityComponent.velocity.y *= -1.f;
			this.update();
			velocityComponent.velocity = new Vector2();
		}
		
		else if (other instanceof PacmanBonus) {
			PacmanBonus bonus = (PacmanBonus) other;
			if ((ivco.getInventory().getTotalWeight() + bonus.getWeight()) <= ivco.getMaxWeight()){
				bonus.getTransformComponent().position = ivco.getInventoryPosition();
				ivco.getInventory().collect(bonus);
				addScore(bonus.bonusScore);
			}
		}
	}
	
	public InventoryComponent getInventoryComponent() {
		return ivco;
	}
	
	public void addScore(int bonus) {
		score += bonus;
		System.out.println("Score: " + String.valueOf(score));
	}
	
	public int getScore() {
		return score;
	}
}

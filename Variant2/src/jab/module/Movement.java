package jab.module;

/**
 * Movement
 * 
 * @author jab
 */
public class Movement extends Part {

	public Module bot;

	public Movement(Module bot) {
		this.bot = bot;
	}

	public void move() {
		moveCounter++;
		if (moveCounter % 30 == 0) {
			direction = -direction;
		}
		bot.setAhead(150 * direction);
		bot.setTurnRightRadians(0.3 * direction);
	}

	double direction = 1;
	int moveCounter = 0;

}

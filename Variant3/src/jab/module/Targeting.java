package jab.module;

/**
 * Targeting
 * 
 * @author jabier.martinez
 */
public class Targeting extends Part {

	public Module bot;

	public Targeting(Module bot) {
		this.bot = bot;
	}

	public void target() {

		if (bot.enemy == null)
			return;

		double bulletPower = bot.bulletPower > 0 ? bot.bulletPower : 1.5;
		double bulletSpeed = 20 - 3 * bulletPower;
		double time = bot.enemy.distance / bulletSpeed;

		double futureX = bot.enemy.x + Math.sin(bot.enemy.headingRadians) * bot.enemy.velocity * time;

		double futureY = bot.enemy.y + Math.cos(bot.enemy.headingRadians) * bot.enemy.velocity * time;

		double angle = normalizeAbsolute(Math.atan2(futureX - bot.getX(), futureY - bot.getY()));

		bot.setTurnGunRightRadians(normalizeRelative(angle - bot.getGunHeadingRadians()));
	}

	double normalizeAbsolute(double angle) {
		while (angle < 0)
			angle += 2 * Math.PI;
		while (angle > 2 * Math.PI)
			angle -= 2 * Math.PI;
		return angle;
	}

	double normalizeRelative(double angle) {
		while (angle > Math.PI)
			angle -= 2 * Math.PI;
		while (angle < -Math.PI)
			angle += 2 * Math.PI;
		return angle;
	}

}

package jab.module;

/**
 * Gun
 * 
 * @author jab
 */
public class Gun extends Part {

	public Module bot;

	public Gun(Module bot) {
		this.bot = bot;
	}

	public void fire() {
		if (bot.enemy != null && bot.getGunHeat() == 0) {
			double distance = bot.enemy.distance;
			double firePower;
			if (distance < 150) {
				firePower = 3;
			} else if (distance < 300) {
				firePower = 2;
			} else {
				firePower = 1;
			}
			robocode.Bullet b = bot.setFireBullet(firePower);
			bot.registerBullet(b);
		}
	}

}

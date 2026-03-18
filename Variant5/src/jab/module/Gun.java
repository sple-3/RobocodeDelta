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
			bot.setFire(3.0);
		}
	}

}

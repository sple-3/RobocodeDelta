package jab.module;

/**
 * Select enemy
 * 
 * @author jabier.martinez
 */
public class SelectEnemy extends Part {

	public Module bot;

	public SelectEnemy(Module bot) {
		this.bot = bot;
	}

	public void select() {
		if (!bot.botsInfo.isEmpty()) {
			java.util.Vector<jab.module.BotInfo> enemyList = new java.util.Vector<jab.module.BotInfo>(
					bot.botsInfo.values());
			int randomIndex = (int) (Math.random() * enemyList.size());
			bot.enemy = enemyList.get(randomIndex);
		}
	}

}

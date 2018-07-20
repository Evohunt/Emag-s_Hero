package hero;

import java.util.Random;

public class Beast implements IFighter {
    private IHealth health;
    private int strength;
    private int defense;
    private int speed;
    private IChance luck;
    private String name;
    private ILogger log;


    public Beast(IHealth otherHealth, int otherStrength, int otherDefense, int otherSpeed, IChance otherLuck, String beastName, ILogger otherLog) {
        health = otherHealth;
        strength = otherStrength;
        defense = otherDefense;
        speed = otherSpeed;
        luck = otherLuck;
        name = beastName;
        log = otherLog;

    }

    @Override
    public boolean isAttackingFirst(IFighter otherFighter) {

        if (otherFighter.hasTheSameSpeedAs(speed)) {
            return otherFighter.isLessLuckyThan(luck);
        }

        return otherFighter.isSlowerThan(speed);
    }

    @Override
    public boolean isLessLuckyThan(IChance otherLuck) {
        return otherLuck.isLessLuckyThan(luck);
    }

    @Override
    public boolean hasTheSameSpeedAs(int otherSpeed) {
        return speed == otherSpeed;
    }

    @Override
    public boolean isSlowerThan(int otherSpeed) {
        return speed < otherSpeed;
    }

    @Override
    public void attack(IFighter defender) {
        log.add(name + " attacked " + defender.getName());
        defender.defend(strength);
    }

    @Override
    public void defend(int otherStrength) {
        if (iAmLucky()) {
            log.add(name + " got lucky");
            return;
        }

        int damage = computeDamage(otherStrength);
        health.applyDamage(damage);

    }


    private int computeDamage(int otherStrength) {
        if (otherStrength < defense) {
            return 0;
        }

        return otherStrength - defense;
    }

    private boolean iAmLucky() {
        return luck.isLucky();
    }

    @Override
    public boolean isDefeated() {
        return health.isDepleted();
    }

    public String getName() {
        return name;
    }
}

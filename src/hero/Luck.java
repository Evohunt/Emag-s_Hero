package hero;

import java.util.Random;

public class Luck implements IChance {
    private int luckValue;

    public Luck(int otherLuck) {
        luckValue = otherLuck;
    }

    @Override
    public boolean isLucky() {
        Random chance = new Random();
        return luckValue > chance.nextInt(101);
    }

    @Override
    public boolean isLessLuckyThan(IChance otherLuck) {
        return otherLuck.isLessLuckyThan(luckValue);
    }

    @Override
    public boolean isLessLuckyThan(int otherLuck) {
        return luckValue > otherLuck;
    }

}

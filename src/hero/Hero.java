package hero;

public class Hero implements IFighter {
    private IFighter innerBeast;
    private IChance rapidStrikeChance;

    public Hero(IFighter otherInnerBeast, IChance otherChance) {
        innerBeast = otherInnerBeast;
        rapidStrikeChance = otherChance;
    }

    @Override
    public void attack(IFighter defender) {
        innerBeast.attack(defender);

        if (rapidStrikeChance.isLucky()) {
            innerBeast.attack(defender);
        }
    }

    @Override
    public boolean isAttackingFirst(IFighter otherFighter) {
        return innerBeast.isAttackingFirst(otherFighter);
    }

    @Override
    public boolean isDefeated() {
        return innerBeast.isDefeated();
    }

    @Override
    public boolean hasTheSameSpeedAs(int otherSpeed) {
        return innerBeast.hasTheSameSpeedAs(otherSpeed);
    }

    @Override
    public boolean isLessLuckyThan(IChance otherLuck) {
        return innerBeast.isLessLuckyThan(otherLuck);
    }

    @Override
    public boolean isSlowerThan(int otherSpeed) {
        return innerBeast.isSlowerThan(otherSpeed);
    }

    @Override
    public void defend(int otherStrength) {
        innerBeast.defend(otherStrength);
    }

    public String getName(){
        return innerBeast.getName();
    }
}

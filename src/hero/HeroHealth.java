package hero;

public class HeroHealth implements IHealth {
    IHealth innerHealth;
    IChance magicShieldChance;

    public HeroHealth(IHealth otherInnerHealth, IChance otherChance) {
        innerHealth = otherInnerHealth;
        magicShieldChance = otherChance;
    }

    @Override
    public void applyDamage(int otherDamage) {
        int currentDamage = otherDamage;
        if (magicShieldChance.isLucky()) {
            currentDamage = currentDamage / 2;
        }

        innerHealth.applyDamage(currentDamage);
    }

    @Override
    public boolean isDepleted() {
        return innerHealth.isDepleted();
    }
}

package hero;

public class BeastHealth implements  IHealth {
    private int healthValue;


    public BeastHealth(int otherHealth) {
        healthValue = otherHealth;
    }

    @Override
    public void applyDamage(int otherDamage) {
        healthValue -= otherDamage;
    }

    @Override
    public boolean isDepleted() {
        return healthValue <= 0;
    }


}

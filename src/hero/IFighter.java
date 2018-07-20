package hero;

public interface IFighter {
    boolean isAttackingFirst(IFighter otherFighter);

    void attack(IFighter defender);

    boolean isDefeated();


    boolean hasTheSameSpeedAs(int otherSpeed);


    boolean isLessLuckyThan(IChance otherLuck);


    boolean isSlowerThan(int otherSpeed);

    void defend(int otherStrength);

    String getName();


}

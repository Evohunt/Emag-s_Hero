package hero;

public interface IChance {

    boolean isLucky();

    boolean isLessLuckyThan(IChance otherLuck);

    boolean isLessLuckyThan(int otherLuck);


}

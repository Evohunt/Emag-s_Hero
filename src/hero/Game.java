package hero;


public class Game {
    private ILogger log;

    public Game( ILogger otherLog) {
        log = otherLog;
    }

    public void play() {

        IFightFactory fightFactory = new FightFactory();


        IFight fight = fightFactory.create(log);
        fight.start();
        fight.getWinner();
    }
}

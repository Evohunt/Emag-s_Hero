package hero;

import java.util.Random;

public class FightFactory implements  IFightFactory {
    private int getRandomInt(int floor, int ceiling){
        Random randomAttribute = new Random();

        return  randomAttribute.nextInt(ceiling- floor) + floor;
    }


    @Override
    public IFight create(ILogger log) {
        int maxRounds = 20;

        IFighter heroInnerBeast = new Beast(
                new HeroHealth(new BeastHealth(getRandomInt(70, 100)),
                new Luck(20)),
                getRandomInt(70, 80),
                getRandomInt(45, 55),
                getRandomInt(40, 50),
                        new Luck(getRandomInt(10,30)),"Orderus", log);

        IFighter beast = new Beast(
                new BeastHealth(getRandomInt(60, 90)),
                getRandomInt(60, 90),
                getRandomInt(40, 60),
                getRandomInt(40,60),
                new Luck(getRandomInt(25,40)),
                "Wild-Beast",log);

        IFighter hero = new Hero(heroInnerBeast, new Luck(10));





        return new Fight(hero, beast ,maxRounds, log);
    }
}

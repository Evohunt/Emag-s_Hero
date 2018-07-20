package hero;

public class Fight implements IFight {
    private IFighter attacker;
    private IFighter defender;
    private int maxRounds;
    private ILogger log;

    public Fight(IFighter otherAttacker, IFighter otherDefender, int otherMaxRounds, ILogger otherLog) {
        attacker = otherAttacker;
        defender = otherDefender;
        maxRounds = otherMaxRounds;
        log = otherLog;
    }

    @Override
    public void start() {

        if (defender.isAttackingFirst(attacker)) {
            switchRoles();
        }


        for (int i = 0; i < maxRounds; i++) {
            attacker.attack(defender);

            if (defender.isDefeated()) {
                break;
            }

            switchRoles();
        }
    }

    private void switchRoles() {
        IFighter dummy = attacker;
        attacker = defender;
        defender = dummy;
    }


    @Override
    public void getWinner() {
        if (defender.isDefeated()) {
            System.out.println("Winner:" + attacker.getName());
        } else {
            System.out.println("Draw");
        }
    }
}

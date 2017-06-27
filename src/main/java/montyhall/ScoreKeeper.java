package montyhall;

import static montyhall.MontyHallProblem.CAR;
import static montyhall.MontyHallProblem.GOAT;
import static montyhall.MontyHallProblem.NUMBER_OF_TRIALS;

class ScoreKeeper {

    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory
        .getLogger(MontyHallProblem.class);

    private final long startTime = System.currentTimeMillis();

    private int switchedWins;
    private int originalWins;
    private int revealedGoats;

    void score(Doors doors) {
        if (CAR.equals(doors.contestantChoosesDoor())) {
            originalWins++;
        }
        if (GOAT.equals(doors.hostRevealsLosingDoor())) {
            revealedGoats++;
        }
        if (CAR.equals(doors.contestantChoosesDoor())) {
            switchedWins++;
        }
    }

    void print(montyhall.ScoreKeeper scoreKeeper) {
        logger.info("Time taken: {} ms.", (System.currentTimeMillis() - this.startTime));
        logger.info("Results:"
                + "\n\t{} times host reveals Goat"
                + "\n\t{}% that would have won with original pick"
                + "\n\t{}% that would win from switch"
                + "\n\t{} total trials",
            scoreKeeper.revealedGoats, percentage(scoreKeeper.originalWins),
            percentage(scoreKeeper.switchedWins), NUMBER_OF_TRIALS);
    }

    static double percentage(int counter) {
        return counter * 100.0 / NUMBER_OF_TRIALS;
    }
}
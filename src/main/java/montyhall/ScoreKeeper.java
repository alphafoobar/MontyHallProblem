package montyhall;

import static montyhall.MontyHallProblem.CAR;
import static montyhall.MontyHallProblem.GOAT;
import static montyhall.MontyHallProblem.NUMBER_OF_TRIALS;
import static org.slf4j.LoggerFactory.getLogger;

import org.slf4j.Logger;

class ScoreKeeper {

    private static final Logger logger = getLogger(MontyHallProblem.class);

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

    void print() {
        logger.info("Time taken: {} ms.", (System.currentTimeMillis() - startTime));
        logger.info("Results:"
                + "\n\t{} times host reveals Goat"
                + "\n\t{}% that would have won with original pick"
                + "\n\t{}% that would win from switch"
                + "\n\t{} total trials", revealedGoats, percentage(originalWins),
            percentage(switchedWins), NUMBER_OF_TRIALS);
    }

    static double percentage(int counter) {
        return counter * 100.0 / NUMBER_OF_TRIALS;
    }
}
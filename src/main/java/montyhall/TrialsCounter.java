package montyhall;

import static montyhall.MontyHallProblem.CAR;
import static montyhall.MontyHallProblem.GOAT;
import static org.slf4j.LoggerFactory.getLogger;

import org.slf4j.Logger;

/**
 * Run the competition routine and keep track of the results.
 */
class TrialsCounter {

    private static final Logger logger = getLogger(MontyHallProblem.class);

    private final long startTime = System.currentTimeMillis();
    private final int trials;

    private int switchedWins;
    private int originalWins;
    private int revealedGoats;

    TrialsCounter(int trials) {
        this.trials = trials;
    }

    void play(Doors doors) {
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

    /**
     * Prints the result summary.
     */
    void print() {
        logger.info("Time taken: {} ms.", (System.currentTimeMillis() - startTime));
        logger.info("Results:"
                + "\n\t{} times host reveals Goat"
                + "\n\t{}% that would have won with original pick"
                + "\n\t{}% that would win from switch"
                + "\n\t{} total trials", revealedGoats, percentage(originalWins),
            percentage(switchedWins), trials);
    }

    /**
     * Convert a raw result score into a percentage of the total trials from {@code
     * NUMBER_OF_TRIALS}.
     *
     * @param result The raw score, i.e. number of times the car found behind a door.
     * @return The percentage of {@code NUMBER_OF_TRIALS}.
     */
    double percentage(int result) {
        return result * 100.0 / trials;
    }

    int getSwitchedWins() {
        return switchedWins;
    }

    int getOriginalWins() {
        return originalWins;
    }

    int getRevealedGoats() {
        return revealedGoats;
    }
}
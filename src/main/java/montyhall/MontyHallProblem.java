/*
 *  Michael Geiser
 *  Personal Project
 *  8 November 2007
 *  Copyright Michael J. Geiser - all rights reserved
 */

package montyhall;

import java.util.Random;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MontyHallProblem {

    private static final Logger logger = LoggerFactory.getLogger(MontyHallProblem.class);
    private static final Random RANDOM = new Random();

    static final String GOAT = "Goat";
    static final String CAR = "Car";

    private static final int NUMBER_OF_TRIALS = 1000000;
    private static final int NUMBER_OF_DOORS = 3;

    private static int switchedWins;
    private static int originalWins;
    private static int revealedGoats;

    public static void main(String[] args) {
        montyHallProblem();
    }

    private static void montyHallProblem() {
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < NUMBER_OF_TRIALS; i++) {
            Doors doors = new Doors(NUMBER_OF_DOORS);

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

    static int randomIntegerLessThan(int upper) {
        return RANDOM.nextInt(upper);
    }
}

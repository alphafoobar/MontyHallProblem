/*
 *  Michael Geiser
 *  Personal Project
 *  8 November 2007
 *  Copyright Michael J. Geiser - all rights reserved
 */

package montyhall;

import java.util.Random;

public class MontyHallProblem {

    private static final Random RANDOM = new Random();

    static final String GOAT = "Goat";
    static final String CAR = "Car";

    static final int NUMBER_OF_TRIALS = 1000000;
    private static final int NUMBER_OF_DOORS = 3;

    public static void main(String[] args) {
        montyHallProblem();
    }

    private static void montyHallProblem() {
        ScoreKeeper scoreKeeper = new ScoreKeeper();

        for (int i = 0; i < NUMBER_OF_TRIALS; i++) {
            scoreKeeper.score(new Doors(NUMBER_OF_DOORS));
        }

        scoreKeeper.print(scoreKeeper);
    }

    static int randomIntegerLessThan(int upper) {
        return RANDOM.nextInt(upper);
    }
}

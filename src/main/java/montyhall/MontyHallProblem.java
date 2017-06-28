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

    private final Counter counter;

    MontyHallProblem(Counter counter) {
        this.counter = counter;
    }

    public static void main(String[] args) {
        new MontyHallProblem(new Counter()).runContest(NUMBER_OF_TRIALS, NUMBER_OF_DOORS);
    }

    void runContest(int numberOfTrials, int numberOfDoors) {
        for (int i = 0; i < numberOfTrials; i++) {
            counter.runContest(new Doors(numberOfDoors));
        }
        counter.print();
    }

    static int randomIntegerLessThan(int upper) {
        return RANDOM.nextInt(upper);
    }
}

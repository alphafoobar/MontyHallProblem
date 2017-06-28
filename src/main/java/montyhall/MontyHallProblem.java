/*
 *  Michael Geiser
 *  Personal Project
 *  8 November 2007
 *  Copyright Michael J. Geiser - all rights reserved
 */

package montyhall;

/**
 * This is the main class of the application. It uses a {@link TrialsCounter} to keep track of the
 * results.
 */
public class MontyHallProblem {

    static final String GOAT = "Goat";
    static final String CAR = "Car";

    static final int NUMBER_OF_TRIALS = 1000000;

    private static final int NUMBER_OF_DOORS = 3;

    private final TrialsCounter counter;

    public static void main(String[] args) {
        new MontyHallProblem(new TrialsCounter()).runTrials(NUMBER_OF_TRIALS, NUMBER_OF_DOORS);
    }

    MontyHallProblem(TrialsCounter counter) {
        this.counter = counter;
    }

    void runTrials(int trials, int doors) {
        for (int i = 0; i < trials; i++) {
            counter.play(new Doors(doors));
        }
        counter.print();
    }
}

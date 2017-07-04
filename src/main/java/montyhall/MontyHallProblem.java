/*
 *  Michael Geiser
 *  Personal Project
 *  8 November 2007
 *  Copyright Michael J. Geiser - all rights reserved
 */

package montyhall;

import javax.annotation.Nonnull;

/**
 * This is the main class of the application. It uses a {@link TrialsCounter} to keep track of the
 * results.
 */
public class MontyHallProblem {

    static final String GOAT = "Goat";
    static final String CAR = "Car";

    static final int NUMBER_OF_TRIALS = 1000000;
    static final int NUMBER_OF_DOORS = 3;

    private final TrialsCounter counter;
    private final int trials;
    private final int doors;

    public static void main(String[] args) {
        TrialsCounter counter = new TrialsCounter(NUMBER_OF_TRIALS);
        new MontyHallProblem(counter, NUMBER_OF_TRIALS, NUMBER_OF_DOORS).runTrials();
    }

    MontyHallProblem(@Nonnull TrialsCounter counter, int trials, int doors) {
        this.counter = counter;
        this.trials = trials;
        this.doors = doors;
    }

    void runTrials() {
        for (int i = 0; i < trials; i++) {
            counter.play(new Doors(doors));
        }
        counter.print();
    }
}

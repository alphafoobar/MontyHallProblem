package montyhall;

import static montyhall.MontyHallProblem.CAR;
import static montyhall.MontyHallProblem.GOAT;

import com.google.common.base.Preconditions;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Doors represents all the doors in a competition. Generally 3 doors would be
 * expected. But a contest might be started that includes any number of doors.
 *
 * Less than 3 doors would not allow a contestant to switch their choice after the host reveals a
 * losing door and might not allow the host to reveal a losing door.
 */
class Doors {

    private static final Random RANDOM = new Random();

    private final List<String> doors;

    Doors(int numberOfDoors) {
        doors = createDoors(numberOfDoors);

        hideCarBehindDoor();
    }

    String contestantChoosesDoor() {
        Preconditions.checkState(!doors.isEmpty(), "No more doors to choose!");
        return doors.remove(randomIntegerLessThan(doors.size()));
    }

    String hostRevealsLosingDoor() {
        for (int i = 0; i < doors.size(); i++) {
            String door = doors.get(i);
            if (GOAT.equals(door)) {
                return doors.remove(i);
            }
        }

        throw new IllegalStateException("No more losing doors!");
    }

    private void hideCarBehindDoor() {
        doors.set(randomIntegerLessThan(doors.size()), CAR);
    }

    private static List<String> createDoors(int numberOfDoors) {
        // Linked lists allow us to remove items efficiently.
        List<String> doors = new LinkedList<>();
        for (int i = 0; i < numberOfDoors; i++) {
            doors.add(GOAT);
        }
        return doors;
    }

    private static int randomIntegerLessThan(int upper) {
        return RANDOM.nextInt(upper);
    }
}

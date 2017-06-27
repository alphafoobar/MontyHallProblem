import com.google.common.base.Preconditions;
import java.util.LinkedList;
import java.util.List;

/**
 * Doors can be created to represent a number of doors in a competition. Generally 3 doors would be
 * expected. But Doors can handle contests that include any number of doors.
 */
class Doors {

    private final List<String> doors;

    Doors(int numberOfDoors) {
        doors = createDoors(numberOfDoors);

        hideCarBehindDoor();
    }

    String contestantChoosesDoor() {
        Preconditions.checkState(!doors.isEmpty(), "No more doors to choose!");
        return doors.remove(MontyHallProblem.randomIntegerLessThan(doors.size()));
    }

    String hostRevealsLosingDoor() {
        int i = 0;
        for (String door : doors) {
            if (MontyHallProblem.GOAT.equals(door)) {
                doors.remove(i);
                return door;
            }
            i++;
        }

        throw new IllegalStateException("No more losing doors!");
    }

    private void hideCarBehindDoor() {
        int doorNumber = MontyHallProblem.randomIntegerLessThan(doors.size());
        doors.set(doorNumber, MontyHallProblem.CAR);
    }

    private static List<String> createDoors(int numberOfDoors) {
        // Linked lists allow us to remove items efficiently.
        List<String> doors = new LinkedList<>();
        for (int i = 0; i < numberOfDoors; i++) {
            doors.add(MontyHallProblem.GOAT);
        }
        return doors;
    }
}

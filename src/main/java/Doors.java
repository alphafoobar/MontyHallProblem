import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * Doors can be created to represent a number of doors in a competition. Generally 3 doors would be
 * expected.
 */
class Doors {

    private final List<Door> doors;

    // Using a set of revealed doors allows for contests with more than 3 doors.
    private final Set<Integer> revealedDoors = new LinkedHashSet<>();
    private int chosenDoor;

    Doors(int numberOfDoors) {
        doors = createDoors(numberOfDoors);

        hideCarBehindDoor();
    }

    Door contestantPicksFirstDoor() {
        chosenDoor = MontyHallProblem.randomIntegerLessThan(doors.size());

        return doors.get(chosenDoor);
    }

    Door hostRevealsLosingDoor() {
        int revealedDoor = findAnotherLosingDoor();

        Door door = doors.get(revealedDoor);
        door.revealDoor();

        revealedDoors.add(revealedDoor);
        return door;
    }

    private int findAnotherLosingDoor() {
        Set<Integer> losingDoors = new LinkedHashSet<>();
        int revealedDoor;
        do {
            Preconditions.checkArgument(losingDoors.size() < doors.size(),
                "All losing doors have been revealed.");

            revealedDoor = MontyHallProblem.randomIntegerLessThan(doors.size());
            losingDoors.add(revealedDoor);
        } while (revealedDoor == chosenDoor
            || doors.get(revealedDoor).isRevealed()
            || MontyHallProblem.CAR.equals(doors.get(revealedDoor).behindTheDoor));
        return revealedDoor;
    }

    Door contestantPicksAnotherDoor() {
        int doorNumber;
        do {
            doorNumber = MontyHallProblem.randomIntegerLessThan(doors.size());
        } while (doorNumber == chosenDoor || revealedDoors.contains(doorNumber));

        return doors.get(doorNumber);
    }

    private void hideCarBehindDoor() {
        int doorNumber = MontyHallProblem.randomIntegerLessThan(doors.size());
        doors.get(doorNumber).behindTheDoor = MontyHallProblem.CAR;
    }

    private static List<Door> createDoors(int numberOfDoors) {
        List<Door> doors = new ArrayList<>(numberOfDoors);
        for (int i = 0; i < numberOfDoors; i++) {
            doors.add(Door.newDoor(MontyHallProblem.GOAT));
        }
        return doors;
    }
}

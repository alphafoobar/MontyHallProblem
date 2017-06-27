import java.util.LinkedList;
import java.util.List;

/**
 * Doors can be created to represent a number of doors in a competition. Generally 3 doors would be
 * expected.
 */
class Doors {

    private final List<Door> doors;

    Doors(int numberOfDoors) {
        doors = createDoors(numberOfDoors);

        hideCarBehindDoor();
    }

    Door contestantPicksFirstDoor() {
        return doors.remove(MontyHallProblem.randomIntegerLessThan(doors.size()));
    }

    Door hostRevealsLosingDoor() {
        int revealedDoor = findAnotherLosingDoor();

        return doors.remove(revealedDoor);
    }

    private int findAnotherLosingDoor() {
        for (int i = 0; i < doors.size(); i++) {
            Door door = doors.get(i);
            if (MontyHallProblem.GOAT.equals(door.behindTheDoor)) {
                return i;
            }
        }

        throw new IllegalStateException("No more losing doors!");
    }

    Door contestantPicksAnotherDoor() {
        // This is the contestants second pick, so we can remove it or just get it.
        return doors.get(MontyHallProblem.randomIntegerLessThan(doors.size()));
    }

    private void hideCarBehindDoor() {
        int doorNumber = MontyHallProblem.randomIntegerLessThan(doors.size());
        doors.get(doorNumber).behindTheDoor = MontyHallProblem.CAR;
    }

    private static List<Door> createDoors(int numberOfDoors) {
        // Linked lists allow us to remove items efficiently.
        List<Door> doors = new LinkedList<>();
        for (int i = 0; i < numberOfDoors; i++) {
            doors.add(Door.newDoor(MontyHallProblem.GOAT));
        }
        return doors;
    }
}

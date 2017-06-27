import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;

class Door {

    private boolean revealed;
    String behindTheDoor;

    static Door newDoor(String prize) {
        Door door = new Door();
        door.behindTheDoor = prize;
        door.revealed = false;
        return door;
    }

    void revealDoor() {
        Preconditions.checkArgument(!revealed, "Door has already been chosen!");

        revealed = true;
    }

    boolean isRevealed() {
        return revealed;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
            .add("revealed", revealed)
            .add("behindTheDoor", behindTheDoor)
            .toString();
    }
}

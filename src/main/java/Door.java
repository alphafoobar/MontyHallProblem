import com.google.common.base.MoreObjects;

class Door {

    String behindTheDoor;

    static Door newDoor(String prize) {
        Door door = new Door();
        door.behindTheDoor = prize;
        return door;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
            .add("behindTheDoor", behindTheDoor)
            .toString();
    }
}

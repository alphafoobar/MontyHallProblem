import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class MoreDoorsTest {

    private static final int DOORS = 20;
    private Doors doors = new Doors(DOORS);

    @Test
    public void pickRandomDoor() throws Exception {
        assertNotNull(doors.contestantPicksFirstDoor());
    }

    @Test
    public void hostRevealedDoor() throws Exception {
        for (int i = 0; i < DOORS - 2; i++) {
            assertThat(doors.hostRevealsLosingDoor().behindTheDoor, not(MontyHallProblem.CAR));
        }
    }

    @Test
    public void contestantPicksAnotherDoor() throws Exception {
        assertNotNull(doors.contestantPicksFirstDoor());
        assertThat(doors.hostRevealsLosingDoor().behindTheDoor, not(MontyHallProblem.CAR));
        assertNotNull(doors.contestantPicksAnotherDoor());
    }

    @Test
    public void contestantPicksRemainingDoor() throws Exception {
        assertNotNull(doors.contestantPicksFirstDoor());
        for (int i = 0; i < DOORS - 2; i++) {
            assertThat(doors.hostRevealsLosingDoor().behindTheDoor, not(MontyHallProblem.CAR));
        }
        assertNotNull(doors.contestantPicksAnotherDoor());
    }
}

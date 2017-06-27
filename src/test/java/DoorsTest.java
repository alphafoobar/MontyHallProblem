
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class DoorsTest {

    private Doors doors = new Doors(3);

    @Test
    public void pickRandomDoor() throws Exception {
        assertNotNull(doors.contestantPicksFirstDoor());
    }

    @Test
    public void hostRevealedDoor() throws Exception {
        assertThat(doors.hostRevealsLosingDoor().behindTheDoor, not(MontyHallProblem.CAR));
    }

    @Test
    public void contestantPicksAnotherDoor() throws Exception {
        assertNotNull(doors.contestantPicksFirstDoor());
        assertThat(doors.hostRevealsLosingDoor().behindTheDoor, not(MontyHallProblem.CAR));
        assertNotNull(doors.contestantPicksAnotherDoor());
    }

}
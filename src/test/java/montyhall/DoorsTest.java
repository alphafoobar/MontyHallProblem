package montyhall;

import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class DoorsTest {

    private Doors doors = new Doors(3);

    @Test
    public void contestantCanChooseADoor() throws Exception {
        assertNotNull(doors.contestantChoosesDoor());
    }

    @Test
    public void hostCanRevealADoorThatIsNotACar() throws Exception {
        assertThat(doors.hostRevealsLosingDoor(), not(MontyHallProblem.CAR));
    }

    @Test
    public void contestantCanChooseAgainAfterHost() throws Exception {
        assertNotNull(doors.contestantChoosesDoor());
        assertThat(doors.hostRevealsLosingDoor(), not(MontyHallProblem.CAR));
        assertNotNull(doors.contestantChoosesDoor());
    }

}
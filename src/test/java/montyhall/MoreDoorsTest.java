package montyhall;

import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class MoreDoorsTest {

    @Rule
    public ExpectedException expect = ExpectedException.none();

    private static final int DOORS = 20;
    private Doors doors = new Doors(DOORS);

    @Test
    public void contestantCanChooseADoor() throws Exception {
        assertNotNull(doors.contestantChoosesDoor());
    }

    @Test
    public void hostCanChooseManyDoorsThatAreNotACar() throws Exception {
        for (int i = 0; i < DOORS - 2; i++) {
            assertThat(doors.hostRevealsLosingDoor(), not(MontyHallProblem.CAR));
        }
    }

    @Test
    public void contestantCanChooseAgainAfterHost() throws Exception {
        assertNotNull(doors.contestantChoosesDoor());
        assertThat(doors.hostRevealsLosingDoor(), not(MontyHallProblem.CAR));
        assertNotNull(doors.contestantChoosesDoor());
    }

    @Test
    public void contestantCanChooseAgainAfterHostHasRevealedManyGoats() throws Exception {
        assertNotNull(doors.contestantChoosesDoor());
        for (int i = 0; i < DOORS - 2; i++) {
            assertThat(doors.hostRevealsLosingDoor(), not(MontyHallProblem.CAR));
        }
        assertNotNull(doors.contestantChoosesDoor());
    }

    @Test
    public void hostRevealsTooManyDoors() throws Exception {
        expect.expect(IllegalStateException.class);
        expect.expectMessage("No more losing doors!");

        for (int i = 0; i < DOORS; i++) {
            assertThat(doors.hostRevealsLosingDoor(), not(MontyHallProblem.CAR));
        }
    }
}

package montyhall;

import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class LessDoorsTest {

    @Rule
    public ExpectedException expect = ExpectedException.none();

    private Doors doors = new Doors(2);

    @Test
    public void pickRandomDoor() throws Exception {
        assertNotNull(doors.contestantChoosesDoor());
    }

    @Test
    public void hostRevealedDoor() throws Exception {
        assertThat(doors.hostRevealsLosingDoor(), not(MontyHallProblem.CAR));
    }

    @Test
    public void whenThereAreOnlyTwoDoorsThenFail() throws Exception {
        // With only two doors and a random selection we have non-determinism. Either the host will
        // not be able to find an alternative losing door. Or there will be no more choices available
        // for the contestants second choice.
        expect.expect(Exception.class);

        assertNotNull(doors.contestantChoosesDoor());
        assertThat(doors.hostRevealsLosingDoor(), not(MontyHallProblem.CAR));
        assertNotNull(doors.contestantChoosesDoor());
    }

}
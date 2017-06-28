package montyhall;

import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class DoorsTest {

    @Rule
    public ExpectedException expect = ExpectedException.none();

    @Parameter
    public int numberOfDoors;

    private Doors doors;

    @Parameters(name = "doors {0}")
    public static Collection<Object[]> data() {
        return Arrays.asList(
            params(3),
            params(20),
            params(200)
        );
    }

    private static Object[] params(int doors) {
        return new Object[]{doors};
    }

    @Before
    public void setUp() {
        doors = new Doors(numberOfDoors);
    }

    @Test
    public void contestantCanChooseADoor() {
        assertNotNull(doors.contestantChoosesDoor());
    }

    @Test
    public void hostCanChooseManyDoorsThatAreNotACar() {
        for (int i = 0; i < numberOfDoors - 2; i++) {
            assertThat(doors.hostRevealsLosingDoor(), not(MontyHallProblem.CAR));
        }
    }

    @Test
    public void whenMoreThanTwoDoorsContestantCanChooseAgainAfterHost() {
        assertNotNull(doors.contestantChoosesDoor());
        assertThat(doors.hostRevealsLosingDoor(), not(MontyHallProblem.CAR));
        assertNotNull(doors.contestantChoosesDoor());
    }

    @Test
    public void contestantCanChooseAgainAfterHostHasRevealedManyGoats() {
        assertNotNull(doors.contestantChoosesDoor());
        for (int i = 0; i < numberOfDoors - 2; i++) {
            assertThat(doors.hostRevealsLosingDoor(), not(MontyHallProblem.CAR));
        }
        assertNotNull(doors.contestantChoosesDoor());
    }

    @Test
    public void hostRevealsTooManyDoors() {
        expect.expect(IllegalStateException.class);
        expect.expectMessage("No more losing doors!");

        for (int i = 0; i < numberOfDoors; i++) {
            assertThat(doors.hostRevealsLosingDoor(), not(MontyHallProblem.CAR));
        }
    }
}

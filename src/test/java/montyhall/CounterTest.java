package montyhall;

import static montyhall.MontyHallProblem.CAR;
import static montyhall.MontyHallProblem.GOAT;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

public class CounterTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Mock
    private Doors doors;

    private Counter counter = new Counter();

    @Test
    public void percentage() {
        assertEquals(66.6633, Counter.percentage(666633), 0.00001);
    }

    @Test
    public void winningContest() {
        when(doors.contestantChoosesDoor()).thenReturn(GOAT, CAR);
        when(doors.hostRevealsLosingDoor()).thenReturn(GOAT);

        counter.runContest(doors);

        assertThat(counter.getOriginalWins(), equalTo(0));
        assertThat(counter.getRevealedGoats(), equalTo(1));
        assertThat(counter.getSwitchedWins(), equalTo(1));
    }

    @Test
    public void losingContest() {
        when(doors.contestantChoosesDoor()).thenReturn(CAR, GOAT);
        when(doors.hostRevealsLosingDoor()).thenReturn(GOAT);

        counter.runContest(doors);

        assertThat(counter.getOriginalWins(), equalTo(1));
        assertThat(counter.getRevealedGoats(), equalTo(1));
        assertThat(counter.getSwitchedWins(), equalTo(0));
    }

    @Test
    public void stitchedUpContest() {
        when(doors.contestantChoosesDoor()).thenReturn(GOAT, GOAT);
        when(doors.hostRevealsLosingDoor()).thenReturn(GOAT);

        counter.runContest(doors);

        assertThat(counter.getOriginalWins(), equalTo(0));
        assertThat(counter.getRevealedGoats(), equalTo(1));
        assertThat(counter.getSwitchedWins(), equalTo(0));
    }

}
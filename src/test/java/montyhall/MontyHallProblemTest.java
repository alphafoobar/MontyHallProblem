package montyhall;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

@RunWith(Parameterized.class)
public class MontyHallProblemTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Spy
    private TrialsCounter counter;

    @Parameter
    public int numberOfTimes;

    @Parameters(name = "times {0}")
    public static Collection<Object[]> data() {
        return Arrays.asList(
            params(0),
            params(1),
            params(179)
        );
    }

    private static Object[] params(int times) {
        return new Object[]{times};
    }

    @Test
    public void runContestMore() {
        new MontyHallProblem(counter).runTrials(numberOfTimes, 3);

        assertThat(counter.getRevealedGoats(), equalTo(numberOfTimes));

        verify(counter, times(numberOfTimes)).play(any(Doors.class));
        verify(counter).print();
    }
}
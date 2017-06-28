package montyhall;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

public class MontyHallProblemTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Mock
    private Counter counter;

    @Test
    public void runContestOnce() {
        new MontyHallProblem(counter).runContest(1, 3);

        verify(counter).runContest(any(Doors.class));
        verify(counter).print();
    }

    @Test
    public void runContestMore() {
        new MontyHallProblem(counter).runContest(179, 3);

        verify(counter, times(179)).runContest(any(Doors.class));
        verify(counter).print();
    }
}
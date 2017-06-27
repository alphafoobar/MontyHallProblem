package montyhall;

import static montyhall.MontyHallProblem.randomIntegerLessThan;
import static org.hamcrest.number.OrderingComparison.lessThan;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class MontyHallProblemTest {

    @Test
    public void randomDoor() {
        assertThat(randomIntegerLessThan(3), lessThan(3));
    }

}
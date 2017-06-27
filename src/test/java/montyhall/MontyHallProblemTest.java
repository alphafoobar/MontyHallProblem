package montyhall;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.hamcrest.number.OrderingComparison;
import org.junit.Test;

public class MontyHallProblemTest {

    @Test
    public void percentage() {
        assertEquals(66.6633, MontyHallProblem.percentage(666633), 0.00001);
    }

    @Test
    public void randomDoor() {
        assertThat(MontyHallProblem.randomIntegerLessThan(3), OrderingComparison.lessThan(3));
    }

}
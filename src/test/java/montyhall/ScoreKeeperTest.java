package montyhall;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ScoreKeeperTest {

    @Test
    public void percentage() {
        assertEquals(66.6633, ScoreKeeper.percentage(666633), 0.00001);
    }

}
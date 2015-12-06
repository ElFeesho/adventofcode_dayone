import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class SantaFloorTest {

    private class Santa {
        public int currentFloor() {
            return 0;
        }
    }

    @Test
    public void santaStartsOnFloorZero()
    {
        Santa santa = new Santa();

        assertThat(santa.currentFloor(), is(0));
    }


}

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class SantaFloorTest {

    private class Santa {
        private int currentFloor;

        public int currentFloor() {
            return currentFloor;
        }

        public void goUpFloor() {
            currentFloor++;
        }
    }

    private class SantaInstructions {
        public SantaInstructions(String instructions) {

        }

        public void instruct(Santa santa) {
            santa.goUpFloor();
        }
    }

    @Test
    public void santaStartsOnFloorZero()
    {
        Santa santa = new Santa();

        assertThat(santa.currentFloor(), is(0));
    }

    @Test
    public void santaWilBeToldToGoUpAFloorWhenHisInstructionsTellHimTo()
    {
        SantaInstructions instructions = new SantaInstructions("(");
        Santa santa = new Santa();
        instructions.instruct(santa);
        assertThat(santa.currentFloor(), is(1));
    }


    @Test
    public void santaWilBeToldToGoDownAFloorWhenHisInstructionsTellHimTo()
    {
        SantaInstructions instructions = new SantaInstructions(")");
        Santa santa = new Santa();
        instructions.instruct(santa);
        assertThat(santa.currentFloor(), is(-1));
    }

}

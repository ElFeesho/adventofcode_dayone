import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class SantaFloorTest {
    private class CapturingSantaListener implements Santa.Listener {
        public boolean fired;

        @Override
        public void enteredBasement() {
            this.fired = true;
        }
    }

    @Test
    public void santaStartsOnFloorZero() {
        Santa santa = new Santa();

        assertThat(santa.currentFloor(), is(0));
    }

    @Test
    public void santaWilBeToldToGoUpAFloorWhenHisInstructionsTellHimTo() {
        SantaInstructions instructions = new SantaInstructions("(");
        Santa santa = new Santa();
        instructions.instruct(santa);
        assertThat(santa.currentFloor(), is(1));
    }


    @Test
    public void santaWilBeToldToGoDownAFloorWhenHisInstructionsTellHimTo() {
        SantaInstructions instructions = new SantaInstructions(")");
        Santa santa = new Santa();
        instructions.instruct(santa);
        assertThat(santa.currentFloor(), is(-1));
    }

    /**
     * (()) and ()() both result in floor 0.
     * ((( and (()(()( both result in floor 3.
     * ))((((( also results in floor 3.
     * ()) and ))( both result in floor -1 (the first basement level).
     * ))) and )())()) both result in floor -3.
     */

    @Test
    public void firstExampleIsCorrect() {
        SantaInstructions instructions = new SantaInstructions("(())");
        Santa santa = new Santa();
        instructions.instruct(santa);
        assertThat(santa.currentFloor(), is(0));
    }

    @Test
    public void secondExampleIsCorrect() {
        SantaInstructions instructions = new SantaInstructions("()()");
        Santa santa = new Santa();
        instructions.instruct(santa);
        assertThat(santa.currentFloor(), is(0));
    }

    @Test
    public void thirdExampleIsCorrect() {
        SantaInstructions instructions = new SantaInstructions("(((");
        Santa santa = new Santa();
        instructions.instruct(santa);
        assertThat(santa.currentFloor(), is(3));
    }

    @Test
    public void fourthExampleIsCorrect() {
        SantaInstructions instructions = new SantaInstructions("(()(()(");
        Santa santa = new Santa();
        instructions.instruct(santa);
        assertThat(santa.currentFloor(), is(3));
    }


    @Test
    public void fifthExampleIsCorrect() {
        SantaInstructions instructions = new SantaInstructions("())");
        Santa santa = new Santa();
        instructions.instruct(santa);
        assertThat(santa.currentFloor(), is(-1));
    }

    @Test
    public void sixthExampleIsCorrect() {
        SantaInstructions instructions = new SantaInstructions("))(");
        Santa santa = new Santa();
        instructions.instruct(santa);
        assertThat(santa.currentFloor(), is(-1));
    }

    @Test
    public void seventhExampleIsCorrect() {
        SantaInstructions instructions = new SantaInstructions(")))");
        Santa santa = new Santa();
        instructions.instruct(santa);
        assertThat(santa.currentFloor(), is(-3));
    }

    @Test
    public void eigthExampleIsCorrect() {
        SantaInstructions instructions = new SantaInstructions(")())())");
        Santa santa = new Santa();
        instructions.instruct(santa);
        assertThat(santa.currentFloor(), is(-3));
    }

    /**
     * Part two!
     */

    @Test
    public void santaWillNotifyInterestedPartiesWhenHeEntersTheBasement() {
        SantaInstructions instructions = new SantaInstructions(")");
        CapturingSantaListener capturingSantaListener = new CapturingSantaListener();
        Santa santa = new Santa(capturingSantaListener);
        instructions.instruct(santa);
        assertThat(capturingSantaListener.fired, is(true));
    }


}

import org.junit.Test;

import java.util.Stack;

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

        public void goDownFloor() {
            currentFloor--;
        }
    }

    private class SantaInstructions {
        private Stack<Character> instructionStack = new Stack<>();
        public SantaInstructions(String instructions) {
            for (char instruction : instructions.toCharArray()) {
                instructionStack.add(instruction);
            }
        }

        public void instruct(Santa santa) {
            for(Character instruction : instructionStack) {
                if (instruction == '(') {
                    santa.goUpFloor();
                } else {
                    santa.goDownFloor();
                }
            }
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

    /**
     (()) and ()() both result in floor 0.
     ((( and (()(()( both result in floor 3.
     ))((((( also results in floor 3.
     ()) and ))( both result in floor -1 (the first basement level).
     ))) and )())()) both result in floor -3.
     */

    @Test
    public void firstExampleIsCorrect()
    {
        SantaInstructions instructions = new SantaInstructions("(())");
        Santa santa = new Santa();
        instructions.instruct(santa);
        assertThat(santa.currentFloor(), is(0));
    }

    @Test
    public void secondExampleIsCorrect()
    {
        SantaInstructions instructions = new SantaInstructions("()()");
        Santa santa = new Santa();
        instructions.instruct(santa);
        assertThat(santa.currentFloor(), is(0));
    }

    @Test
    public void thirdExampleIsCorrect()
    {
        SantaInstructions instructions = new SantaInstructions("(((");
        Santa santa = new Santa();
        instructions.instruct(santa);
        assertThat(santa.currentFloor(), is(3));
    }

    @Test
    public void fourthExampleIsCorrect()
    {
        SantaInstructions instructions = new SantaInstructions("(()(()(");
        Santa santa = new Santa();
        instructions.instruct(santa);
        assertThat(santa.currentFloor(), is(3));
    }
}

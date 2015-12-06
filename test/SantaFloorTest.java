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
            if (instructionStack.pop() == '(') {
                santa.goUpFloor();
            }
            else
            {
                santa.goDownFloor();
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

}

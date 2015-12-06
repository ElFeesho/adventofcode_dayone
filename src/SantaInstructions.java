import java.util.Stack;

class SantaInstructions {
    private int executedInstructions = 0;

    private Stack<Character> instructionStack = new Stack<>();
    public SantaInstructions(String instructions) {
        for (char instruction : instructions.toCharArray()) {
            instructionStack.add(instruction);
        }
    }

    public void instruct(Santa santa) {
        for(Character instruction : instructionStack) {
            executedInstructions++;
            if (instruction == '(') {
                santa.goUpFloor();
            } else {
                santa.goDownFloor();
            }
        }
    }

    public int executedInstructionCount() {
        return executedInstructions;
    }
}

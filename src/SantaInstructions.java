import java.util.Stack;

class SantaInstructions {
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

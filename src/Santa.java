public class Santa {
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

public class Santa {
    public interface Listener
    {
        void enteredBasement();
    }

    private int currentFloor;

    public Santa()
    {

    }

    public Santa(Listener listener) {

    }

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

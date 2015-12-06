public class Santa {

    public interface Listener
    {
        Listener NULL = new Listener() {
            @Override
            public void enteredBasement() {}
        };

        void enteredBasement();
    }

    private int currentFloor;
    private final Listener listener;

    public Santa()
    {
        this.listener = Listener.NULL;
    }

    public Santa(Listener listener) {
        this.listener = listener;
    }

    public int currentFloor() {
        return currentFloor;
    }

    public void goUpFloor() {
        currentFloor++;
    }

    public void goDownFloor() {
        currentFloor--;
        if (currentFloor == -1)
        {
            listener.enteredBasement();
        }
    }
}

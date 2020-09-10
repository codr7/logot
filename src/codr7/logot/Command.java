package codr7.logot;

public interface Command {
    public static final Command TurnLeft = (r) -> {
        r.turnLeft();
        return true;
    };

    public static final Command TurnRight = (r) -> {
        r.turnRight();
        return true;
    };

    public static final Command MoveForward = (r) -> {
        return r.moveForward();
    };

    boolean execute(Robot robot);
}

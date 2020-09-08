package codr7.logot;

import java.awt.Point;
import java.util.Map;

public class Robot {
    public Robot(Room room, Language language) {
        this.room = room;
        this.position = room.getStartPosition();
        this.direction = Direction.North;
        this.language = language;
    }

    public void turnLeft() {
        switch (direction) {
            case North:
                direction = Direction.West;
                break;
            case East:
                direction = Direction.North;
                break;
            case South:
                direction = Direction.East;
                break;
            case West:
                direction = Direction.South;
                break;
        }
    }

    public void turnRight() {
        for (int i = 0; i < 3; i++) {
            turnLeft();
        }
    }

    public boolean moveForward() {
        int x = position.x, y = position.y;

        switch (direction) {
            case North:
                y--;
                break;
            case East:
                x++;
                break;
            case South:
                y++;
                break;
            case West:
                x--;
                break;
        }

        Point newPosition = new Point(x, y);

        if (room.contains(newPosition)) {
            position = newPosition;
            return true;
        }

        return false;
    }

    public boolean execute(String commands) {
        for (int i = 0; i < commands.length(); i++) {
            Command c = language.getCommand(commands.charAt(i));

            if (c == null) {
                System.out.printf("Invalid command at %d", i);
                return false;
            }

            if (!c.execute(this)) {
                System.out.printf("Failed executing command at %d", i);
                return false;
            }
        }

        System.out.printf(
                "%d %d %c",
                position.x, position.y, language.formatDirection(direction));
    }

    private Room room;
    private Point position;
    private Direction direction;
    private Language language;
}

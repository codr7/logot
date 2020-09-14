package codr7.logot;

import java.awt.Point;

public class Robot {
    public Robot(Language language, Room room) {
        this.language = language;
        this.room = room;
        this.position = room.getStartPosition();
        this.direction = Direction.North;
    }

    public Point position() {
        return position;
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

    public void execute(String commands) {
        for (int i = 0; i < commands.length(); i++) {
            char cid = commands.charAt(i);
            Command c = language.getCommand(cid);

            if (c == null) {
                System.out.println(language.getMessage("invalid-command", i, cid));
                break;
            }

            if (!c.execute(this)) {
                System.out.println(language.getMessage("failed-executing", i, cid));
                break;
            }
        }

        System.out.printf(
                "%d %d %c\n",
                position.x, position.y, language.formatDirection(direction));
    }

    private final Language language;
    private final Room room;
    private Point position;
    private Direction direction;
}

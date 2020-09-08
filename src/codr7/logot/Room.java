package codr7.logot;

import java.awt.Point;

public interface Room {
    Point getStartPosition();
    boolean contains(Point position);
}

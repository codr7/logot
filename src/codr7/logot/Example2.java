package codr7.logot;

import java.awt.Point;
import java.awt.geom.Ellipse2D;

public class Example2 implements Room {
    @Override
    public Point getStartPosition() {
        return new Point(0, 0);
    }

    @Override
    public boolean contains(Point position) {
        return shape.contains(position.x, position.y);
    }

    private Ellipse2D shape = new Ellipse2D.Float(-10, -10, 20, 20);
}

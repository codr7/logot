package codr7.logot;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Example1 implements Room {
    @Override
    public Point getStartPosition() {
        return new Point(1, 2);
    }

    @Override
    public boolean contains(Point position) {
        return shape.contains(position.x, position.y);
    }

    private Rectangle shape = new Rectangle(5, 5);
}


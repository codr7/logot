package codr7.logot;

import java.awt.*;

public class Example implements Room {
    public Example(Shape shape, Point startPosition) {
        this.shape = shape;
        this.startPosition = startPosition;
    }

    @Override
    public Point getStartPosition() {
        return startPosition;
    }

    @Override
    public boolean contains(Point position) {
        return shape.contains(position.x, position.y);
    }

    private final Shape shape;
    private final Point startPosition;
}

package codr7.logot;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Main {
    public static void main(String[] args) {
        Example ex1 = new Example(new Rectangle(5, 5), new Point(1, 2));
        new Robot(Language.SE, ex1).execute("HGHGGHGHG");

        Example ex2 = new Example(new Ellipse2D.Float(-10, -10, 20, 20), new Point(0, 0));
        new Robot(Language.EN, ex2).execute("RRFLFFLRF");
        
        // TODO add tests
    }
}

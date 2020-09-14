package codr7.logot;

import org.testng.annotations.Test;

import java.awt.*;

import static org.testng.Assert.*;

public class CommandTest {
    @Test
    public void navigation() {
        Example room = new Example(new Rectangle(5, 5), new Point(0, 0));
        Robot robot = new Robot(Language.SE, room);

        assertFalse(Command.MoveForward.execute(robot));

        Command.TurnRight.execute(robot);
        assertTrue(Command.MoveForward.execute(robot));

        for (int i = 0; i < 3; i++) { Command.TurnLeft.execute(robot); }
        assertTrue(Command.MoveForward.execute(robot));

        Point pos = robot.position();
        assertEquals(pos.x, 1);
        assertEquals(pos.y, 1);
    }
}
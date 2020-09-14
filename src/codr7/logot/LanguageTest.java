package codr7.logot;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class LanguageTest {
    @Test
    public void se() {
        assertEquals(Language.SE.getCommand('V'), Command.TurnLeft);
        assertEquals(Language.SE.getCommand('H'), Command.TurnRight);
        assertEquals(Language.SE.getCommand('G'), Command.MoveForward);
    }

    @Test
    public void en() {
        assertEquals(Language.EN.getCommand('L'), Command.TurnLeft);
        assertEquals(Language.EN.getCommand('R'), Command.TurnRight);
        assertEquals(Language.EN.getCommand('F'), Command.MoveForward);
    }
}
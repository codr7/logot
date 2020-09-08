package codr7.logot;

import java.util.HashMap;
import java.util.Map;

public abstract class Language {
    public static class English extends Language {
        public English() {
            commands.put('L', Command.TurnLeft);
            commands.put('R', Command.TurnRight);
            commands.put('F', Command.MoveForward);
        }

        @Override
        public char formatDirection(Direction direction) {
            switch (direction) {
                case North:
                    return 'N';
                case East:
                    return 'E';
                case South:
                    return 'S';
                case West:
                    return 'W';
            }

            throw new RuntimeException("Invalid direction");
        }
    }

    public static final Language EN = new English();

    public static class Swedish extends Language {
        public Swedish() {
            commands.put('V', Command.TurnLeft);
            commands.put('H', Command.TurnRight);
            commands.put('G', Command.MoveForward);
        }

        @Override
        public char formatDirection(Direction direction) {
            switch (direction) {
                case North:
                    return 'N';
                case East:
                    return 'Ö';
                case South:
                    return 'S';
                case West:
                    return 'V';
            }

            throw new RuntimeException("Invalid direction");
        }
    }

    public static final Language SE = new Swedish();

    public Command getCommand(char command) {
        return commands.get(command);
    }

    public abstract char formatDirection(Direction direction);

    protected Map<Character, Command> commands = new HashMap<>();
}

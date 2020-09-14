package codr7.logot;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

public abstract class Language {
    public static class English extends Language {
        public English() {
            super("en", "US");
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
            super("sv", "SE");
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

    public Language(String code, String countryCode) {
        messages = ResourceBundle.getBundle("messages", new Locale(code, countryCode));
    }

    public Command getCommand(char command) {
        return commands.get(command);
    }

    public String getMessage(String id, Object...args) {
        return String.format(messages.getString(id), args);
    }

    public abstract char formatDirection(Direction direction);

    protected final Map<Character, Command> commands = new HashMap<>();
    private final ResourceBundle messages;
}

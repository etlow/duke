import java.util.List;

class ByeCommand implements Command {
    @Override
    public List<String> run(String[] command) {
        return List.of("Bye. Hope to see you again soon!");
    }

    @Override
    public boolean isExit() {
        return true;
    }
}

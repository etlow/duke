import java.util.ArrayList;
import java.util.List;

public class Event extends TimeTask {
    Event(String description, String time) {
        super(description, time);
    }

    static Command getCommand(TaskList tasks, Storage storage) {
        return words -> {
            List<String> wordList = List.of(words);
            int separator = wordList.indexOf("/at");
            if (separator == -1) {
                throw new DukeException("An event must have a time.");
            } else if (separator == 1) {
                throw new DukeException("The description of an event cannot be empty.");
            } else if (separator == words.length - 1) {
                throw new DukeException("The time of an event cannot be empty.");
            }
            String description = String.join(" ", wordList.subList(1, separator));
            String time = String.join(" ", wordList.subList(separator + 1, words.length));
            Task task = new Event(description, time);
            tasks.add(task);
            storage.store(tasks.getAsLines());
            return List.of("Got it. I've added this task:", "  " + task,
                    "Now you have " + tasks.size() + " tasks in the list.");
        };
    }

    @Override
    List<String> getSaveList() {
        List<String> list = new ArrayList<>();
        list.add("E");
        list.addAll(super.getSaveList());
        list.add(getSaveTimeString());
        return list;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (at: " + getTimeString() + ")";
    }
}

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

class Storage {
    private Path path;

    Storage(String location) {
        path = Paths.get(location);
    }

    void store(List<String> lines) throws IOException {
        Files.write(path, lines);
    }

    List<String> load() throws IOException {
        return Files.readAllLines(path);
    }
}

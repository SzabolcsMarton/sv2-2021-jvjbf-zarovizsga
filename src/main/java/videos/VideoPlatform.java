package videos;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;


public class VideoPlatform {

    private List<Channel> channels = new ArrayList<>();

    public void readDataFromFile(Path path) {
        try {
            List<String> lines = Files.readAllLines(path);
            lines.remove(0);
            for (String actual : lines) {
                String[] line = actual.split(";");
                channels.add(new Channel(line[0], Integer.parseInt(line[1]), Integer.parseInt(line[2])));
            }

        } catch (IOException ioe) {
            throw new IllegalArgumentException("Cannot open file for read!", ioe);
        }
    }

    public List<Channel> getChannels() {
        return channels;
    }

    public int calculateSumOfVideos() {
        return channels.stream().mapToInt(Channel::getNumber_of_videos).sum();
    }
}

package hw17.util;

import hw16.person.Person;
import hw17.mapper.PersonCsvMapper;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class NioUtils {
    public static final String DEFAULT_DIRECTORY_PATH = "output";
    public static final String DEFAULT_FILE_PATH = DEFAULT_DIRECTORY_PATH + "/result.csv";
    public static final String DEFAULT_IMAGE_FILE_PATH = "result.jpg";

    public static void createEmptyDirectory() {
        Path path = Paths.get(DEFAULT_DIRECTORY_PATH);

        if (!Files.exists(path)) {
            try {
                Files.createDirectory(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void createCsvFile() {
        Path directoryPath = Paths.get(DEFAULT_DIRECTORY_PATH);
        Path path = Paths.get(DEFAULT_FILE_PATH);

        if (Files.exists(directoryPath) && !Files.exists(path)) {
            try {
                Files.createFile(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void writePersonsToCsvFile(List<Person> persons) {
        Path path = Paths.get(DEFAULT_FILE_PATH);
        PersonCsvMapper personCsvMapper = new PersonCsvMapper();
        List<String> csvPersons = persons.stream()
                .map(personCsvMapper::toCsv)
                .toList();

        if (Files.exists(path)) {
            try {
                Files.write(path, csvPersons);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void loadImageFileByUrl(String url) {
        Path imageFilePath = Paths.get(DEFAULT_IMAGE_FILE_PATH);

        if (!Files.exists(imageFilePath)) {
            try (ReadableByteChannel readableByteChannel = Channels.newChannel(new URL(url).openStream());
                 FileOutputStream fileOutputStream = new FileOutputStream(DEFAULT_IMAGE_FILE_PATH)) {

                fileOutputStream.getChannel().transferFrom(readableByteChannel, 0, Long.MAX_VALUE);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void reset() {
        Path filePath = Paths.get(DEFAULT_FILE_PATH);
        Path directoryPath = Paths.get(DEFAULT_DIRECTORY_PATH);
        Path imageFilePath = Paths.get(DEFAULT_IMAGE_FILE_PATH);

        try {
            Files.deleteIfExists(filePath);
            Files.deleteIfExists(directoryPath);
            Files.deleteIfExists(imageFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package hw17;

import hw16.person.Person;
import hw16.person.Sex;
import hw17.mapper.PersonCsvMapper;
import hw17.util.NioUtils;
import org.junit.jupiter.api.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Testing methods of NioUtils class")
class NioUtilsTest {

    @Test
    @DisplayName("The image file should be loaded into the root of the project with the name \"result.jpg\"")
    void loadImageFileByUrl_Should_LoadAndSaveImageFileByUrl_When_ImageFileDoesNotExist() {
        String imageFileUrl = "https://pbs.twimg.com/profile_images/1509961758022139904/fXryqX_6_400x400.jpg";

        NioUtils.loadImageFileByUrl(imageFileUrl);
        boolean exists = check(NioUtils.DEFAULT_IMAGE_FILE_PATH);

        assertThat(exists).isTrue();
    }

    @Nested
    @DisplayName("Testing methods of NioUtils class with created directory")
    class NioUtilsWithDirectoryTest {

        @BeforeEach
        void createDirectory() {
            NioUtils.createEmptyDirectory();
        }

        @Test
        @DisplayName("A directory should be created in the root of the project with the name \"output\"")
        void createEmptyDirectory_Should_CreateEmptyDirectoryByDefaultDirectoryPath_When_DirectoryDoesNotExist() {
            boolean exists = check(NioUtils.DEFAULT_DIRECTORY_PATH);

            assertThat(exists).isTrue();
        }

        @Nested
        @DisplayName("Testing methods of NioUtils class with created file with the created file")
        class NioUtilsWithFileTest {

            @BeforeEach
            void creteFile() {
                NioUtils.createCsvFile();
            }

            @Test
            @DisplayName("A csv file should be created in the \"output\" directory with the name \"result.csv\"")
            void createCsvFile_Should_CreateCsvFileByDefaultCsvFilePath_When_CsvFileDoesNotExistAndDirectoryExists() {
                boolean exists = check(NioUtils.DEFAULT_FILE_PATH);

                assertThat(exists).isTrue();
            }

            @Test
            @DisplayName("The list of people should be written in csv format in a csv file \"result.csv\"")
            void writePersonsToCsvFile_Should_WritePeopleToCsvFileInCsvFormat_When_CsvFileDoesNotExist() throws IOException {
                List<Person> persons = List.of(
                        new Person("John", 38, Sex.MAN),
                        new Person("Marry", 21, Sex.WOMAN),
                        new Person("Kate", 45, Sex.WOMAN),
                        new Person("Bart", 18, Sex.MAN),
                        new Person("Luiza", 69, Sex.WOMAN)
                );
                PersonCsvMapper personCsvMapper = new PersonCsvMapper();
                List<String> expectedCsvPersons = persons.stream()
                        .map(personCsvMapper::toCsv)
                        .toList();

                NioUtils.writePersonsToCsvFile(persons);
                Path path = Paths.get(NioUtils.DEFAULT_FILE_PATH);
                List<String> actualCsvPersons = Files.readAllLines(path);

                assertThat(actualCsvPersons).containsExactlyElementsOf(expectedCsvPersons);
            }

            @Test
            @DisplayName("The image file \"result.jpg\", the csv file \"result.csv\" and the directory \"output\" should be deleted")
            void reset_Should_DeleteImageFileAndCsvFileAndDirectory_When_ImageFileAndCsvFileAndDirectoryExist() {
                NioUtils.reset();
                boolean directoryExists = check(NioUtils.DEFAULT_DIRECTORY_PATH);
                boolean fileExists = check(NioUtils.DEFAULT_FILE_PATH);
                boolean imageFileExists = check(NioUtils.DEFAULT_IMAGE_FILE_PATH);

                assertThat(directoryExists).isFalse();
                assertThat(fileExists).isFalse();
                assertThat(imageFileExists).isFalse();
            }
        }
    }

    @AfterEach
    void reset() {
        NioUtils.reset();
    }

    private boolean check(String path) {
        Path existingPath = Paths.get(path);

        return Files.exists(existingPath);
    }
}

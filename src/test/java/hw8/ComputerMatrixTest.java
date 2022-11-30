package hw8;

import hw8.computer.Computer;
import hw8.computer.ComputerUsePurpose;
import hw8.computer.OperatingSystem;
import hw8.matrix.MatrixUtils;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Testing methods of the Computer and Matrix classes")
class ComputerMatrixTest {
    private Computer computer;

    @BeforeEach
    void initialize() {
        computer = Computer.builder()
                .name("Serhiy's PC")
                .cores(8)
                .ram(16)
                .operatingSystem(OperatingSystem.WINDOWS)
                .build();
    }

    @Test
    @DisplayName("The returned boolean value of true should describe the computer compliance with the specified requirements")
    void meetRequirements_Should_ReturnTrue_When_ComputerMeetsSpecifiedRequirements() {
        int eightGbRam = 8;
        int eightCores = 8;

        assertThat(computer.meetRequirements(eightGbRam, eightCores, OperatingSystem.WINDOWS)).isTrue();
    }

    @Test
    @DisplayName("The returned boolean value of false should describe the computer non-compliance with the specified requirements")
    void meetRequirements_Should_ReturnFalse_When_ComputerDoesNotMeetSpecifiedRequirements() {
        int eightGbRam = 8;
        int thirtyTwoGbRam = 32;

        int eightCores = 8;
        int sixteenCores = 16;

        assertThat(computer.meetRequirements(eightGbRam, eightCores, OperatingSystem.MACOS)).isFalse();
        assertThat(computer.meetRequirements(eightGbRam, sixteenCores, OperatingSystem.WINDOWS)).isFalse();
        assertThat(computer.meetRequirements(thirtyTwoGbRam, eightCores, OperatingSystem.WINDOWS)).isFalse();
    }

    @Test
    @DisplayName("The returned boolean value should describe the type of purpose for using the computer")
    void usePurpose_Should_ReturnUsePurposeType_When_ComputerMeetsExpectedTypeRequirements() {
        for (ComputerUsePurpose usePurpose : ComputerUsePurpose.values()) {
            computer.setRam(usePurpose.getRam());
            computer.setCores(usePurpose.getCores());

            assertThat(computer.usePurpose()).isEqualTo(usePurpose);
        }
    }

    @Test
    @DisplayName("The returned matrix should match the transposed original matrix")
    void transpose_Should_TransposeMatrix_When_AllMatrixRowsHaveSameLength() {
        int[][] originalMatrix = {
                {1, 3, 5},
                {2, 4, 6}
        };
        int[][] expectedMatrix = {
                {1, 2},
                {3, 4},
                {5, 6}
        };
        int[][] actualMatrix = MatrixUtils.transpose(originalMatrix);

        assertThat(actualMatrix).isEqualTo(expectedMatrix);
    }
}

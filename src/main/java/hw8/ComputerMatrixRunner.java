package hw8;

import hw8.computer.Computer;
import hw8.computer.OperatingSystem;
import hw8.matrix.MatrixUtils;

public class ComputerMatrixRunner {

    public static void main(String[] args) {
        Computer computer = Computer.builder()
                .name("Serhiy's PC")
                .cores(8)
                .ram(16)
                .operatingSystem(OperatingSystem.WINDOWS)
                .build();

        int requiredRam = 8;
        int requiredCores = 8;
        OperatingSystem requiredOperatingSystem = OperatingSystem.LINUX;

        int[][] matrix = new int[][] {
                {1, 3, 5},
                {2, 4, 6}
        };

        System.out.printf("The computer meets requirements such as %d GB of RAM, %d cores and %s OS: %s.%n", requiredRam, requiredCores, requiredOperatingSystem, computer.meetRequirements(requiredRam, requiredCores, requiredOperatingSystem));
        System.out.printf("The purpose of use of computer with %d GB of RAM and %d cores: %s.%n", computer.getRam(), computer.getCores(), computer.usePurpose());
        System.out.printf("The matrix before transposing:%n%s.%n", MatrixUtils.toString(matrix));
        System.out.printf("The matrix after transposing:%n%s.", MatrixUtils.toString(MatrixUtils.transpose(matrix)));
    }
}

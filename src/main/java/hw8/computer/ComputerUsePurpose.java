package hw8.computer;

public enum ComputerUsePurpose {
    HOME(8, 2),
    OFFICE(8, 4),
    GAMING(16, 6);

    private final int ram;
    private final int cores;

    ComputerUsePurpose(int ram, int cores) {
        this.ram = ram;
        this.cores = cores;
    }

    public int getRam() {
        return ram;
    }

    public int getCores() {
        return cores;
    }
}

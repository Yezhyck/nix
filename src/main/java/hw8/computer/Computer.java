package hw8.computer;

import java.util.Objects;
import java.util.UUID;

public class Computer {
    private int ram;
    private int cores;
    private String name;
    private UUID number;
    private OperatingSystem operatingSystem;

    public Computer(int ram, int cores, String name, OperatingSystem operatingSystem) {
        this.ram = ram;
        this.cores = cores;
        this.name = name;
        this.operatingSystem = operatingSystem;
        this.number = UUID.randomUUID();
    }

    public boolean meetRequirements(int ram, int cores, OperatingSystem operatingSystem) {
        return this.ram >= ram && this.cores >= cores && this.operatingSystem == operatingSystem;
    }

    public ComputerUsePurpose usePurpose() {
        ComputerUsePurpose gaming = ComputerUsePurpose.GAMING;
        ComputerUsePurpose office = ComputerUsePurpose.OFFICE;

        if (ram >= gaming.getRam() && cores >= gaming.getCores()) return gaming;
        else if (ram >= office.getRam() && cores >= office.getCores()) return office;
        else return ComputerUsePurpose.HOME;
    }

    public static ComputerBuilder builder() {
        return new ComputerBuilder();
    }

    @Override
    public String toString() {
        return "computer.Computer{" +
                "ram=" + ram +
                ", cores=" + cores +
                ", name='" + name + '\'' +
                ", number=" + number +
                ", operatingSystem=" + operatingSystem +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Computer computer = (Computer) o;
        return ram == computer.ram && cores == computer.cores && name.equals(computer.name) && number.equals(computer.number) && operatingSystem == computer.operatingSystem;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ram, cores, name, number, operatingSystem);
    }

    public static class ComputerBuilder {
        private int ram;
        private int cores;
        private String name;
        private OperatingSystem operatingSystem;

        public ComputerBuilder ram(int ram) {
            this.ram = ram;
            return this;
        }

        public ComputerBuilder cores(int cores) {
            this.cores = cores;
            return this;
        }

        public ComputerBuilder name(String name) {
            this.name = name;
            return this;
        }

        public ComputerBuilder operatingSystem(OperatingSystem operatingSystem) {
            this.operatingSystem = operatingSystem;
            return this;
        }

        public Computer build() {
            return new Computer(ram, cores, name, operatingSystem);
        }
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getCores() {
        return cores;
    }

    public void setCores(int cores) {
        this.cores = cores;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getNumber() {
        return number;
    }

    public void setNumber(UUID number) {
        this.number = number;
    }

    public OperatingSystem getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(OperatingSystem operatingSystem) {
        this.operatingSystem = operatingSystem;
    }
}

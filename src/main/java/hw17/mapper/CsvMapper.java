package hw17.mapper;

@FunctionalInterface
public interface CsvMapper<T> {
    String toCsv(T object);
}

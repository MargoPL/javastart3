package pl.kszafran.sda.algo.exercises;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Exercises3 {

    /**
     * Znajduje wszystkie pliki o nazwie pasującej do podanego wyrażenia regularnego
     * w podanym katalogu i wszystkich jego podkatalogach.
     * <p>
     * Zwrócone pliki są posortowane alfabetycznie po pełnej ścieżce (nie tylko nazwie pliku).
     * <p>
     * Jeśli directory wskazuje na plik, zwrócona lista ma zawierać tylko ten plik
     * (jeśli jego nazwa pasuje do wyrażenia regularnego).
     * <p>
     * Uwaga: należy skupić się na klasach z pakietu java.io.
     */
    public List<File> findFiles(File directory, String regex) throws IOException {
        List<File> fileList = new ArrayList<>();
        if (directory.isFile()) {
            fileList.add(directory);
        } else {
            File[] fileList1 = directory.listFiles();
            for (File file : fileList1 != null ? fileList1 : new File[0]) {
                if (file.isFile()) {
                    if (file.getName().matches(regex))
                        fileList.add(file);
                } else {
                    findFiles(file, regex);
                    fileList.addAll(findFiles(file, regex));
                }
            }
        }
        if (!directory.exists()) {
            return fileList;
        }
        fileList.stream().filter(e -> e.getName().contains(regex)).collect(Collectors.toList());
        return fileList;
    }

    /**
     * Działa tak samo jak findFiles().
     * <p>
     * Uwaga: należy korzystac z dobrodziejstw pakietu java.nio.file.
     */
    public Stream<Path> findFilesNIO(Path directory, Pattern regex) throws IOException {
        if (!Files.exists(directory)) {
            return Stream.empty();
        }
        return Files.walk(directory)
                .filter(path -> regex.matcher(path.getFileName().toString()).matches())
                .sorted();
    }
}

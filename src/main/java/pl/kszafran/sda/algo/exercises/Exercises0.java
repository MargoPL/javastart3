package pl.kszafran.sda.algo.exercises;

import org.junit.platform.commons.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toMap;
import static java.util.stream.Collectors.toSet;
//import static java.util.stream.Collectors.joining;


/**
 * Zaimplementuj poniższe metody z użyciem wyrażeń lambda i/lub klas Stream oraz Optional.
 */

public class Exercises0 {

    /**
     * Funkcja zwraca pierwszy indeks pod którym
     * określony znak znajduje się w podanym Stringu.
     */

    public OptionalInt indexOf(String string, char c) {
        OptionalInt optionalInt = OptionalInt.of(string.indexOf(c));
        if (string.indexOf(c) == -1) {
            return OptionalInt.empty();
        }
        return optionalInt;
    }

    /**
     * Znajduje autora książki o podanym tytule.
     */
    public Optional<String> findAuthorByTitle(BookRepository repository, String title) {
        return repository.findByTitle(title).map(e -> e.author);
    }

    /**
     * Funkcja zwraca ilość liczb dodatnich w podanej liście.
     */
    public long numPositive(List<Integer> numbers) {

        return numbers.stream().filter(x -> x > 0).count();
    }

    /**
     * Funkcja zwraca listę autorów książek znajdujących się na podanej liście.
     * Wynikowa lista jest posortowana alfabetycznie oraz nie zawiera duplikatów.
     */
    public List<String> authorsOf(Book... books) {
        return Arrays.stream(books).map(e -> e.author).sorted().distinct().collect(Collectors.toList());

    }

    /**
     * Funkcja zwraca wszystkie słowa występujące w tytułach podanych książek.
     * Znaki inne niż litery i cyfry (non-word characters) są usunięte z wyrazów.
     * Zwrócone wyrazy zapisane są małymi literami.
     */
    public Set<String> keywordsIn(Book... books) {

        return Arrays.stream(books).map(Book::getTitle)
                .flatMap(e -> Stream.of(e.toLowerCase().split("\\s+")))
                .map(e -> e.replaceAll("\\W", ""))
                .filter(StringUtils::isNotBlank)
                .collect(Collectors.toSet());
    }

    /**
     * Zwraca mapę pozwalającą znaleźć książki po tytule.
     */
    public Map<String, Book> byTitle(List<Book> books) {

        return books.stream().collect(toMap(e -> e.title, e -> e));
    }

    /**
     * Zaimplementuj funkcję, która przyjmuje listę książek (List<Book>)
     * i zwraca (nie wypisuje) opisujący je, ładnie sformatowany String
     */
    public String hardTask(List<Book> books) {
        return books.stream().map(book ->"-\""+ book.getTitle()+"\" by " + book.getAuthor() + " ("
                + (book.getNumEditions()!=1? book.getNumEditions() + " editions)": book.getNumEditions() + " edition)") )
                .collect(Collectors.joining("\n"));
    }



//    public String hardTask(List<Book> books) {
//        return books.stream()
//                .map(book -> format(book))
//                .collect(joining("\n"));
//    }
//
//    private String format(Book book) {
//        return "- \"" + book.getTitle() + "\" by " + book.getAuthor() + " (" + pluralize(book.getNumEditions(), "edition") + ")";
//    }
//
//    private String pluralize(int number, String word) {
//        return number + " " + word + (number == 1 ? "" : "s");
//    }



        /**
         * Zaimplementuj funkcję, która przyjmuje listę liczb (List<Long>)
         * i zwraca NOWĄ listę z każdą liczbą pomnożoną przez 2.
         */
    public static List<Long> easyTask(List<Long> numbers) {

        return numbers.stream().map(e -> 2 * e).collect(Collectors.toList());
    }

    ////////////////////////////////////////////
    //                                        //
    // PONIŻEJ ZADANIA DODATKOWE DLA CHĘTNYCH //
    //                                        //
    ////////////////////////////////////////////

    /*
     * Zmodyfikuj metodę byAuthor oraz odpowiadający jej test
     * aby zwracała obiekt klasy Multimap z biblioteki Guava.
     *
     * Uwaga: musisz dodać tę bibliotekę do zależności projektu.
     */

    /**
     * Zwraca mapę pozwalającą znaleźć książki po autorze.
     */
    public Map<String, Set<Book>> byAuthor(List<Book> books) {
        return books.stream().collect(groupingBy(Book::getAuthor, toSet()));
    }

    /**
     * Funkcja zwraca z podanej list książkę, która ma najwięcej edycji.
     * Jeśli więcej niż jedna książka ma tyle samo edycji, zwrócona jest książka pierwsza w kolejności.
     * <p>
     * Podpowiedź: przyda się funkcja Stream.reduce.
     */
    public Optional<Book> findMostEditions(Book... books) {
        return Arrays.stream(books)
                .reduce(((book1, book2) -> book1.getNumEditions() < book2.getNumEditions() ? book2 : book1));
    }

    public interface BookRepository {
        Optional<Book> findByTitle(String title);
    }

    public static class Book {

        private final String title;
        private final String author;
        private final int numEditions;

        Book(String title, String author, int numEditions) {
            this.title = title;
            this.author = author;
            this.numEditions = numEditions;
        }

        public String getTitle() {

            return title;
        }

        public String getAuthor() {

            return author;
        }

        public int getNumEditions() {

            return numEditions;
        }
    }
}

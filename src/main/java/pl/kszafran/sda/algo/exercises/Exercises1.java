package pl.kszafran.sda.algo.exercises;

import java.util.Set;

/**
 * Zaimplementuj poniższe metody Z WYKORZYSTANIEM REKURENCJI.
 */
public class Exercises1 {

    /**
     * Oblicza silnię argumentu n. Zwraca 1 dla n = 0.
     */
    public int factorial(int n) {
        return n == 0 ? 1 : n * factorial(n - 1);
    }

    /**
     * Zaimplementuj funkcję rekurencyjną,
     * która oblicza n-tą potęgę podanej liczby.
     */
    private static double mediumTask(double number, int n) {

        return n == 0 ? 1 : number * mediumTask(number, n - 1);

    }

    /**
     * Oblicza sumę wszystkich liczb w podanej tablicy.
     * Uwaga: aby policzyć sumę rekurencyjnie, potrzebna będzie dodatkowa metoda.
     */
    public int sum(int[] numbers) {
        return sum(numbers, 0);
    }

    private int sum(int[] numbers, int offset) {
        return offset == numbers.length ? 0 : numbers[offset] + sum(numbers, offset + 1);
    }

    /**
     * Odwraca podany napis, np. dla "test" zwraca "tset".
     */
    public String reverse(String text) {
        return reverse(text, text.length() - 1);

    }

    private String reverse(String text, int offset) {
        return text.isEmpty() || offset < 0 ? "" : text.charAt(offset) + reverse(text, offset - 1);
    }

    /**
     * Oblicza NWW (najmniejszą wspólną wielokrotnosć) podanych argumentów.
     * <p>
     * (po angielsku LCM - Least Common Multiple)
     * <p>
     * Podpowiedź:
     * NWW(a, b) = a * b / NWD(a, b)
     * NWW(a1, a2, ..., an) = NWW(a1, NWW(a2, a3, ..., an))
     *
     * @throws IllegalArgumentException jeśli któryś z argument jest ujemny lub gdy nie podano żadnych argumentów
     */
    public int lcm(int... numbers) {

        throw new UnsupportedOperationException("Not implemented yet");
    }

    ////////////////////////////////////////////
    //                                        //
    // PONIŻEJ ZADANIA DODATKOWE DLA CHĘTNYCH //
    //                                        //
    ////////////////////////////////////////////

    /**
     * Zwraca wszystkie możliwe permutacje podanego ciągu (różnych) znaków.
     * Np. dla "123" zwraca ["123", "132", "213", "231", "312", "321"].
     */
    public Set<String> permutations(String string) {

        throw new UnsupportedOperationException("Not implemented yet");
    }
}

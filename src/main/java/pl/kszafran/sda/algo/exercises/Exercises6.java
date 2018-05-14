package pl.kszafran.sda.algo.exercises;

import org.junit.platform.engine.support.hierarchical.Node;

import java.util.*;

/**
 * Zaimplementuj poniższe metody operujące na drzewie binarnym.
 */
public class Exercises6 {

    /**
     * Przechodzi podane drzewo w kolejności pre-order i zwraca listę
     * elementów w kolejności takiej, w jakiej były napotkane.
     * <p>
     * Uwaga: metodę należy zaimplementować z wykorzystaniem rekurencji.
     */
    public <T> List<T> traversePreOrder(SdaTree<T> tree) {
        List<T> treePreOrder = new ArrayList<>();
        treePreOrder.add(tree.getValue());
        tree.getLeftChild().ifPresent(child -> treePreOrder.addAll(traversePreOrder(child)));
        tree.getRightChild().ifPresent(child -> treePreOrder.addAll(traversePreOrder(child)));

//        if (tree.getLeftChild().isPresent()) {
//            treePreOrder.addAll(traversePreOrder(tree.getLeftChild().get()));
//        }
//        if (!tree.getRightChild().equals(Optional.empty())) {
//            treePreOrder.addAll(traversePreOrder(tree.getRightChild().get()));
//        }
        return treePreOrder;
    }

    /**
     * Przechodzi podane drzewo w kolejności in-order i zwraca listę
     * elementów w kolejności takiej, w jakiej były napotkane.
     * <p>
     * Uwaga: metodę należy zaimplementować z wykorzystaniem rekurencji.
     */
    public <T> List<T> traverseInOrder(SdaTree<T> tree) {
        List<T> treeInOrder = new ArrayList<>();
        tree.getLeftChild().ifPresent(child -> treeInOrder.addAll(traverseInOrder(child)));
        treeInOrder.add(tree.getValue());
        tree.getRightChild().ifPresent(child -> treeInOrder.addAll(traverseInOrder(child)));

//        if (tree.getLeftChild().isPresent()) {
//            treeInOrder.addAll(traverseInOrder((tree.getLeftChild().get())));
//        }
//        treePreOrder.add(tree.getValue());
//        if (tree.getRightChild().isPresent()) {
//            treeInOrder.addAll(traverseInOrder(tree.getRightChild().get()));
//        }
        return treeInOrder;
    }

    /**
     * Przechodzi podane drzewo w kolejności post-order i zwraca listę
     * elementów w kolejności takiej, w jakiej były napotkane.
     * <p>
     * Uwaga: metodę należy zaimplementować z wykorzystaniem rekurencji.
     */
    public <T> List<T> traversePostOrder(SdaTree<T> tree) {
        List<T> treePostOrder = new ArrayList<>();
        tree.getLeftChild().ifPresent(child -> treePostOrder.addAll(traversePostOrder(child)));
        tree.getRightChild().ifPresent(child -> treePostOrder.addAll(traversePostOrder(child)));
        treePostOrder.add(tree.getValue());

//        if (tree.getLeftChild().isPresent()) {
//            treePostOrder.addAll(traversePostOrder((tree.getLeftChild().get())));
//        }
//        if (tree.getRightChild().isPresent()) {
//            treePostOrder.addAll(traversePostOrder(tree.getRightChild().get()));
//        }
//        treePostOrder.add(tree.getValue());
//
        return treePostOrder;
    }

    /**
     * Funkcja działa tak samo jak traversePreOrder.
     * <p>
     * Uwaga: metodę należy zaimplementować z wykorzystaniem stosu (bez rekurencji).
     */
    public <T> List<T> traversePreOrderIterative(SdaTree<T> tree) {
        Deque<SdaTree<T>> treePreOrderDeque = new ArrayDeque<>();
        treePreOrderDeque.push(tree);
        List<T> treePreOrderList = new ArrayList<>();

        while (!treePreOrderDeque.isEmpty()) {
            SdaTree<T> pop = treePreOrderDeque.pop();
            treePreOrderList.add(pop.getValue());

            pop.getRightChild().ifPresent(treePreOrderDeque::push);
            pop.getLeftChild().ifPresent(treePreOrderDeque::push);
        }
        return treePreOrderList;

    }

    /**
     * Przechodzi podane drzewo w kolejności level-order i zwraca listę
     * elementów w kolejności takiej, w jakiej były napotkane.
     * <p>
     * Podpowiedź: implementacja jest bardzo podobna do traversePreOrderIterative,
     * ale zamiast stosu wykorzystuje inną strukturę danych.
     */
    public <T> List<T> traverseLevelOrder(SdaTree<T> tree) {

        Deque<SdaTree<T>> treeLevelOrderDeque = new ArrayDeque<>();
        treeLevelOrderDeque.offer(tree);
        List<T> treeLevelOrderList = new ArrayList<>();

        while (!treeLevelOrderDeque.isEmpty()) {

            SdaTree<T> poll = treeLevelOrderDeque.poll();
            treeLevelOrderList.add(poll.getValue());

            poll.getLeftChild().ifPresent(treeLevelOrderDeque::offer);
            poll.getRightChild().ifPresent(treeLevelOrderDeque::offer);
        }
        return treeLevelOrderList;
    }

    /**
     * Funkcja zwraca liczbę liści w podanym drzewie.
     */
    public int countLeaves(SdaTree<?> tree) {
        if (!tree.getLeftChild().isPresent() && !tree.getRightChild().isPresent()) return 1;

        int counter = 0;

        if (tree.getLeftChild().isPresent()) {
            counter += countLeaves(tree.getLeftChild().get());
        }
        if (tree.getRightChild().isPresent()) {
            counter += countLeaves(tree.getRightChild().get());
        }
        return counter;

    }

    /**
     * Tworzy drzewo binarne na podstawie podanego tekstu.
     * <p>
     * Tekst zawiera tyle linijek, ile poziomów ma drzewo.
     * Każda linijka zawiera wartości węzłów na odpowiednim poziomie rozdzielone spacjami, po kolei,
     * czyli każda linijka zawiera dwa razy więcej wartości niż poprzednia.
     * Wartość "-" oznacza, że węzeł na danej pozycji nie istnieje.
     * <p>
     * Np. drzewo ze slajdów przedstawione byłoby jako "F\nB G\nA D - I\n- - C E - - H -",
     * czyli zapisując w wielu liniach:
     * F
     * B G
     * A D - I
     * - - C E - - H -
     * <p>
     * Uwaga: nie należy modyfikować klas SdaTree i SdaTreeImpl.
     *
     * @throws IllegalArgumentException jeśli któraś z linijek zawiera nieprawidłową ilość wartości
     */
    public SdaTree<String> buildTree1(String input) {
//        char[] chars = input.toCharArray();

        return null;
    }

    ////////////////////////////////////////////
    //                                        //
    // PONIŻEJ ZADANIA DODATKOWE DLA CHĘTNYCH //
    //                                        //
    ////////////////////////////////////////////

    /**
     * Tworzy drzewo binarne na podstawie podanego tekstu.
     * <p>
     * Każda linijka zawiera informację o parze rodzic-dziecko.
     * Format każdej linijki wygląda następująco:
     * <p>
     * left(rodzic)=dziecko
     * <p>
     * lub
     * <p>
     * right(rodzic)=dziecko
     * <p>
     * dla lewego i prawego dziecka odpowiednio.
     * <p>
     * Uwaga: nie należy modyfikować klas SdaTree i SdaTreeImpl.
     *
     * @throws IllegalArgumentException jeśli któraś z linijek jest niezgodna z powyższym formatem
     */
    public SdaTree<String> buildTree2(String input) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Funkcja oblicza wysokość drzewa.
     * <p>
     * Przypomnienie: wysokość drzewa składającego się jedynie z korzenia to 0.
     */
    public int calcHeight(SdaTree<?> tree) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Funkcja znajduje największy element w drzewie.
     */
    public <T> T findMax(SdaTree<T> tree, Comparator<T> comparator) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public interface SdaTree<T> {

        /**
         * Tworzy nowe drzewo z korzeniem o podanej wartości oraz danych poddrzewach.
         */
        static <T> SdaTree<T> of(T value, SdaTree<T> left, SdaTree<T> right) {
            return new SdaTreeImpl<>(value, left, right);
        }

        /**
         * Tworzy nowy liść drzewa (węzeł bez dzieci).
         */
        static <T> SdaTree<T> leaf(T value) {
            return new SdaTreeImpl<>(value, null, null);
        }

        /**
         * Zwraca wartość tego węzła.
         */
        T getValue();

        /**
         * Zwraca lewe poddrzewo.
         */
        Optional<SdaTree<T>> getLeftChild();

        /**
         * Zwraca prawe poddrzewo.
         */
        Optional<SdaTree<T>> getRightChild();
    }

    private static class SdaTreeImpl<T> implements SdaTree<T> {

        private final T value;
        private final SdaTree<T> left;
        private final SdaTree<T> right;

        private SdaTreeImpl(T value, SdaTree<T> left, SdaTree<T> right) {
            this.value = Objects.requireNonNull(value, "value must not be null");
            this.left = left;
            this.right = right;
        }

        @Override
        public T getValue() {
            return value;
        }

        @Override
        public Optional<SdaTree<T>> getLeftChild() {
            return Optional.ofNullable(left);
        }

        @Override
        public Optional<SdaTree<T>> getRightChild() {
            return Optional.ofNullable(right);
        }
    }
}

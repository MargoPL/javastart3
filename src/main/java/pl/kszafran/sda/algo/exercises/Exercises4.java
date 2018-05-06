package pl.kszafran.sda.algo.exercises;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Zaimplementuj poniższe metody operujące na liście wiązanej jednokierunkowej.
 */
public class Exercises4 {

    /**
     * Tworzy nową listę zawierającą podane elementy.
     */
    public <T> SdaList<T> createList(T... elements) {

        return new SdaLinkedList<>(elements);
    }

    public interface SdaList<T> extends Iterable<T> {

        /**
         * Zwraca true jeśli lista jest pusta.
         */
        boolean isEmpty();

        /**
         * Zwraca rozmiar listy (ilość elementów).
         */
        int size();

        /**
         * Zwraca pierwszy element listy.
         *
         * @throws NoSuchElementException jeśli lista jest pusta
         */
        T getFirst();

        /**
         * Zwraca ostatni element listy.
         *
         * @throws NoSuchElementException jeśli lista jest pusta
         */
        T getLast();

        /**
         * Pobiera element listy pod podanym indeksem.
         *
         * @throws IndexOutOfBoundsException jeśli indeks leży poza zakresem listy
         */
        T get(int index);

        /**
         * Usuwa wszystkie elementy z listy.
         */
        void clear();

        /**
         * Dodaje nowy element na początku listy.
         */
        void addFirst(T element);

        /**
         * Dodaje nowy element na końcu listy.
         */
        void addLast(T element);

        /**
         * Usuwa pierwszy element listy.
         *
         * @throws NoSuchElementException jeśli lista jest pusta
         */
        void removeFirst();

        /**
         * Usuwa ostatni element listy.
         *
         * @throws NoSuchElementException jeśli lista jest pusta
         */
        void removeLast();

        ////////////////////////////////////////////
        //                                        //
        // PONIŻEJ ZADANIA DODATKOWE DLA CHĘTNYCH //
        //                                        //
        ////////////////////////////////////////////

        /**
         * Zwraca iterator po elementach listy.
         *
         * @see java.lang.Iterable
         */
        @Override
        Iterator<T> iterator();

        /**
         * Zamienia element pod podanym indeksem.
         */
        void setAt(int index, T element);

        /**
         * Dodaje nowy element pod wskazanym indeksem.
         *
         * @throws IndexOutOfBoundsException jeśli indeks leży poza zakresem listy
         */
        void addAt(int index, T element);

        /**
         * Usuwa element pod wskazanym indeksem.
         *
         * @throws IndexOutOfBoundsException jeśli indeks leży poza zakresem listy
         */
        void removeAt(int index);
    }

    private static class SdaLinkedList<T> implements SdaList<T> {

        private Node<T> head;

        public SdaLinkedList(T[] elements) {
            for (int i = elements.length - 1; i >= 0; i--) {
                head = new Node<>(elements[i], head);
            }
        }

        @Override
        public boolean isEmpty() {

            if (head == null) {
                return true;
            } else return false;


        }

        @Override
        public int size() {

            int counter = 0;
            Node<T> iter = head;
            while (iter != null) {
                iter = iter.next;
                counter++;
            }
            return counter;
        }


        @Override
        public T getFirst() {
            if (head == null) throw new java.util.NoSuchElementException();
            T first = head.element;
            return first;
        }

        @Override
        public T getLast() {
            if (isEmpty()) throw new java.util.NoSuchElementException();
            Node<T> last = head;
            while (last.next != null) {
                last = last.next;
            }
            return last.element;
        }

        @Override
        public T get(int index) {
            if (index < 0) throw new IndexOutOfBoundsException(index);
            if (isEmpty()) throw new IndexOutOfBoundsException(index);
            Node<T> node = head;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            if (node == null) throw new IndexOutOfBoundsException(index);
            return node.element;
        }

        @Override
        public void clear() {

            head = null;
        }

        @Override
        public void addFirst(T element) {
            head = new Node<>(element, head);
        }

        @Override
        public void addLast(T element) {
            if (head == null) {
                addFirst(element);
            } else {
                Node<T> last = head;
                while (last.next != null) {
                    last = last.next;
                }
                last.next = new Node<>(element, null);
            }
        }

        @Override
        public void removeFirst() {
            if (head == null) throw new NoSuchElementException();
            head = head.next;
        }

        @Override
        public void removeLast() {
            if (head == null) throw new java.util.NoSuchElementException();
            if (head.next == null) {
                removeFirst();
                return;
            }
            Node<T> last = head;

            while (last.next.next != null) {
                last = last.next;
            }
            last.next = null;
        }

        ////////////////////////////////////////////
        //                                        //
        // PONIŻEJ ZADANIA DODATKOWE DLA CHĘTNYCH //
        //                                        //
        ////////////////////////////////////////////

        @Override
        public Iterator<T> iterator() {

            throw new UnsupportedOperationException("Not implemented yet");
        }

        @Override
        public void setAt(int index, T element) {

            throw new UnsupportedOperationException("Not implemented yet");
        }

        @Override
        public void addAt(int index, T element) {

            throw new UnsupportedOperationException("Not implemented yet");
        }

        @Override
        public void removeAt(int index) {

            throw new UnsupportedOperationException("Not implemented yet");
        }

        private static class Node<T> {

            private T element;
            private Node<T> next;

            private Node(T element, Node<T> next) {
                this.element = element;
                this.next = next;
            }
        }
    }
}

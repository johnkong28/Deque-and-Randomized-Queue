import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A double-ended queue that supports adding and removing items at either end.
 * @param <Item> the type of items stored in this deque
 */
public class Deque<Item> implements Iterable<Item> {

    /** A node in the doubly linked list. */
    private class Node {
        Item item;
        Node next;
        Node prev;
        public Node(Item itema){
            item = itema;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    /** Construct an empty deque. */
    public Deque() {
        // TODO: Initialize an empty linked list.
        this.head = new Node(null);
        this.tail = new Node(null);
        head.next = tail;
        head.prev = null;
        tail.prev = head;
        tail.next = null;
        size = 0;

    }

    /** Return whether the deque is empty. */
    public boolean isEmpty() {
        // TODO: Report whether this linked list contains no items.
        return size==0;
    }

    /** Return the number of items in the deque. */
    public int size() {
        // TODO: Return this linked list's item count.
        return size;
    }

    /** Add an item to the front; reject null items with IllegalArgumentException. */
    public void addFirst(Item item) {
        if (item == null){
            throw new IllegalArgumentException("e");
        }
        // TODO: Create a node and link it at the front; update head/tail pointers.
        Node newthing = new Node(item);
        newthing.next = head.next;
        newthing.prev = head;
        head.next.prev = newthing;
        head.next = newthing;
        size++;
    }

    /** Add an item to the back; reject null items with IllegalArgumentException. */
    public void addLast(Item item) {
        // TODO: Create a node and link it at the back; update head/tail pointers.
        if (item == null){
            throw new IllegalArgumentException("e");
        }
        Node newthing = new Node(item);
        newthing.prev = tail.prev;
        newthing.next = tail;
        tail.prev.next = newthing;
        tail.prev = newthing;
        size++;
    }

    /** Remove and return the front item; throw NoSuchElementException if empty. */
    public Item removeFirst() {
        // TODO: Remove the front node and update head/tail pointers.
        if (isEmpty()){
            throw new java.util.NoSuchElementException("e");
        }
        Node newfirst = head.next.next;
        Item quegg = head.next.item;
        head.next.item = null;
        head.next.next = null;
        head.next.prev = null;
        head.next = newfirst;
        newfirst.prev = head;
        size--;
        return quegg;
    }

    /** Remove and return the back item; throw NoSuchElementException if empty. */
    public Item removeLast() {
        // TODO: Remove the back node and update head/tail pointers.
        if (isEmpty()){
            throw new java.util.NoSuchElementException("e");
        }
        Node newlast = tail.prev.prev;
        Item chegg = tail.prev.item;
        tail.prev.item = null;
        tail.prev.prev = null;
        tail.prev.next = null;
        tail.prev = newlast;
        newlast.next = tail;
        size--;
        return chegg;
    }

    /** Return an iterator from front to back; next() and remove() follow the specified exceptions. */
    @Override
    public Iterator<Item> iterator() {
        // TODO: Return an iterator that follows next links from head to tail.

        return new DequeIterator();
    }

    private class DequeIterator implements Iterator<Item>{
        private Node current = head.next;
        @Override
        public boolean hasNext() {
            return current!=tail;
        }

        @Override
        public Item next() {
            if (hasNext()){
                Item old = current.item;
                current = current.next;
                return old;
            } else {
                throw new NoSuchElementException("e");
            }
        }
    }

    /** Run unit tests for the deque. */
    public static void main(String[] args) {
        // TODO: Add unit tests.
    }
}

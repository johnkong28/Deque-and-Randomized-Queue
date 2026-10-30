import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A queue that removes items uniformly at random.
 * @param <Item> the type of items stored in this randomized queue
 */
public class RandomizedQueue<Item> implements Iterable<Item> {

    private Item[] items;
    private int size;

    /** Construct an empty randomized queue. */
    public RandomizedQueue() {
        // TODO: Initialize an empty array-backed randomized queue. Resize by doubling when full and halving when quarter full.
        items = (Item[]) new Object[1];
        size = 0;

    }

    /** Return whether the randomized queue is empty. */
    public boolean isEmpty() {
        // TODO: Report whether this array-backed queue contains no items.
        return size == 0;
    }

    /** Return the number of items in the randomized queue. */
    public int size() {
        // TODO: Return this array-backed queue's item count.
        return size;
    }

    /** Add an item; reject null with IllegalArgumentException. */
    public void resize(int newsize) {
        Item[] newarray = (Item[]) new Object[newsize];
        for (int i = 0; i < size; i++){
            newarray[i] = items[i];
        }
        items = newarray;
    }
    public void enqueue(Item item) {
        // TODO: Add the item to the backing array, resizing as needed.
        if (size == items.length){
            resize(2*size);
        }
        items[size] = item;
        size++;
    }

    /** Remove and return a uniformly random item; throw NoSuchElementException if empty. */
    public Item dequeue() {
        // TODO: Pick a random index between 0 and size-1; swap the chosen item with the last item, then remove and resize as needed.
        int idx = (int) Math.floor(Math.random()*(size-1));
        Item thigamabob = items[idx];
        items[idx] = items[size--];
        items[size] = null;
        if (size <= items.length/4) {
            resize((int) items.length / 2);
        }
        return thigamabob;
    }

    /** Return a uniformly random item without removing it; throw NoSuchElementException if empty. */
    public Item sample() {
        // TODO: Pick a random index between 0 and size-1 and return that array item without removing it.
        int idx = (int) Math.floor(Math.random()*(size-1));
        return items[idx];
    }

    /** Return an independent iterator in uniformly random order; define next() and remove() exceptions. */
    @Override
    public Iterator<Item> iterator() {
        // TODO: Return an independent iterator that traverses the array items in random order.


        return new RandomizedQueueIterator();
    }
    private class RandomizedQueueIterator implements Iterator<Item>{
        private Item[] shuffledItems;
        private int current;


        RandomizedQueueIterator(){
            shuffledItems = (Item[]) new Object[size];
            int[] indexes = new int[size];
            for (int i = 0; i < size; i++){
                indexes[i] = i;
            }
            for (int i = 0; i < size; i++){
                int idx = (int) Math.floor(Math.random()*(size-1-i));

            }
        }
        @Override
        public boolean hasNext() {

            return current < size;
        }

        @Override
        public Item next() {
            Item old = shuffledItems[current];
            current++;
            return old;
        }
    }

    /** Run unit tests for the randomized queue. */
    public static void main(String[] args) {
        // TODO: Add unit tests.
    }
}

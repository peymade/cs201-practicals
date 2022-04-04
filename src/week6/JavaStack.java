package week6;

import java.util.ArrayList;

import adt.StackADT;
import adt.errors.EmptyListError;
// import adt.errors.TODOErr;

/**
 * This class represents a stack by adding/removing to the back of a Java list.
 */
public class JavaStack<T> implements StackADT<T> {
    /**
     * This arraylist datastructure does all the real work.
     */
    ArrayList<T> inner;

    public JavaStack() {
        this.inner = new ArrayList<>();
    }

    @Override
    public void push(T item) {
        // add to the back of the list
        this.inner.add(item);
    }

    @Override
    public T pop() {
        // remove from the back of the list
        if (this.isEmpty()) {
            throw new EmptyListError();
        } else {
            return this.inner.remove(inner.size() - 1);

        }
    }

    @Override
    public T peek() {
        // look at the most recently-pushed item
        // ... should be null if no such item.

        if (this.isEmpty()) {
            return null;
        } else {
            return this.inner.get(inner.size() - 1);
        }
    }

    @Override
    public boolean isEmpty() {
        // return true if this stack is empty;
        return this.inner.size() == 0;
    }

}

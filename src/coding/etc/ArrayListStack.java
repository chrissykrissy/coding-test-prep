package coding.etc;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class ArrayListStack<E> implements StackInterface<E> {
    private final ArrayList<E> list;

    public ArrayListStack() {
        this.list = new ArrayList<>();
    }

    public ArrayListStack(int capacity) {
        this.list = new ArrayList<>(capacity);
    }

    @Override
    public E push(E item) {
        list.add(item);
        return item;
    }

    @Override
    public E pop() {
        if (list.isEmpty()) {
            throw new EmptyStackException();
        }
        return list.remove(list.size() - 1);
    }

    @Override
    public E peek() {
        if (list.isEmpty()) {
            throw new EmptyStackException();
        }
        return list.get(list.size() - 1);
    }

    @Override
    public int search(Object value) {
        int index = list.lastIndexOf(value);
        if (index == -1) {
            return -1;
        }
        return list.size() - index;
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public boolean empty() {
        return list.isEmpty();
    }
}
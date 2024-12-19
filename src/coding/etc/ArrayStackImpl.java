package coding.etc;

import java.util.Arrays;
import java.util.EmptyStackException;

public class ArrayStackImpl<E> implements StackInterface<E>  {

    private static final int DEFAULT_CAPA = 10;
    private static final Object[] EMPTY_ARRAY = {};
    private Object[] array;
    private int size;

    public ArrayStackImpl() {
        this.array = EMPTY_ARRAY;
        this.size = 0;
    }

    public ArrayStackImpl(int capacity) {
        this.array = new Object[capacity];
        this.size = 0;
    }

    private void resize() {
        //빈 배열일 경우
        if (Arrays.equals(array, EMPTY_ARRAY)) {
            array = new Object[DEFAULT_CAPA];
            return;
        }

        int arrayCapacity = array.length; //현재 크기

        //가득 찰 경우
        if (size == arrayCapacity) {
            int newSize = arrayCapacity * 2;

            //배열 복사
            array = Arrays.copyOf(array, newSize);
            return;
        }

        //절반 미만일 경우
        if (size < (arrayCapacity / 2)) {
            int newCapa = (arrayCapacity/2);

            //배열 복사
            array = Arrays.copyOf(array, Math.max(DEFAULT_CAPA, newCapa));
            return;
        }
    }

    @Override
    public E push(E item) {
        if (size == array.length) {
            resize();
        }
        array[size] = item;
        size++;
        return item;
    }

    @Override
    public E pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        E item =  (E) array[size - 1];
        array[size - 1] = null;
        size--;
        resize();
        return item;
    }

    @Override
    public E peek() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        return (E) array[size - 1];
    }

    @Override
    public int search(Object value) {
        if (value == null) {
            for (int idx = size - 1; idx >= 0; idx--) {
                if (array[idx] == null) {
                    return size - idx;
                }
            }
        } else {
            for (int idx = size - 1; idx >= 0; idx--) {
                if (array[idx].equals(value)) {
                    return size - idx;
                }
            }
        }

        return -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        // 일단 절반만 줄이기, 요소들을 모두 초기화 해도 앞으로 들어올 데이터가 클 가능성
        // 삭제 과정에서 용적량을 줄임
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
        resize();
    }

    @Override
    public boolean empty() {
        return size == 0;
    }
}

import java.util.ArrayList;
import java.util.Arrays;

public class MyIntArrayList<E> {

    private int size;
    private int[] elements;

    public MyIntArrayList() {
        this(10);
    }

    public MyIntArrayList(MyIntArrayList c) {
        this.size = c.size;
        this.elements = new int[this.size];
        if (this.size != 0) {
            for (int i = 0; i < this.size; i++) {
                this.elements[i] = c.elements[i];
            }
        }
    }

    public MyIntArrayList(int initialCapacity) {
        this.elements = new int[initialCapacity];
    }

    public void add(int index, int element){
        this.size++;
        int newarr[] = new int[this.size];
        for (int i = 0; i < this.size; i++) {
            if (i < index)
                newarr[i] = this.elements[i];
            else if (i == index)
                newarr[i] = element;
            else
                newarr[i] = this.elements[i - 1];
        }
        this.elements = Arrays.copyOf(newarr, this.size + 1);
    }

    public boolean add(int e) {
        if (this.size == this.elements.length) {
            this.elements = Arrays.copyOf(this.elements, this.size * 2);
        }

        this.elements[size] = e;
        this.size++;

        return true;
    }

    public int size() {
        return this.size;
    }

    public boolean contains(int e){
        for (int i = 0; i < this.size; i++) {
            if (this.elements[i] == e) {
                return true;
            }
        }
        return false;
    }

    public int get(int index) {
        return this.elements[index];
    }

    public int indexOf(int e) {
        for (int i = 0; i < this.size; i++) {
            if (this.elements[i] == e) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(int e) {
        for (int i = this.size - 1; i >= 0; i--) {
            if (this.elements[i] == e) {
                return i;
            }
        }
        return -1;
    }

    public boolean remove(int e) {
        if (!this.contains(e)) {
            return false;
        } else {
            int index = 0;
            for (int i = 0; i < this.size; i++) {
                if (this.elements[i] == e) {
                    index = this.elements[i];
                    break;
                }
            }
            int removedElement = this.elements[index];
            for (int i = index; i < this.size; i++) {
                this.elements[i] = this.elements[i + 1];
            }
            this.size--;

            return true;
        }
    }

    public int removeElementAtIndex(int index) {
        if (index < 0 || index >= this.size) {
            // should throw IndexOutOfBoundsException
            System.out.println("Throwing IndexOutOfBoundsException when trying to" +
                    " remove element at position " + index);
            return -1;
        }

        int removedElement = this.elements[index];
        for (int i = index; i < this.size; i++) {
            this.elements[i] = this.elements[i+1];
        }
        this.size--;

        return removedElement;
    }

    public void clear() {
        this.size = 0;
    }

    public int set(int index, int e) {
        if (index < 0 || index >= this.size) {
            // should throw IndexOutOfBoundsException
            System.out.println("Throwing IndexOutOfBoundsException when trying to set" +
                    " the element " + e + " at position " + index);
            return -1;
        }

        int replacedElement = this.elements[index];
        this.elements[index] = e;
        return replacedElement;
    }

    public boolean addAll(MyIntArrayList c) {

        for (int i = 0; i < c.size; i++) {
            if (this.size == this.elements.length) {
                this.elements = Arrays.copyOf(this.elements, this.size * 2);
            }

            this.elements[size] = c.elements[i];
            this.size++;
        }
        return true;
    }

    public boolean addAll(int index, MyIntArrayList c) {
        this.size++;
        int j = 0;
        int k = index;
        boolean insert = false;
        int newarr[] = new int[this.size * 2];
        for (int i = 0; i < this.size; i++) {
            if (i < index)
                newarr[i] = this.elements[i];
            else if (i >= index && insert == false) {
                this.size++;
                this.elements[i] = c.elements[j++];
                if (j == c.size) {
                    insert = true;
                }
            }
            else
                this.size++;
                newarr[i] = this.elements[k++];
        }
        this.elements = Arrays.copyOf(newarr, this.size + 1);

        return true;
    }
}

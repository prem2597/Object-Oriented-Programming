import java.util.Arrays;
abstract class AbstractList implements ListInterface {
    int[] list;
    int size;
    public void AbstractList() {
        final int size = 10;
        list = new int[size];
    }
    public void AbstractList(int capacity) {
        size = 0;
        list = new int[capacity];
    }
    public void add(int item){

    }
    public int size() {
        return size;
    }
    public void resize() {
        list = Arrays.copyOf(list, list.length*2);
    }
    public int get(int index) {
        if (index<size && index>=0) {
            return list[index];
        }
        else {
            return -1;
        }
    }
    public abstract int indexOf(int item);
    public boolean contains(int item) {
        for (int i=0; i<size; i++) {
            if (list[i] == item) {
                return true;
            }
        } return false;
    }
    public void remove(int index) {
        if (index < size){
            for (int i = index; i<size; i++) {
                list[i] = list[i+1];
            }
            list[size-1] = 0; 
            size -= 1;
        }
    }
    public String toString() {
        if(size == 0)
            return "";
        String str = "[";
        int i = 0;
        for(i = 0; i < size - 1; i++) {
            str = str + list[i] + ",";
        }
        str = str + list[i] + "]";
        return str;
    }
}
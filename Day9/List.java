import java.util.Arrays;
class List extends AbstractList {
    public void add(int item) {
        if (size == list.length){
            this.resize();
        }
        list[this.size()] = item;
        size += 1;
        
    }
    public int indexOf(int item) {
        for (int i=0; i<size; i++) {
            if (list[i] == item) {
                return i;
            }
        } return -1;
    }
}
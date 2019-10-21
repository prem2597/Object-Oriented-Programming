/**
 * 
 */

public class List extends AbstractList {
    public void add(int item) {
        if (size == list.length){
            this.resize();
        }
        list[this.size()] = item;
        size += 1;
        
    }
    public void addAll(List lst) {
        if ((size+lst.size) >= list.length){
            this.resize();
        }
        for (int i=0; i<lst.size; i++){
            list[size] = lst.list[i];
            size += 1;
        }
    }
    public void addAll(int[] arr ){
        if ((size+arr.length) >= list.length){
            this.resize();
        }
        for (int i=0; i<arr.length; i++){
            list[size] = arr[i];
            size += 1;
        }
    }
    public int indexOf(int item) {
        for (int i=0; i<size; i++) {
            if (list[i] == item) {
                return i;
            }
        } return -1;
    }
}
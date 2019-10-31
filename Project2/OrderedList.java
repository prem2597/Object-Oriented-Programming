/**
 * 
 * @author Prem
 * @param <E>
 */
import java.util.Arrays;
class OrderedList<E extends Comparable<E>> extends AbstractList<E> {

    /**
    * The add method does what the name suggests.
    * Add an int item to the array.
    * The assumption is to store the item in the array such that
    * entire array is in sorted array.
    * The method returns void (nothing)
    * @param item element to be added.
    */
    public void add(final E item) {
        this.reSize();
        elements[size] = item;
        size++;
        Arrays.sort(elements, 0, size);
    }

    /**
     * Appends all of the elements in the specified array.
     * @param list list containing elements to be added to this list.
     * @exception InvalidIndexException when unable to get the element of list .
     */
    public void addAll(final List<E> lst) throws InvalidIndexException {
        for (int i = 0; i < lst.size(); i++) {
            this.add(lst.get(i));
        }
    }

    /**
     * Appends all of the elements in the specified array.
     * @param items list containing elements to be added to this list.
     */
    public void addAll(final E[] items) {
        for (int i = 0; i < items.length; i++) {
            this.add(items[i]);
        }
    }
}
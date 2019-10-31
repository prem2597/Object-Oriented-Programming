/**
 * List Data Type. Write a data type List.java that
 * represents an listay of homogeneous elements. 
 * Implement the following public API which can be 
 * used as an API for the rest of your course.
 * 
 * @author Praveen Garimella
 * @author Siva Sankar
 * @author Jagan
 * @author Prem
 * 
 * @since August - 2018
 */
import java.util.Arrays;

abstract class AbstractList<E extends Comparable<E>> implements ListInterface<E> {
    /**
     * an array of which holds the objects of type Comparable.
     */
    E[] elements = (E[]) new Comparable[5];

    /**
     * array size.
     */
    int size = 0;

    /**
     * increases the array size by one.
     */
    public void reSize() {
        elements = Arrays.copyOf(elements, elements.length + 1);
    }

   /**
     * Get method has to return the items that is
     * at the index position passed as an argument to the method.
     * If the item doesn't exist then return a -1 to indicate that
     * there is no element at that index.
     * How can an element not be there at a given position?
     * Well, if the position is greater than the number of items
     * in the list then that would mean the item doesn't exist.
     * How do we check if the position is greater than the
     * number of items in the list? Would size variable be useful?
     * @param index.
     * @return item.
     * @throws InvalidIndexException with a message "Index is out of range"
     */
    public E get(final int index) throws InvalidIndexException {
        if (index < 0 || index > size) {
            throw new InvalidIndexException("Index is out of range");
        }
        return elements[index];
    }

    /**
     * checks if the element is present in the list of elements.
     * if present returns true else false.
     * @param item.
     * @return boolean.
     */
    public boolean contains(final E item) {
        for (int i = 0; i < size; i++) {
            if (item.compareTo(elements[i]) == 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * The remove method does what the name suggests.
     * Removes an int item, specified by the index argument, from the list
     * It also does an additional step.
     * Think about what happens when
     * an item is removed from the middle of the list
     * It creates a hole in the list, right?
     * This would mean, all the items that are
     * to the right side of the removed item should be
     * moved to the left by one position.
     * Here is an example:
     * listay = [1,2,3,0,0,0,0,0,0,0]
     * remove(1) would remove the item 2 which is at index position 1.
     * But how do you remove the item from an listay?
     * Well, the way to remove it is to move all
     * the items, that are to the right of the removed item, to the left
     * So, the new listay looks like this.
     * listay = [1,3,0,0,0,0,0,0,0,0]
     * If the index is not in the range of 0 to size-1, then throw an
     * exception called InvalidIndexException with a message
     * "Invalid index to remove eleemnt" which is a user defined execption
     * The method returns void (nothing)
     * This method throws an exception InvalidIndexException
     * if index is invalid to remove an element
     * with a message "Invalid index to remove element"
     * @param index.
     * @throws InvalidIndexException .
     */
    public void remove(final int index) throws InvalidIndexException {
        if (index < 0 || index >= size) {
            throw new InvalidIndexException("Invalid index to remove element");
        }
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[size - 1] = null;
        size--;
    }

    /**
     * returns the size of the list.
     * @return the size of array
     */
    public int size() {
        return size;
    }

    /**
     * finds the index of the item.
     * if present returns the index or else returns -1.s
     * @param item.
     * @return int.
     */
    public int indexOf(final E item) {
        for (int i = 0; i < size; i++) {
            if (item.compareTo(elements[i]) == 0) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Returns the index of the last occurrence of the
     *  specified element in this list,
     * or -1 if this list does not contain the element.
     * More formally, returns the highest index i,
     *  or -1 if there is no such index.
     * @param item element to search for
     * @return the index of the last occurrence of the
     *  specified element in this list,
     * or -1 if this list does not contain the element
     */
    public int lastIndexOf(final E item) {
        for (int i = size; i >= 0; i--) {
            if (item.compareTo(elements[i]) == 0) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Given an item, counts the number of occurances of the item in this list.
     * @param item to be counted in this list.
     * @return the number of occurances of the item in this list.
     */
    public int count(final E item) {
        int count = 0;
        for (int i = size; i >= 0; i--) {
            if (item.compareTo(elements[i]) == 0) {
                count++;
            }
        }
        return count;
    }

    /**
     * Replaces the element at the specified position in this list
     * with the specified element.
     * @param index index of the element to replace
     * @param item element to be stored at the specified position
     * @throws InvalidIndexException if the index is out of range.
     */
    public void set(final int index, final E item) throws InvalidIndexException {
        if (index <= size && index >= 0) {
            elements[index] = item;
        }
    }

    /**
     * Returns a view of the portion of this list between
     * the specified fromIndex,
     * inclusive, and toIndex, exclusive. (If fromIndex and
     *  toIndex are equal,
     * the returned list is empty.) The returned list is
     * backed by this list,
     * so non-structural changes in the returned list are
     *  reflected in this list,
     *  and vice-versa. The returned list supports all of the optional
     * list operations.
     * @param fromIndex low endpoint (inclusive) of the subList
     * @param toIndex high endpoint (exclusive) of the subList
     * @throws InvalidIndexException if fromIndex is greater than
     *  or equal to toIndex
     * with a message "fromIndex is greater than or equal to toIndex"
     * @throws InvalidIndexException if fromIndex is less than 0 with a message
     * "fromIndex is less than 0"
     * @throws InvalidIndexException if toIndex >= size+1 with a message
     * "toIndex is greater than size"
     * @return a view of the specified range within this list
     */
    public List<E> subList(final int fromIndex, final int toIndex) throws InvalidIndexException {
        if (fromIndex >= toIndex) {
            throw new InvalidIndexException("fromIndex is greater than or equal to toIndex");
        } if (fromIndex < 0) {
            throw new InvalidIndexException("fromIndex is less than 0");
        } if (toIndex >= size + 1) {
            throw new InvalidIndexException("toIndex is greater than size");
        } if (fromIndex > size || toIndex < 0 || fromIndex > toIndex) {
            throw new InvalidIndexException("Invalid index");
        }

        List<E> newList = new List<E>();
        for (int i = fromIndex; i < toIndex; i++) {
            newList.add(elements[i]);
        }
        return newList;
    }
    /**
     * What happens when you print an object using println?
     * Java provides a method named toString that is internally
     * invoked when an object variable is used in println.
     * For example:
     * List l = new List();
     * System.out.println(l);
     * This statement is a shortcut for
     * System.out.println(l.toString());
     * So, implement the toString method to display the items
     * in the list in the square brackets notation.
     * i.e., if the list has numbers 1, 2, 3
     * return the string [1,2,3]
     * Caution: The listay may be having other elements
     * Example: [1,2,3,0,0,0,0,0,0,0]
     * toString should only return the items in the list and
     * not all the elements of the listay.
     *@return String.
     */
    public String toString() {
        if (size == 0) {
            return "";
        }
        StringBuffer str = new StringBuffer();
        str.append("[");
        for (int i = 0; i < size - 1; i++) {
            str.append(elements[i] + ",");
        }
        str.append(elements[size] + "]");
        return str.toString();
    }
    public void add(final E item) { }
    public void addAll(final E[] items) {}
    public void addAll(final List<E> lst) throws InvalidIndexException {}
    public void add(final int index, final E item) throws InvalidIndexException {}
}

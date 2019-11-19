/**
 * @author Prem
 * @param <E>
 */
public interface SetInterface<E extends Comparable<E>> {
    /**
     * adds the element to the array.
     * @param e element to be added.
     */
    void add(E e);

    /**
     * adds the list of elements to be added to the array.
     * returns nothing.
     * @param lst list of elements to be added.
     * @throws InvalidIndexException when index not in bounds.
     */
    void add(List<E> lst) throws InvalidIndexException;

    /**
     * adds the list of array of elements to be added to the array.
     * @param e array of elements to be added.
     */
    void addAll(E[] e);

    /**
     * returns the element at the index.
     * returns element of type E.
     * @param index element.
     * @exception InvalidIndexException when index is notvalid.
     * @return type E.
     */
    * The add method does what the name suggests.
    * Add an int item to the array.
    * The assumption is to store the item at the end
    E get(int index) throws InvalidIndexException;

    /**
     * returns the index of element.
     * @param item element.
     * @return index of element.
     */
    int indexOf(E item);

    /**
     * checks if the element is in array or not.
     * @param item element
     * @return boolean.
     */
    boolean contains(E item);

    /**
     * removes the element at specified index if valid.
     * @param index position in an array
     * @exception InvalidIndexException when index is not valid
     */
    void remove(int index) throws InvalidIndexException;

    /**
     * checks if the given set is subset of current set.
     * @param s set of elements.
     * @return boolean
     */
    boolean isSubSet(Set<E> s);

    /**
     * creats a new array by combining the setA and current set.
     * @param setA elements.
     * @return elelemts of type set
     */
    Set<E> union(Set<E> setA);
    
    /**
     * creats a new array by combining the common elements
     * of setA and current set.
     * @param setA elements.
     * @return elelemts of type set
     */
    Set<E> intersection(Set<E> setA);
}
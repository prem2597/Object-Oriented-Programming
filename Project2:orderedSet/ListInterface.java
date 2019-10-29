/**
 * This acts as an interface (API) for the client.
 * 
 * @author Siva Sankar
 */

public interface ListInterface<E extends Comparable<E>> {
    /**
     * Adds an item to this List.
     */
    public void add(E item);
   
    /**
     * Thid method returns the number of elements in this list.
     * if list is empty, then it returns 0 by default.
     * @return the number of elements in this list.
     */
    public int size();

    /**
     * Returns an item at a particular index from this list.
     */
    public E get(int index);

    /**
     * This method returns the index of an item. If the item is not
     * present in the list, then return -1.
     * @param item, to be used to find the index.
     * @return the index of the element if present, -1 otherwise.
     */
    public int indexOf(E item);

    /**
     * This method returns true if the item is present in this list.
     * If the item is not present, then return false.
     * @param item, to be used to find whether it is present in this
     * list.
     * @return true if item is present in this list and false otherwise.
     */
    public boolean contains(E item);
    
    /**
     * This method will removes the element at a particular index.
     * Think of once you remove the element, there will be a empty
     * space.
     * 
     * Now move all the items to the left by one position.
     * 
     * Please see the comemnts in Assignment - 2 for more details 
     * in Polymorphism and Abstract Data Type.
     * 
     * @param item, to be removed from a particular index in this list.
     */
    public void remove(int index);

    /**
     * This method adds all the elements of arr to this list.
     * @param arr the array of elements.
     */
    public void addAll(E[] arr);
    
    /**
     * This method returns the last index of the element in this list.
     * @param item to be searched in this list
     * @return the lastIndexOf item from this list
     * If the item is not there, return -1
     */
    public int lastIndexOf(E item);

    /**
     * This method returns the number of occurances 
     * of the item in this list.
     * @param item the item to be used for counting.
     * @return the number of occurnaces of the item in this list.
     * If the item is not there, return -1
     */
    public int count(E item);

    /**
     * Returns the subList of elements that are in the index range of 
     * fromIndex to toIndex
     * @param fromIndex From Index
     * @param toIndex To Index
     * @return the subList of this List based on fromIndex and toIndex
     */
    public Set<E> subList(int fromIndex, int toIndex);

    /**
     * This method adds the elements of the lst to this list.
     * @param lst to be used to add the elemtns to this list.
     */
    public void addAll(AbstractSet<E> lst);
}
/**
 * @author Prem
 * @param <E>
 */
class Set<E extends Comparable<E>> extends AbstractSet<E> {

    /**
    * The add method does what the name suggests.
    * Add an int item to the array.
    * first it checks if the item is present in the array or not.
    * if element is not present in the array then it adds into array.
    * The method returns void (nothing)
    * @param item element to be added.
    */
    public void add(final E item) {
        boolean ifPresent = false;
        for (int i = 0; i < size; i++) {
            if (item.compareTo(elements[i]) == 0) {
                ifPresent = true;
                break;
            }
        }
        if (!ifPresent) {
            this.reSize();
            elements[size] = item;
            size++;
        }
    }
    /**
    * The add method does what the name suggests.
    * Add an all the elemennts of list type E to the array.
    * first it checks if the item is present in the array or not.
    * if element is not present in the array then it adds into array.
    * The method returns void (nothing)
    * @param lst element to be added.
    * @exception InvalidIndexException when unbale to get an element of list
    */
    public void addAll(final List<E> lst) throws InvalidIndexException {
        int listSize = lst.size();
        for (int i = 0; i < listSize; i++) {
            this.add(lst.get(i));
        }
    }
    /**
    * The add method does what the name suggests.
    * Add an all the elemennts of array of type E to the array.
    * first it checks if the item is present in the array or not.
    * if element is not present in the array then it adds into array.
    * The method returns void (nothing)
    * @param items element to be added.
    */
    public void addAll(final E[] items) {
        for (int i = 0; i < items.length; i++) {
            this.add(items[i]);
        }
    }
    /**
    * The add method does what the name suggests.
    * Add an all the elemennts of list to the array.
    * first it checks if the item is present in the array or not.
    * if element is not present in the array then it adds into array.
    * The method returns void (nothing)
    * @param lst element to be added.
    * @exception InvalidIndexException when unbale to get an element of list
    */
    public void add(final List<E> lst) throws InvalidIndexException {
        int listSize = lst.size();
        for (int i = 0; i < listSize; i++) {
            this.add((E) lst.get(i));
        }
    }
}
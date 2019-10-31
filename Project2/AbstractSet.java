/**
 * @author Prem
 * @param <E>
 */
abstract class AbstractSet<E extends Comparable<E>> extends AbstractList<E>
    implements SetInterface<E> {
    /**
    * checks if the given set is subset of current set.
    * @param set set of elements.
    * @return boolean true or false
    */
    public boolean isSubSet(final Set<E> set) {
        int count = 0;
        for (int i = 0; i < set.size; i++) {
            for (int j = 0; j < size; j++) {
                if (set.elements[i].equals(elements[j])) {
                    count++;
                    break;
                }
            }
        }
        if (count == set.elements.length) {
            return true;
        }
        return false;
    }

    /**
    * creats a new array by combining the set and current set.
    * @param set elements.
    * @return unionSet elelemts of type set
    */
    public Set<E> union(final Set<E> set) {
        Set<E> unionSet = new Set<E>();
        for (int i = 0; i < size; i++) {
            unionSet.add(elements[i]);
        }
        for (int i = 0; i < set.size; i++) {
            unionSet.add(set.elements[i]);
        }
        return unionSet;
    }

    /**
    * creats a new array by combining the common elements of setA and current set.
    * @param set elements.
    * @return intersectionSet elelemts of type set
    */
    public Set<E> intersection(final Set<E> set) {
        Set<E> intersectionSet = new Set<E>();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < set.size; j++) {
                if (elements[i].equals(set.elements[j])) {
                    intersectionSet.add(set.elements[j]);
                    break;
                }
            }
        }
        return intersectionSet;
    }
    public void add(final E item) {}
    public void addAll(final List<E> lst) throws InvalidIndexException {}
    public void addAll(final E[] items) {}
    public void add(final List<E> list) throws InvalidIndexException {}
}

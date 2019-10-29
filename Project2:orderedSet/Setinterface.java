public class Setinterface<E extends Comparable<E>> extends ListInterface<E> {
    public Set<E> union(AbstractSet<E> x);
    public Set<E> intersection(AbstractSet<E> y);
}
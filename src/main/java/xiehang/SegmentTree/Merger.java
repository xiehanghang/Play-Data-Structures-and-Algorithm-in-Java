package xiehang.SegmentTree;

/**
 * 融合期，把a，b以某种方式结合在一起，由实现类来实现
 * @param <E>
 */
public interface Merger<E> {
    E merge(E a, E b);
}

package xiehang.Set;

public class LinkedListSet<E> implements Set<E>{

    private LinkedList<E> listSet;

    public LinkedListSet(){
        listSet = new LinkedList();
    }

    @Override
    public void add(E e) {
        if (!listSet.contains(e)){
            listSet.addFirst(e);
        }
    }

    @Override
    public void remove(E e) {
        listSet.removeElemenet(e);
    }

    @Override
    public boolean contains(E e) {
        return listSet.contains(e);
    }

    @Override
    public int getSize() {
        return listSet.getSize();
    }

    @Override
    public boolean isEmpty() {
        return listSet.isEmpty();
    }
}

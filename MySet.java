package Lab7;

import Lab6V2.ElectricAppliances;
import java.lang.reflect.Array;
import java.util.*;



public class MySet implements Set<ElectricAppliances> {
    private Node last = null;
    private Node first = null;
    private int size = 0;

    public MySet(){}
    public MySet (ElectricAppliances electricAppliance){
        Node node = new Node();
        node.setData(electricAppliance);
        first = last = node;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        if (!isEmpty()){
            for (int i = 0; i < size(); i++) {
                if (o == iterator().next())
                    return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<ElectricAppliances> iterator() {
        return new Iterator<>() {
            private Node currentNode = first;

            @Override
            public boolean hasNext() {
                return currentNode != null;
            }

            @Override
            public ElectricAppliances next() {
                Node result = currentNode;
                if(currentNode != null){
                    currentNode = currentNode.getNext();
                }else{
                    throw new NoSuchElementException();
                }
                return result.getData();
            }
        };
    }

    @Override
    public Object[] toArray() {
        ElectricAppliances[] array = new ElectricAppliances[size()];
        for (int i = 0; i < size(); i++) {
            array[i] = iterator().next();
        }
        return array;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        if(size() > a.length){
            a = (T[]) Array.newInstance(a.getClass().getComponentType(), size());
        } else if (size() < a.length){
            a[size] = null;
        }
        for (int i = 0; i < a.length; i++) {
            a[i] = (T) ElectricAppliances.class;
            i++;
        }return a;
    }

    @Override//ok
    public boolean add(ElectricAppliances electricAppliance) {
        if (!contains(electricAppliance)){
            Node node = new Node();
            node.setData(electricAppliance);
            if (size == 0){
                first = last = node;
            }else {
                last.setNext(node);
                node.setData(electricAppliance);
                last = node;
            }
            size ++;
            return true;
        } return false;
    }

    @Override//ok
    public boolean remove(Object o) {
        ElectricAppliances current;
        while (iterator().hasNext()){
            current = iterator().next();
            if (current == o){
                current.removeApp();
                return true;
            }
        }
        return false;
    }

    @Override//ok
    public boolean containsAll(Collection<?> c) {
        Iterator<?> iterator = c.iterator();
        while (iterator.hasNext() && contains(iterator.next())){
            if(!this.contains(iterator.next())){
                return false;
            }
        } return true;
    }

    @Override //ok
    public boolean addAll(Collection<? extends ElectricAppliances> c) {
        Iterator<? extends ElectricAppliances> iterator = c.iterator();
        boolean answer;
        boolean result = false;
        while (iterator.hasNext()){
            answer = add(iterator.next());
            if (answer){
                result = true;
            }
        }return result;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean result = true;
        Iterator<ElectricAppliances> iterator = iterator();
        while (iterator.hasNext()){
            ElectricAppliances current = iterator.next();
            result = c.contains(current);
            if(!result){
                remove(current);
            }
        }
        return result;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean result = false;
        if(!isEmpty()){
            boolean answer;
            result = true;
            Iterator<?> iterator = c.iterator();
            while (iterator().hasNext() && contains(iterator().hasNext())) {
                answer = remove(iterator.next());
                if (!answer) {
                    result = false;
                }
            }
        }
        return result;
    }

    @Override
    public void clear() {
        first = last = null;
        size = 0;
    }

    /*@Override
        public Spliterator<ElectricAppliances> spliterator() {
        boolean result = false;
        if (!isEmpty()){

        }
        return result;
    }*/
}

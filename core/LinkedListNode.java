package dj2.core;

import java.io.Serializable;

/**
 * The LinkedList class uses this class to generate nodes.
 * @author Aymane Chaoui
 */
public class LinkedListNode <T> implements Serializable {
    
    protected T value;
    protected LinkedListNode <T> next;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public LinkedListNode<T> getNext() {
        return next;
    }

    public void setNext(LinkedListNode<T> next) {
        this.next = next;
    }
    
    
}

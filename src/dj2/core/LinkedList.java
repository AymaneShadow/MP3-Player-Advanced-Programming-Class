package dj2.core;

import java.io.Serializable;

/**
 * This class is inherited by PlayList and MostRecentlyPlayedList and used by Group, MusicTrack and Album which is
 * why it is a Generic class, multiple classes depend on it. It is also used to replace all of the previous classes
 * that were used as lists, in a generic way. This class is used everywhere throughout the code.
 * @author Aymane Chaoui
 */
public class LinkedList <T> implements Serializable {
    
    protected LinkedListNode <T> head = null;
    private int size = 0;
    
    public void add(T value){
        
        LinkedListNode <T> newNode = new LinkedListNode <T> ();
        newNode.setValue(value);
        newNode.setNext(null);

        if(this.head == null)
        head = newNode;
        else
        {
            LinkedListNode <T> walker = new LinkedListNode <T> ();
            for(walker = head; walker.getNext() != null; walker = walker.getNext());
            walker.setNext(newNode);
        }
        
        size++;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    public Object[] toArray() {
        
        if(size == 0)
        return null;
        
        Object[] objects = new Object[size];
        int index = 0;
        
        for(LinkedListNode <T> walker = head; walker != null; walker = walker.next)
        objects[index++] = walker.value;
        
        return objects;
        
    }    

    public LinkedListNode<T> getHead() {
        return head;
    }
    
    public void clear(){
        this.head = null;
    }
    
    public String toString(){
        
        String string = "";
        
        for(LinkedListNode<T> walker = head; walker != null; walker = walker.getNext())
        {
            if(walker == head)
            string += walker.getValue();
            else
            string += "\n" + walker.getValue();
            
        }

        return string;        

    }
}

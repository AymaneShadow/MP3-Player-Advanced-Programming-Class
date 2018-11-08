/*
 * This is a custum exception that will be triggered anytime a code is trying to access an empty list.
 */
package exceptions;

import javax.swing.JOptionPane;

/**
 *
 * @author Aymane Chaoui
 */
public class EmptyListException extends Exception {
    
    public EmptyListException(String listName){
        
        super("There are no tracks in the " + listName);
        
        JOptionPane.showMessageDialog(null, "There are no tracks in the " + listName);
    }
}

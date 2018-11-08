package dj2.persistence;

import dj2.core.MostRecentlyPlayedList;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import java.io.IOException;

/**
 * This class is used to store the most recently played list in a file called mostRecentlyPlayedList.txt
 * at the root of this program, to save it we must only call its save() method.
 * @author Aymane Chaoui
 */
public class PersistentMostRecentlyPlayedList {
    
    private static String mostRecentlyPlayedListStoringPath = "mostRecentlyPlayedList.txt";
    private static MostRecentlyPlayedList mostRecentlyPlayedList;
    private static ObjectInputStream mostRecentlyPlayedListIn;
    private static ObjectOutputStream mostRecentlyPlayedListOut;
    
    public static void save(MostRecentlyPlayedList mostRecentlyPlayedList) throws IOException {
        if(mostRecentlyPlayedList == null)
        return;

        mostRecentlyPlayedListOut = new ObjectOutputStream(new FileOutputStream(mostRecentlyPlayedListStoringPath));
        mostRecentlyPlayedListOut.writeObject(mostRecentlyPlayedList);
        mostRecentlyPlayedListOut.close();
    }        
    
    public static MostRecentlyPlayedList load(){
        if(mostRecentlyPlayedList == null){
            try{
                mostRecentlyPlayedListIn = new ObjectInputStream(new FileInputStream(mostRecentlyPlayedListStoringPath));
                mostRecentlyPlayedList = (MostRecentlyPlayedList)mostRecentlyPlayedListIn.readObject();
                mostRecentlyPlayedListIn.close();

            }catch(Exception ex){
                mostRecentlyPlayedList = new MostRecentlyPlayedList();
            }
        }
        return mostRecentlyPlayedList;
    }
        
    
}

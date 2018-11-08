package dj2.persistence;

import dj2.core.PlayList;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import java.io.IOException;

/**
 * This class is used to store the playlist in a file called playlist.txt
 * at the root of this program, to save it we must only call its save() method.
 * @author Aymane Chaoui
 */
public class PersistentPlayList {
    
    private static String playListStoringPath = "playList.txt";
    private static PlayList playList;
    private static ObjectInputStream playListIn;
    private static ObjectOutputStream playListOut;
    
    public static void save(PlayList playList) throws IOException {
        if(playList == null)
        return;

        playListOut = new ObjectOutputStream(new FileOutputStream(playListStoringPath));
        playListOut.writeObject(playList);
        playListOut.close();
    }        
    
    public static PlayList load(){
        if(playList == null){
            try{
                playListIn = new ObjectInputStream(new FileInputStream(playListStoringPath));
                playList = (PlayList)playListIn.readObject();
                playListIn.close();

            }catch(Exception ex){
                playList = new PlayList();
            }
        }
        return playList;
    }
        
    
}

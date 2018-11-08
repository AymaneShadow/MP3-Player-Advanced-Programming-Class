package dj2.core;

import exceptions.EmptyListException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.media.MediaPlayer;
import javax.swing.JOptionPane;

/**
 * This class is a manually generated list, the end user is the one who adds tracks to it. 
 * This class extends MusicTrackList so it has got all its attributes and behaviors, plus a play method that enables
 * playing all the music tracks one by one until the list ends. Normally each track should be played until it ends.
 * However, I deliberately chosen to discard this and put only 2 second interval between each track to show that
 * the code is working.
 * @author Aymane Chaoui
 */
public class PlayList <T extends MusicTrack> extends LinkedList{

    /**
     * This method plays the whole playlist with a 2s interval between each song, for the reasons explained in the
     * class description.
     */
    public void play() throws IOException, EmptyListException{
        
        if(this.head == null)
        throw new EmptyListException("playlist.");
        else
        {   
            MusicTrack[] musicTracks = new MusicTrack[this.toArray().length];
            
            MusicTrack firstTrack = (MusicTrack) this.head.getValue();
            MediaPlayer player = firstTrack.getSimpleAudioPlayer().getMediaPlayer();
            firstTrack.play(1, 0);            
            player.play();
            
            for(int i = 0; i < this.toArray().length; i++)
            musicTracks[i] = (MusicTrack) this.toArray()[i];
            
            
            for(int i = 0; i < musicTracks.length; i++)
            {
                player = musicTracks[i].getSimpleAudioPlayer().getMediaPlayer();
                final MusicTrack nextTrack = musicTracks[(i + 1) % musicTracks.length];

                player.setOnEndOfMedia(new Runnable() {
                  @Override public void run() {
                      try 
                      {
                          nextTrack.play(1, 0);
                          
                      } catch (IOException ex) {
                          // Do nothing
                      }
                  }
                });          
            }
        } 
    }
}

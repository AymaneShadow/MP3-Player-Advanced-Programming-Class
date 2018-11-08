package dj2.core;

/**
 * This is the class that creates a media player unique to a song, it enables us to hear music
 * when used in other classes.
 * @author Aymane
 */


import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;

import javafx.scene.media.*;
import javax.swing.JOptionPane;


/** plays an audio in JavaFX 2.x */
public class SimpleAudioPlayer implements Serializable {

  private String path;
  private MediaPlayer mediaPlayer;
  
  public SimpleAudioPlayer(){
      this.path = "Just Started";
  }  
  
  public SimpleAudioPlayer(String path) throws MalformedURLException, IOException{
    
    this.path = path;
    this.mediaPlayer = createMediaPlayer(new File(".").getCanonicalPath() + "\\src\\dj2\\" + this.path);

  }
  
  public void stop(){
      
    if (this.mediaPlayer != null) {
        this.mediaPlayer.stop();
    }    
      
  }  
  
  public void play(){
      
    if (this.mediaPlayer != null) {
        this.mediaPlayer.play();
    }    
      
  }

    public void setMediaPlayer(MediaPlayer mediaPlayer) {
        this.mediaPlayer = mediaPlayer;
    }

    public MediaPlayer getMediaPlayer() {
        return mediaPlayer;
    }
  
  

  /** 
   * creates a media player using a file from the given filename path 
   * and tracks the status of playing the file via the status label 
   */
  private MediaPlayer createMediaPlayer(final String filename) throws MalformedURLException {
    File file = new File(filename);
    if (!file.exists()) {
        JOptionPane.showMessageDialog(null, "File does not exist: " + filename, "Error", JOptionPane.ERROR_MESSAGE);
    }
    final String mediaLocation = file.toURI().toURL().toExternalForm();
    Media media = new Media(mediaLocation);
    MediaPlayer mediaPlayer = new MediaPlayer(media);
    
    mediaPlayer.setOnError(new Runnable() {
      @Override public void run() {
        JOptionPane.showMessageDialog(null, "Error", "Error", JOptionPane.ERROR_MESSAGE);
      }
    });
    mediaPlayer.setOnPlaying(new Runnable() {
      @Override public void run() {
//        JOptionPane.showMessageDialog(null, "Playing: " + mediaLocation);
      }
    });
    mediaPlayer.setOnEndOfMedia(new Runnable() {
      @Override public void run() {
        JOptionPane.showMessageDialog(null, "Done");
      }
    });
    return mediaPlayer;
  }
}
package dj2.core;

import exceptions.EmptyListException;
import java.io.IOException;
import java.io.Serializable;
import javafx.scene.media.MediaPlayer;

/**
 * This is the Album class, it has got all the information about an Album and is related to all its Music Tracks.
 * @author Aymane Chaoui
 */
public class Album implements Serializable {
    
    private String title, picturePath, description, releaseDate;
    private int musicTracksNumber;
    private LinkedList <MusicTrack> albumTracks = new LinkedList <MusicTrack> ();
    
    public Album(String title, String picturePath, String description, String releaseDate, int musicTracksNumber){
        
        this.title = title;
        this.picturePath = picturePath;
        this.description = description;
        this.releaseDate = releaseDate;
        this.musicTracksNumber = musicTracksNumber;
        
    }
    
    public void addTrack(MusicTrack track){
            
            this.albumTracks.add(track);
            
	}    

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getMusicTracksNumber() {
        return musicTracksNumber;
    }

    public void setMusicTracksNumber(int musicTracksNumber) {
        this.musicTracksNumber = musicTracksNumber;
    }

    public LinkedList getAlbumTracks() {
        return albumTracks;
    }

    public void setAlbumTracks(LinkedList albumTracks) {
        this.albumTracks = albumTracks;
    }

    // This function plays the album, it takes one argument as a parameter: if this argument is 0 it will not
    // be added to the MostRecentlyPlayedList otherwise it will. This prevents an infinite loop while playing the
    // most recently played list.
    public void play() throws IOException, EmptyListException{
        
        if(albumTracks.head == null)
        throw new EmptyListException("Album.");    
        else
        {   
            MusicTrack[] musicTracks = new MusicTrack[albumTracks.toArray().length];
            
            MusicTrack firstTrack = (MusicTrack) albumTracks.head.getValue();
            MediaPlayer player = firstTrack.getSimpleAudioPlayer().getMediaPlayer();
            firstTrack.play(1, 0);            
            player.play();

            for(int i = 0; i < albumTracks.toArray().length; i++)
            musicTracks[i] = (MusicTrack) albumTracks.toArray()[i];
            
            
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
                            ex.printStackTrace();
                      }
                  }
                });          
            }
        } 
    }
    
    @Override
    public String toString() {
        return "Title: " + title + "\nPicturePath: " + picturePath + "\nDescription: " + description + "\nReleaseDate: " + releaseDate + "\nMusicTracksNumber: " + musicTracksNumber + "\n\nAlbumTracks:\n" + albumTracks;
    }
    

}

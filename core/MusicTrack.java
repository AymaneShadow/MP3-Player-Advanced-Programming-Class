package dj2.core;


import java.io.IOException;
import java.io.Serializable;

import java.net.MalformedURLException;

/**
 * This is the MusicTrack Class, it has got all the information about a music track plus it adds automatically it
 * self to mostRecentlyPlayedList if it is played.
 * @author Aymane
 */
public class MusicTrack implements Serializable {
    
    private String title, style, duration, type, path;
    private Artist artistOrGroup;
    private Album albumOrConcert;
    private MostRecentlyPlayedList <MusicTrack> mostRecentlyPlayedList;
    private transient SimpleAudioPlayer previousSimpleAudioPlayer; // This should not be serializable.
    private transient SimpleAudioPlayer simpleAudioPlayer;
    
    public MusicTrack(String title, String style, String duration, String type, String path, Artist artistOrGroup, Album albumOrConcert, MostRecentlyPlayedList mostRecentlyPlayedList, SimpleAudioPlayer previousSimpleAudioPlayer) throws IOException{
        
        this.title = title;
        this.style = style;
        this.duration = duration;
        this.type = type;
        this.path = path;
        this.artistOrGroup = artistOrGroup;
        this.albumOrConcert = albumOrConcert;
        this.mostRecentlyPlayedList = mostRecentlyPlayedList;
        this.previousSimpleAudioPlayer = previousSimpleAudioPlayer;
        this.simpleAudioPlayer = new SimpleAudioPlayer(this.path); 

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Artist getArtistOrGroup() {
        return artistOrGroup;
    }

    public void setArtistOrGroup(Artist artistOrGroup) {
        this.artistOrGroup = artistOrGroup;
    }

    public Album getAlbumOrConcert() {
        return albumOrConcert;
    }

    public void setAlbumOrConcert(Album albumOrConcert) {
        this.albumOrConcert = albumOrConcert;
    }

    public MostRecentlyPlayedList getMostRecentlyPlayedList() {
        return mostRecentlyPlayedList;
    }

    public void setMostRecentlyPlayedList(MostRecentlyPlayedList <MusicTrack> mostRecentlyPlayedList) {
        this.mostRecentlyPlayedList = mostRecentlyPlayedList;
    }

    public SimpleAudioPlayer getPreviousSimpleAudioPlayer() {
        return previousSimpleAudioPlayer;
    }

    public void setPreviousSimpleAudioPlayer(SimpleAudioPlayer previousSimpleAudioPlayer) {
        this.previousSimpleAudioPlayer = previousSimpleAudioPlayer;
    }

    public SimpleAudioPlayer getSimpleAudioPlayer() {
        return simpleAudioPlayer;
    }

    public void setSimpleAudioPlayer(SimpleAudioPlayer simpleAudioPlayer) {
        this.simpleAudioPlayer = simpleAudioPlayer;
    }
    
    
    
    // This function plays the music track, it takes one argument as a parameter: if this argument is 0 it will not
    // be added to the MostRecentlyPlayedList otherwise it will. This prevents an infinite loop while playing the
    // most recently played list.
    public void  play(int addToRecentlyPL, int playTrack) throws MalformedURLException, IOException {
        
        if(addToRecentlyPL != 0)
        mostRecentlyPlayedList.add(this);
        
        if(this.path != "Just Started" && previousSimpleAudioPlayer != null) // If we've just started (to run the program)
        {                                                                    // or there is no track that has been played
                                                                             // this code will not be executed.
            this.previousSimpleAudioPlayer.stop(); // We stop the previously played track to play the next one.

            if(playTrack == 0)
            {
                simpleAudioPlayer.play(); // We play the current track.           
            }
                previousSimpleAudioPlayer.setMediaPlayer(simpleAudioPlayer.getMediaPlayer());             
        }
       // return this.title + " by " + this.artistOrGroup.getName() + " is playing now.";
        
    }


    @Override
    public String toString() {
        
        return title;
        
//        if(albumOrConcert == null)
//        return "Title: " + title + "\nStyle: " + style + "\nDuration: " + duration + "\nType: " + type + "\nPath: " + path + "\nArtistOrGroup: " + artistOrGroup.getName() + "\nAlbumOrConcert: " + "None." + "\n";
//        
//        return "Title: " + title + "\nStyle: " + style + "\nDuration: " + duration + "\nType: " + type + "\nPath: " + path + "\nArtistOrGroup: " + artistOrGroup.getName() + "\nAlbumOrConcert: " + albumOrConcert.getTitle() + "\n";
    }
    

}

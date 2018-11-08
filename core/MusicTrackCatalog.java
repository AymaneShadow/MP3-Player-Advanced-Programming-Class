package dj2.core;

import java.io.Serializable;

/**
 * This class is used to represent all of the tabs that are in the main panel, it contains three LinkedLists
 * artistOrGroup, styles and albums.
 * @author Aymane Chaoui
 */
public class MusicTrackCatalog implements Serializable {
    
    private LinkedList <Artist> artistOrGroup;    
    private LinkedList <MusicTrack> styles;
    private LinkedList <Album> albums;
    
    private String[] categories;
    private int numberOfCategories;

    public MusicTrackCatalog(){
        
        artistOrGroup = new LinkedList <Artist> ();
        styles = new LinkedList <MusicTrack> ();
        albums = new LinkedList <Album> ();        
        
        categories = new String[3];
        numberOfCategories = 0;
    }
    
    public void add(String name){
        this.categories[this.numberOfCategories] = name;
        numberOfCategories++;        
    }
    
    public String[] getCategories() {
        return categories;
    }

    public int getNumberOfCategories() {
        return numberOfCategories;
    }   
    
    
    
    public LinkedList<Artist> getArtistOrGroup() {
        return artistOrGroup;
    }

    public void setArtistOrGroup(LinkedList<Artist> artistOrGroup) {
        this.artistOrGroup = artistOrGroup;
    }

    public LinkedList<MusicTrack> getStyles() {
        return styles;
    }

    public void setStyles(LinkedList<MusicTrack> styles) {
        this.styles = styles;
    }

    public LinkedList<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(LinkedList<Album> albums) {
        this.albums = albums;
    }    

}

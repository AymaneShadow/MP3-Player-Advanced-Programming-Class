package dj2.core;

import java.io.Serializable;

/**
 * This is the artist class, it has got all the information about him/her plus all of the related singles, albums and
 * concerts.
 * @author Aymane Chaoui
 */
public class Artist implements Serializable {
    
    private String name, picturePath, history;
    private LinkedList <MusicTrack> singles = new LinkedList <MusicTrack> ();
    private LinkedList <Album> albums = new LinkedList <Album> ();
    private LinkedList <Concert> concerts = new LinkedList <Concert> ();
    
    public Artist(String name, String picturePath, String history){
        
        this.name = name;
        this.picturePath = picturePath;
        this.history = history;
        
    }    

    public void addSingle(MusicTrack single){
            this.singles.add(single);
    }       

    public void addAlbum(Album album){
            this.albums.add(album);
    }   
    
    public void addConcert(Concert concert){
            this.concerts.add(concert);
    }   
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public LinkedList getSingles() {
        return singles;
    }

    public void setSingles(LinkedList singles) {
        this.singles = singles;
    }

    public LinkedList getAlbums() {
        return albums;
    }

    public void setAlbums(LinkedList albums) {
        this.albums = albums;
    }

    public LinkedList getConcerts() {
        return concerts;
    }

    public void setConcerts(LinkedList concerts) {
        this.concerts = concerts;
    }

    public String getSinglesString() {
        
        String string = "";
        
        for(LinkedListNode <MusicTrack> walker = this.getSingles().getHead(); walker != null; walker = walker.getNext())
        {
            if(walker == this.getSingles().getHead())
            string += walker.getValue().toString();
            else
            string += "\n" + walker.getValue().toString();
            
        }

        return string;          
    }    
    
    @Override
    public String toString() {
        return "Singles:\n" + singles + "\nAlbums:\n" + albums + "\nConcerts:\n" + concerts;
        // return "Name: " + name + "\nPicturePath: " + picturePath + "\nHistory: " + history + "\n\nSingles:\n" + singles + "\nAlbums:\n" + albums + "\nConcerts:\n" + concerts;
    }
    
    

}

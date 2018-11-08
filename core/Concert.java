package dj2.core;

import java.io.Serializable;

/**
 * This is the Concert class, it has got all the information about a Concert and is related to all its Music Tracks.
 * It extends Album which means it has got all its attributes and behaviors plus it has got a location.
 * @author Aymane
 */
public class Concert extends Album implements Serializable {
    
    private String location;
    
    public Concert(String title, String picturePath, String description, String releaseDate, int musicTracksNumber , String location){
        
        super(title, picturePath, description, releaseDate, musicTracksNumber);
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    
    @Override
    public String toString() {
        return super.toString() + "\nLocation:\n" + location;
    }
    
    
    
}

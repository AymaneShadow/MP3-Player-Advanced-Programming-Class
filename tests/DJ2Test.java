package dj2.tests;

import dj2.core.Album;
import dj2.core.Artist;
import dj2.core.Concert;
import dj2.core.Group;
import dj2.core.MostRecentlyPlayedList;
import dj2.core.MusicTrack;
import dj2.core.PlayList;
import dj2.persistence.*;
import exceptions.EmptyListException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This is the main Class, there is a bunch of mock code here and some tests to see if things are working.
 * @author Aymane Chaoui
 */
public class DJ2Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws MalformedURLException, IOException {        
        
        MostRecentlyPlayedList mostRecentlyPlayedList1 = PersistentMostRecentlyPlayedList.load();
        System.out.println("MostRecentlyPlayedList1 loaded successfuly.");
        
        try {
            mostRecentlyPlayedList1.play();
        } catch (EmptyListException ex) {
            ex.printStackTrace();
        }

        // Start of creating Most Recently Played List.
            MostRecentlyPlayedList mostRecentlyPlayedList = new MostRecentlyPlayedList();
        // End of creating Most Recently Played List. 
            
        // Start of creation of mock groups.
        Group metallica;
        
            //Group: Metallica:
                metallica = new Group("Metallica", "C:\\Users\\Aymane\\Music\\Metallica.png", "Metallica is an American heavy metal band formed in Los Angeles, California");
                metallica.addMember("James Hetfield");
                metallica.addMember("Lars Ulrich");
                metallica.addMember("Kirk Hammett");
                metallica.addMember("Robert Trujillo");
            
        // End of creation of mock groups.

        // Start of creation of mock artists.
        Artist avb;    
        
            //Artist: Armin Van Buuren:
                avb = new Artist("Armin Van Buuren", "C:\\Users\\Aymane\\Music\\avb.png", "Armin van Buuren who was born in the 25th of December, 1976 is a Dutch trance music producer, DJ and radio personality.");
                  
        // End of creation of mock artists.

        // Start of creation of mock albums.
        Album mirage, intense, masterOfPuppets;       
        
            //Artist: Armin Van Buuren:

                mirage = new Album("Mirage", "C:\\Users\\Aymane\\Music\\mirage.png", "Mirage is the fourth studio album by Dutch trance producer and DJ Armin van Buuren.", "2010", 3);
                intense = new Album("Intense", "C:\\Users\\Aymane\\Music\\intense.png", "Intense is the fifth studio album by Dutch trance producer and DJ Armin van Buuren.", "2013", 3);
            //Group: Metallica:

                masterOfPuppets = new Album("Master of Puppets", "C:\\Users\\Aymane\\Music\\Master.png", "Master of Puppets is the third studio album by American heavy metal band Metallica.", "1986", 3);
        // End of creation of mock albums.

        // Start of creation of mock concerts.
        Concert damageTour, ultraMusicFestival, tomorrowLandFestival;
         
            //Group: Metallica:
                damageTour = new Concert("Damage, Inc. Tour", "C:\\Users\\Aymane\\Music\\damage.png", "Damage, Inc. was the third concert tour by the American thrash metal band Metallica.", "1986", 17, "North America");
        
            //Artist: Armin Van Buuren:
                ultraMusicFestival = new Concert("Ultra Music Festival", "C:\\Users\\Aymane\\Music\\ultra.png", "Ultra Music Festival is one of the biggest festivals in the world where multiple artists including Armin Van Buuren performed live concerts.", "2009", 4, "Netherlands");
                tomorrowLandFestival = new Concert("Tomorrowland Festival", "C:\\Users\\Aymane\\Music\\tomorrow.png", "Tomorrowland is the largest annual electronic music festival held in the world, taking place in Belgium.", "2013", 5, "Belgium");
        // End of creation of mock concerts.                      
        
        // Start of creation of mock music tracks.
        MusicTrack mt1, mt2, mt3, mt4, mt5, mt6, mt7, mt8, mt9, mt10, mt11, mt12, mt13, mt14, mt15;
        
            //Artist: Armin Van Buuren:

                // Singles by the artist Armin Van Buuren.
                mt1 = new MusicTrack("Beautiful Life", "Trance" , "6:09", "single", "C:\\Users\\Aymane\\Music\\Beautiful Life - Armin Van Buuren.mp3", avb, null, mostRecentlyPlayedList, null);
                mt2 = new MusicTrack("Drowning", "Trance", "7:52", "single", "C:\\Users\\Aymane\\Music\\Drowning - Armin Van Buuren.mp3", avb, null, mostRecentlyPlayedList, null);

                // Music Tracks from the Album "Mirage" by Armin Van Buuren.
                mt3 = new MusicTrack("Desiderium", "Trance", "2:08", "album" , "C:\\Users\\Aymane\\Music\\Desiderium - Armin Van Buuren.mp3", avb, mirage, mostRecentlyPlayedList, null);
                mt4 = new MusicTrack("The light between us", "Trance", "5:09", "album" , "C:\\Users\\Aymane\\Music\\The light between us - Armin Van Buuren.mp3", avb, mirage, mostRecentlyPlayedList, null);
                mt5 = new MusicTrack("Orbion", "Trance", "5:18", "album" , "C:\\Users\\Aymane\\Music\\Orbion - Armin Van Buuren.mp3", avb, mirage, mostRecentlyPlayedList, null);

                // Concert tracks from diffrent festivales performed by Armin Van Buuren.
                mt6 = new MusicTrack("Youtopia", "Trance", "2:58", "concert" , "C:\\Users\\Aymane\\Music\\Youtopia - Armin Van Buuren.mp3", avb, ultraMusicFestival, mostRecentlyPlayedList, null);
                mt7 = new MusicTrack("Unforgivable", "Trance", "5:09", "concert" , "C:\\Users\\Aymane\\Music\\Unforgivable - Armin Van Buuren.mp3", avb, ultraMusicFestival, mostRecentlyPlayedList, null);

                // Music Tracks from the Album "Intense" by Armin Van Buuren.
                mt8 = new MusicTrack("This Is What It Feels Like", "Trance", "3:33", "album" , "C:\\Users\\Aymane\\Music\\This Is What It Feels Like - Armin Van Buuren.mp3", avb, intense, mostRecentlyPlayedList, null);
                mt9 = new MusicTrack("Pulsar", "Trance", "4:56", "album" , "C:\\Users\\Aymane\\Music\\Pulsar - Armin Van Buuren.mp3", avb, intense, mostRecentlyPlayedList, null);
                mt10 = new MusicTrack("Reprise", "Trance", "4:25", "album" , "C:\\Users\\Aymane\\Music\\Reprise - Armin Van Buuren.mp3", avb, intense, mostRecentlyPlayedList, null);        
            
            //Group: Metallica:
                
                // Music Tracks from the Album "Master of Puppets" by Metallica.
                mt11 = new MusicTrack("Master of Puppets", "Metal", "8:36", "album" , "C:\\Users\\Aymane\\Music\\Master of Puppets - Metallica.mp3", metallica, masterOfPuppets, mostRecentlyPlayedList, null);
                mt12 = new MusicTrack("Orion", "Metal", "8:28", "album" , "C:\\Users\\Aymane\\Music\\Orion - Metallica.mp3", metallica, masterOfPuppets, mostRecentlyPlayedList, null);
                mt13 = new MusicTrack("Sanitarium", "Metal", "6:27", "album" , "C:\\Users\\Aymane\\Music\\Sanitarium - Metallica.mp3", metallica, masterOfPuppets, mostRecentlyPlayedList, null);            
                
                // Singles by the group Metallica.
                mt14 = new MusicTrack("One", "Metal", "7:27", "single" , "C:\\Users\\Aymane\\Music\\One - Metallica.mp3", metallica, null, mostRecentlyPlayedList, null);
                mt15 = new MusicTrack("Enter Sandman", "Metal", "5:32", "single" , "C:\\Users\\Aymane\\Music\\Enter Sandman - Metallica.mp3", metallica, null, mostRecentlyPlayedList, null);
                
        // End of creation of mock music tracks.
                
        // Start of adding tracks to albums.
        
            //Artist: Armin Van Buuren:
  
                mirage.addTrack(mt3);
                mirage.addTrack(mt4);
                mirage.addTrack(mt5);

                ultraMusicFestival.addTrack(mt6);
                ultraMusicFestival.addTrack(mt7);            

                tomorrowLandFestival.addTrack(mt3);
                tomorrowLandFestival.addTrack(mt4);
                tomorrowLandFestival.addTrack(mt5);

                intense.addTrack(mt8);
                intense.addTrack(mt9);
                intense.addTrack(mt10);

            //Group: Metallica:

                masterOfPuppets.addTrack(mt11);
                masterOfPuppets.addTrack(mt12);
                masterOfPuppets.addTrack(mt13);
            
                damageTour.addTrack(mt11);
                damageTour.addTrack(mt12);
                damageTour.addTrack(mt13);
                
        // End of adding tracks to albums.        
        
        // Start of adding albums to artists.
        
            //Artist: Armin Van Buuren:
                
                avb.addAlbum(mirage);
                avb.addAlbum(intense);
                avb.addAlbum(ultraMusicFestival);
                
            //Group: Metallica:
                
                metallica.addAlbum(masterOfPuppets);
                metallica.addAlbum(damageTour);
                
        // End of adding albums to artists.    
        
        // Start of adding concerts to artists.
        
            //Group: Metallica:
                metallica.addConcert(damageTour);
        
            //Artist: Armin Van Buuren:

                avb.addConcert(ultraMusicFestival);
                avb.addConcert(tomorrowLandFestival);
        // End of adding concerts to artists.         
        
        // Start of adding singles to artists.             
                
            //Group: Metallica:
                metallica.addSingle(mt14);
                metallica.addSingle(mt15);
            //Artist: Armin Van Buuren:

                avb.addSingle(mt1);
                avb.addSingle(mt2);
        // End of adding singles to artists.                    

        // Start of testing PlayList.
            PlayList <MusicTrack> playlist = new PlayList <MusicTrack> ();
            
            // Manually adding tracks to the playlist.
            playlist.add(mt1);
            playlist.add(mt2);
            playlist.add(mt4);
            playlist.add(mt7);
            playlist.add(mt13);

            System.out.println("Playing the whole playlist now:\n");
        try {
            playlist.play();
            
        } catch (EmptyListException ex) {
            ex.printStackTrace();
        }
        // End of testing PlayList.
        
        // Start of testing Most Recently Played List.
            System.out.println("\nPlaying the whole recently played list now:\n");
            
        try {
            // Tracks that have been played recently have been added automatically to this list:
            mostRecentlyPlayedList.play();
            // End of testing Most Recently Played List.
        } catch (EmptyListException ex) {
            ex.printStackTrace();
        }

        try
        {
            PersistentPlayList.save(playlist);
            System.out.println("playlist saved successfuly.");
        }
        catch(IOException ioe)
        {
         System.out.println("There was a pronblem saving your file.");
        }   
        
        try
        {
            PersistentMostRecentlyPlayedList.save(mostRecentlyPlayedList);
            System.out.println("MostRecentlyPlayedList saved successfuly.");
        }
        catch(IOException ioe)
        {
         System.out.println("There was a pronblem saving your file.");
        }       
                 
    }
    
}

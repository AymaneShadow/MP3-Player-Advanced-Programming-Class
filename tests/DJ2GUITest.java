/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dj2.tests;

import dj2.core.Album;
import dj2.core.Artist;
import dj2.core.Concert;
import dj2.core.Group;

import dj2.core.MostRecentlyPlayedList;
import dj2.core.MusicTrack;
import dj2.core.MusicTrackCatalog;
import dj2.core.PlayList;

import dj2.persistence.*;
import dj2.gui.MainFrame;
import dj2.core.SimpleAudioPlayer;
import java.io.IOException;
import java.net.MalformedURLException;
import javafx.application.Application;

import javafx.stage.Stage;


import javax.swing.UIManager;

/**
* This is the main Class, it is mostly used to generate the base pool of tracks to be used by the program in
* order to play music.
 * @author Aymane Chaoui
 */
public class DJ2GUITest extends Application {
    
    public static void main(String[] args) throws Exception {

        
        launch(args);
    }
    
  @Override 
  public void start(Stage stage) throws MalformedURLException, Exception{

    SimpleAudioPlayer previousSimpleAudioPlayer = new SimpleAudioPlayer();
    
    PlayList playList = PersistentPlayList.load();
    MostRecentlyPlayedList mostRecentlyPlayedList = PersistentMostRecentlyPlayedList.load();
    MusicTrackCatalog catalog = buildMusicTrackCatalog(mostRecentlyPlayedList, previousSimpleAudioPlayer);
    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    
    MainFrame mainFrame = new MainFrame(catalog, playList, mostRecentlyPlayedList);      

  }    
    
    public static MusicTrackCatalog buildMusicTrackCatalog(MostRecentlyPlayedList mostRecentlyPlayedList, SimpleAudioPlayer previousSimpleAudioPlayer) throws MalformedURLException, IOException{
     
        MusicTrackCatalog catalog = new MusicTrackCatalog();
        
        
//        MusicTrackCategory albums = new MusicTrackCategory("Albums");
//        MusicTrackCategory style = new MusicTrackCategory("Style");
//        MusicTrackCategory artistOrGroup = new MusicTrackCategory("Artist/Group");

        catalog.add("Artist/Group");        
        catalog.add("Style");
        catalog.add("Albums");
            
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
                mt1 = new MusicTrack("Beautiful Life", "Trance" , "6:09", "single", "music\\Armin Van Buuren\\Singles\\03 Armin Van Buuren - Beautiful Life.mp3", avb, null, mostRecentlyPlayedList, previousSimpleAudioPlayer);
                mt2 = new MusicTrack("Drowning", "Trance", "7:52", "single", "music\\Armin Van Buuren\\Singles\\armin_van_buuren_feat._laura_v_-_drowning_(avicii_remix)_demo.mp3", avb, null, mostRecentlyPlayedList, previousSimpleAudioPlayer);

                // Music Tracks from the Album "Mirage" by Armin Van Buuren.
                mt3 = new MusicTrack("Desiderium", "Trance", "2:08", "album" , "music\\Armin Van Buuren\\Albums\\Armin Van Buuren - Mirage (Album + Bonus) (Insrpion)\\01-armin_van_buuren_feat_susana-desiderium_207.mp3", avb, mirage, mostRecentlyPlayedList, previousSimpleAudioPlayer);
                mt4 = new MusicTrack("The light between us", "Trance", "5:09", "album" , "music\\Armin Van Buuren\\Albums\\Armin Van Buuren - Mirage (Album + Bonus) (Insrpion)\\03-armin_van_buuren_feat_christian_burns-this_light_between_us.mp3", avb, mirage, mostRecentlyPlayedList, previousSimpleAudioPlayer);
                mt5 = new MusicTrack("Orbion", "Trance", "5:18", "album" , "music\\Armin Van Buuren\\Albums\\Armin Van Buuren - Mirage (Album + Bonus) (Insrpion)\\14-armin_van_buuren-orbion.mp3", avb, mirage, mostRecentlyPlayedList, previousSimpleAudioPlayer);

                // Concert tracks from diffrent festivales performed by Armin Van Buuren.
                mt6 = new MusicTrack("Youtopia", "Trance", "2:58", "concert" , "music\\Armin Van Buuren\\Concerts\\16-armin_van_buuren_feat_adam_young-youtopia.mp3", avb, ultraMusicFestival, mostRecentlyPlayedList, previousSimpleAudioPlayer);
                mt7 = new MusicTrack("Unforgivable", "Trance", "5:09", "concert" , "music\\Armin Van Buuren\\Concerts\\Armin van Buuren feat. Jaren-Unforgivable (Radio Edit).mp3", avb, ultraMusicFestival, mostRecentlyPlayedList, previousSimpleAudioPlayer);

                // Music Tracks from the Album "Intense" by Armin Van Buuren.
                mt8 = new MusicTrack("This Is What It Feels Like", "Trance", "3:33", "album" , "music\\Armin Van Buuren\\Albums\\Armin van Buuren - Intense (Inspiron)\\02 Armin Van Buuren - This Is What It Feels Like.mp3", avb, intense, mostRecentlyPlayedList, previousSimpleAudioPlayer);
                mt9 = new MusicTrack("Pulsar", "Trance", "4:56", "album" , "music\\Armin Van Buuren\\Albums\\Armin van Buuren - Intense (Inspiron)\\05 Armin Van Buuren - Pulsar.mp3", avb, intense, mostRecentlyPlayedList, previousSimpleAudioPlayer);
                mt10 = new MusicTrack("Reprise", "Trance", "4:25", "album" , "music\\Armin Van Buuren\\Albums\\Armin van Buuren - Intense (Inspiron)\\15 Armin Van Buuren - Reprise.mp3", avb, intense, mostRecentlyPlayedList, previousSimpleAudioPlayer);        
            
            //Group: Metallica:
                
                // Music Tracks from the Album "Master of Puppets" by Metallica.
                mt11 = new MusicTrack("Master of Puppets", "Metal", "8:36", "album" , "music\\Metallica\\Albums\\Metallica - Master Of Puppets\\02 - Master of Puppets.mp3", metallica, masterOfPuppets, mostRecentlyPlayedList, previousSimpleAudioPlayer);
                mt12 = new MusicTrack("Orion", "Metal", "8:28", "album" , "music\\Metallica\\Albums\\Metallica - Master Of Puppets\\07 - Orion (instrumental).mp3", metallica, masterOfPuppets, mostRecentlyPlayedList, previousSimpleAudioPlayer);
                mt13 = new MusicTrack("Damage, Inc", "Metal", "6:27", "album" , "music\\Metallica\\Albums\\Metallica - Master Of Puppets\\08 - Damage, Inc.mp3", metallica, masterOfPuppets, mostRecentlyPlayedList, previousSimpleAudioPlayer);            
                
                // Singles by the group Metallica.
                mt14 = new MusicTrack("One", "Metal", "7:27", "single" , "music\\Metallica\\Singles\\01 One.mp3", metallica, null, mostRecentlyPlayedList, previousSimpleAudioPlayer);
                mt15 = new MusicTrack("Enter Sandman", "Metal", "5:32", "single" , "music\\Metallica\\Singles\\02 Enter Sandman.mp3", metallica, null, mostRecentlyPlayedList, previousSimpleAudioPlayer);
                
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
        
        catalog.getAlbums().add(mirage);
        catalog.getAlbums().add(intense);
        catalog.getAlbums().add(ultraMusicFestival);
        
        catalog.getAlbums().add(masterOfPuppets);
        catalog.getAlbums().add(damageTour);
        
        catalog.getArtistOrGroup().add(avb);
        catalog.getArtistOrGroup().add(metallica);
         
        return catalog;
    }

}

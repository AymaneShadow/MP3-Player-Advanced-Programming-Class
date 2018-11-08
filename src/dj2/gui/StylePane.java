package dj2.gui;

import dj2.core.Album;
import dj2.core.Artist;
import dj2.core.Concert;
import dj2.core.LinkedList;
import dj2.core.MusicTrack;
import dj2.core.MusicTrackCatalog;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * This class is used to generate tracks sorted by Style.
 * @author Aymane Chaoui
 */
public class StylePane extends JPanel {
    
    private JLabel styleLabel;
    private JLabel artistOrGroupLabel;
    
    private Artist[] artists;
    private Album[] albums;
    private Concert[] concerts;

    private MusicTrack[] singles;
    private MusicTrack[] albumTracks;
    private MusicTrack[] concertTracks;
    
    public StylePane(MusicTrackCatalog catalog, PlayListPane playListPane, MostRecentlyPlayedListPane mostRecentlyPlayedListPane){
        
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBackground(Color.lightGray);
      
        artists = new Artist[catalog.getArtistOrGroup().getSize()];
        
        for(int i = 0; i < catalog.getArtistOrGroup().getSize(); i++)
        {
            artists[i] = (Artist) catalog.getArtistOrGroup().toArray()[i]; // Converting the LinkedList of Artists to an Array of Artists.

            artistOrGroupLabel = new JLabel(artists[i].getName());
            artistOrGroupLabel.setFont(new Font("Verdana", Font.BOLD, 14));
            artistOrGroupLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
            this.add(artistOrGroupLabel);            
            
            singles = new MusicTrack[artists[i].getSingles().getSize()];               
            for(int j = 0; j < artists[i].getSingles().getSize(); j++)     // Converting the LinkedList of Singles to an Array of Singles.
            singles[j] = (MusicTrack) artists[i].getSingles().toArray()[j];
            
            albums = new Album[artists[i].getAlbums().getSize()];   
            for(int j = 0; j < artists[i].getAlbums().getSize(); j++)
            {
                albums[j] = (Album) artists[i].getAlbums().toArray()[j];
                
                albumTracks = new MusicTrack[albums[j].getAlbumTracks().getSize()];   
                for(int k = 0; k < albums[j].getAlbumTracks().getSize(); k++)
                albumTracks[k] = (MusicTrack) albums[j].getAlbumTracks().toArray()[k];
            }           

            concerts = new Concert[artists[i].getConcerts().getSize()];   
            for(int j = 0; j < artists[i].getConcerts().getSize(); j++)
            {
                concerts[j] = (Concert) artists[i].getConcerts().toArray()[j];

                concertTracks = new MusicTrack[concerts[j].getAlbumTracks().getSize()];   

                for(int k = 0; k < concerts[j].getAlbumTracks().getSize(); k++)
                concertTracks[k] = (MusicTrack) concerts[j].getAlbumTracks().toArray()[k];
            } 
            
            LinkedList <MusicTrack> tranceTracks = searchTracksByStyle("Trance", singles, albumTracks, concertTracks);
            
            
            
            if(tranceTracks.getHead() != null)
            {
                styleLabel = new JLabel("Trance");
                styleLabel.setFont(new Font("Verdana", Font.BOLD, 12));
                styleLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
                this.add(styleLabel);                  


                JPanel trancePane = new StyleInnerPane("Trance", tranceTracks, playListPane, mostRecentlyPlayedListPane);
                trancePane.setAlignmentX(Component.LEFT_ALIGNMENT);
                this.add(trancePane);
            }
            
            LinkedList <MusicTrack> metalTracks = searchTracksByStyle("Metal", singles, albumTracks, concertTracks);            
            
            if(metalTracks.getHead() != null)
            {            
                styleLabel = new JLabel("Metal");
                styleLabel.setFont(new Font("Verdana", Font.BOLD, 12));
                styleLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
                this.add(styleLabel);                    

                JPanel metalPane = new StyleInnerPane("Metal", metalTracks, playListPane, mostRecentlyPlayedListPane);
                metalPane.setAlignmentX(Component.LEFT_ALIGNMENT);
                this.add(metalPane);            
            }
        }  
    }
    
    public LinkedList <MusicTrack> searchTracksByStyle(String style, MusicTrack[] singles, MusicTrack[] albumTracks, MusicTrack[] concertTracks){
        
        LinkedList <MusicTrack> styleTracks = new LinkedList <MusicTrack>();
        
        for(int i = 0; i < singles.length; i++)
        {
            if(style == singles[i].getStyle())
            {
                styleTracks.add(singles[i]);
            }
        }        
        
        for(int j = 0; j < albumTracks.length; j++)
        {
            if(style == albumTracks[j].getStyle())
            {
                styleTracks.add(albumTracks[j]);
            }
        }  
        
        for(int k = 0; k < concertTracks.length; k++)
        {
            if(style == concertTracks[k].getStyle())
            {
                styleTracks.add(concertTracks[k]);
            }
        }
        
        return styleTracks;
    }
    
}

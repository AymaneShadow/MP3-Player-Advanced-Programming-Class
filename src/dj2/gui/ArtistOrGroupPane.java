package dj2.gui;

import dj2.core.Album;
import dj2.core.Artist;
import dj2.core.Concert;


import dj2.core.MusicTrack;
import dj2.core.MusicTrackCatalog;

import java.awt.Color;
import java.awt.Component;

import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * This class is used to generate tracks sorted by Artist / Group.
 * @author Aymane Chaoui
 */
public class ArtistOrGroupPane extends JPanel {

    private JLabel singlesLabel;
    private JLabel albumsLabel;
    private JLabel concertsLabel;    
    private JLabel artistOrGroupLabel;
    
    private Artist[] artists;
    private Album[] albums;
    private Concert[] concerts;

    private MusicTrack[] singles;
    private MusicTrack[] albumTracks;
    private MusicTrack[] concertTracks;
    
    public ArtistOrGroupPane(MusicTrackCatalog catalog, PlayListPane playListPane, MostRecentlyPlayedListPane mostRecentlyPlayedListPane) {
        
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
            
            singlesLabel = new JLabel("Singles:");
            singlesLabel.setFont(new Font("Verdana", Font.PLAIN, 12));
            singlesLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
            this.add(singlesLabel);
            
            singles = new MusicTrack[artists[i].getSingles().getSize()];               
            for(int j = 0; j < artists[i].getSingles().getSize(); j++)     // Converting the LinkedList of Singles to an Array of Singles.
            {
                singles[j] = (MusicTrack) artists[i].getSingles().toArray()[j];
                
                
                JPanel musicTrackInnerPane = new ArtistOrGroupInnerPane(singles[j], playListPane, mostRecentlyPlayedListPane);
                musicTrackInnerPane.setAlignmentX(Component.LEFT_ALIGNMENT);
                this.add(musicTrackInnerPane);
                
            }
            
            albumsLabel = new JLabel("Albums:");
            albumsLabel.setFont(new Font("Verdana", Font.PLAIN, 12));
            albumsLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
            this.add(albumsLabel);
            albums = new Album[artists[i].getAlbums().getSize()];   
            for(int j = 0; j < artists[i].getAlbums().getSize(); j++)
            {
                albums[j] = (Album) artists[i].getAlbums().toArray()[j];
                
                albumTracks = new MusicTrack[albums[j].getAlbumTracks().getSize()];   
                for(int k = 0; k < albums[j].getAlbumTracks().getSize(); k++)
                {
                    albumTracks[k] = (MusicTrack) albums[j].getAlbumTracks().toArray()[k];

                    JPanel musicTrackInnerPane = new ArtistOrGroupInnerPane(albumTracks[k], playListPane, mostRecentlyPlayedListPane);
                    musicTrackInnerPane.setAlignmentX(Component.LEFT_ALIGNMENT);
                    this.add(musicTrackInnerPane);

                }
            }           
            
            concertsLabel = new JLabel("Concerts:");
            concertsLabel.setFont(new Font("Verdana", Font.PLAIN, 12));
            concertsLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
            this.add(concertsLabel);
            concerts = new Concert[artists[i].getConcerts().getSize()];   
            for(int j = 0; j < artists[i].getConcerts().getSize(); j++)
            {
                concerts[j] = (Concert) artists[i].getConcerts().toArray()[j];

                concertTracks = new MusicTrack[concerts[j].getAlbumTracks().getSize()];   

                for(int k = 0; k < concerts[j].getAlbumTracks().getSize(); k++)
                {
                    concertTracks[k] = (MusicTrack) concerts[j].getAlbumTracks().toArray()[k];
                    
                    JPanel musicTrackInnerPane = new ArtistOrGroupInnerPane(concertTracks[k], playListPane, mostRecentlyPlayedListPane);
                    musicTrackInnerPane.setAlignmentX(Component.LEFT_ALIGNMENT);
                    this.add(musicTrackInnerPane);
                }
            }               
            
        }   

    }

}
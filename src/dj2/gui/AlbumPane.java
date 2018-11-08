package dj2.gui;

import dj2.core.Album;
import dj2.core.Artist;
import dj2.core.MusicTrackCatalog;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * This class is used to generate the tracks sorted by Album.
 * @author Aymane Chaoui
 */
public class AlbumPane extends JPanel {
    
    private JLabel albumsLabel;
    
    private Artist[] artists;    
    private Album[] albums;
    
    public AlbumPane(MusicTrackCatalog catalog, PlayListPane playListPane, MostRecentlyPlayedListPane mostRecentlyPlayedListPane){
        
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBackground(Color.lightGray);
        
        artists = new Artist[catalog.getArtistOrGroup().getSize()];
        
        for(int i = 0; i < catalog.getArtistOrGroup().getSize(); i++)
        {
            artists[i] = (Artist) catalog.getArtistOrGroup().toArray()[i]; // Converting the LinkedList of Artists to an Array of Artists.
            
            albums = new Album[artists[i].getAlbums().getSize()];
            
            for(int j = 0; j < artists[i].getAlbums().getSize(); j++)     // Converting the LinkedList of Singles to an Array of Singles.
            {
                albums[j] = (Album) artists[i].getAlbums().toArray()[j];
                
                albumsLabel = new JLabel(albums[j].getTitle());
                albumsLabel.setFont(new Font("Verdana", Font.BOLD, 14));
                albumsLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
                this.add(albumsLabel);
                
                JPanel albumInnerPane = new AlbumInnerPane(albums[j], playListPane, mostRecentlyPlayedListPane);
                albumInnerPane.setAlignmentX(Component.LEFT_ALIGNMENT);
                this.add(albumInnerPane);                
                
            }
        }
        
        
    }

}

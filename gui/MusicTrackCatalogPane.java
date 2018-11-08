package dj2.gui;

import dj2.core.MusicTrackCatalog;

import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;


/**
 * This is the panel that contains the three music displaying panels: Artist / Group, Styles and Albums.
 * @author Aymane Chaoui
 */
public class MusicTrackCatalogPane extends JTabbedPane {   
            
    protected MusicTrackCatalogPane(MusicTrackCatalog catalog, PlayListPane playListPane, MostRecentlyPlayedListPane mostRecentlyPlayedListPane) {
        
        String[] categories = catalog.getCategories();
                
        setFont(new Font("Verdana", Font.BOLD, 12));
        
        JPanel artistsOrGroupsPane = new JPanel();
        JPanel stylePane = new JPanel();
        JPanel albumPane = new JPanel();

        JScrollPane artistsOrGroupsPaneScrollFrame = new JScrollPane(artistsOrGroupsPane); 
        artistsOrGroupsPaneScrollFrame.getVerticalScrollBar().setUnitIncrement(16);
        artistsOrGroupsPane.setAutoscrolls(true);
        this.add(categories[0], artistsOrGroupsPaneScrollFrame);      
        artistsOrGroupsPane.add(new ArtistOrGroupPane(catalog, playListPane, mostRecentlyPlayedListPane));

        JScrollPane stylesPaneScrollFrame = new JScrollPane(stylePane); 
        stylesPaneScrollFrame.getVerticalScrollBar().setUnitIncrement(16);
        stylePane.setAutoscrolls(true);        
        this.add(categories[1], stylePane);
        stylePane.add(new StylePane(catalog, playListPane, mostRecentlyPlayedListPane));        

        JScrollPane albumsPaneScrollFrame = new JScrollPane(albumPane); 
        albumsPaneScrollFrame.getVerticalScrollBar().setUnitIncrement(16);
        albumPane.setAutoscrolls(true);        
        this.add(categories[2], albumPane);
        albumPane.add(new AlbumPane(catalog, playListPane, mostRecentlyPlayedListPane));
    }    
    
}

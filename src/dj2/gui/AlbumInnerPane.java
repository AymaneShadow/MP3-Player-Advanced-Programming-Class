package dj2.gui;

import dj2.core.Album;
import dj2.core.MusicTrack;
import exceptions.EmptyListException;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * This is the class that is used to generate the components of the AlbumPane class, and as its name suggests
 * it is an inner pane which means that AlbumPane uses it multiple times to generate its content.
 * @author Aymane Chaoui
 */
public class AlbumInnerPane extends JPanel {

    private JTextArea tracksTextArea;
    private JButton playButton;
    
    private MostRecentlyPlayedListPane mostRecentlyPlayedListPane;
    private PlayListPane playListPane;
    
    private Album album;
    
    public AlbumInnerPane(Album album, PlayListPane playListPane, MostRecentlyPlayedListPane mostRecentlyPlayedListPane){
        
    this.setLayout(new FlowLayout(FlowLayout.LEFT));        
    this.album = album;
    this.mostRecentlyPlayedListPane = mostRecentlyPlayedListPane;
    this.playListPane = playListPane;
            
    tracksTextArea = new JTextArea(1, 75);
    tracksTextArea.setEnabled(false);
    tracksTextArea.setFont(new Font("Verdana", Font.BOLD, 12));
    //tracksTextArea.setLineWrap(true);
    tracksTextArea.setWrapStyleWord(true);            
    tracksTextArea.setText(album.getTitle());
    this.add(tracksTextArea);

    playButton = new JButton("Play");
    this.add(playButton); 
    
    playButton.addActionListener(new ActionListener()
    {      
            public void actionPerformed(ActionEvent ae)
            {
                try {
                    albumActionPerformed(ae);
                } catch (IOException ex) {
                  ex.printStackTrace();
                } catch (EmptyListException ex) {
                    ex.printStackTrace();
                }
            }            
    });    
        
    }
    
    public void albumActionPerformed(ActionEvent ae) throws IOException, EmptyListException{

        this.playListPane.getPlayList().clear();        
        for(int i = 0; i < this.album.getAlbumTracks().getSize(); i++)
        this.playListPane.getPlayList().add((MusicTrack) this.album.getAlbumTracks().toArray()[i]);
        
        this.playListPane.update();
        
        this.album.play();
        this.mostRecentlyPlayedListPane.update();        
    }     
}

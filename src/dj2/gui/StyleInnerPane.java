package dj2.gui;

import dj2.core.LinkedList;
import dj2.core.MusicTrack;
import exceptions.EmptyListException;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javafx.scene.media.MediaPlayer;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * This is the class that is used to generate the components of the StylePane class, and as its name suggests
 * it is an inner pane which means that StylePane uses it multiple times to generate its content.
 * @author Aymane
 */
public class StyleInnerPane extends JPanel {
    
    private JTextArea tracksTextArea;
    private JButton playButton;
    
    private MostRecentlyPlayedListPane mostRecentlyPlayedListPane;
    private PlayListPane playListPane;  
    
    private String style;
    
    private LinkedList <MusicTrack> trackByStyle;
    
    public StyleInnerPane(String style, LinkedList <MusicTrack> trackByStyle, PlayListPane playListPane, MostRecentlyPlayedListPane mostRecentlyPlayedListPane){
        
    this.setLayout(new FlowLayout(FlowLayout.LEFT));        
    this.style = style;
    this.mostRecentlyPlayedListPane = mostRecentlyPlayedListPane;
    this.playListPane = playListPane;
    this.trackByStyle = trackByStyle;
    
    tracksTextArea = new JTextArea(1, 75);
    tracksTextArea.setEnabled(false);
    tracksTextArea.setFont(new Font("Verdana", Font.BOLD, 12));
    //tracksTextArea.setLineWrap(true);
    tracksTextArea.setWrapStyleWord(true);            
    tracksTextArea.setText(style);
    this.add(tracksTextArea);

    playButton = new JButton("Play");
    this.add(playButton); 
    
    playButton.addActionListener(new ActionListener()
    {      
            public void actionPerformed(ActionEvent ae)
            {
                try {
                    styleActionPerformed(ae);
                } catch (IOException ex) {
                  ex.printStackTrace();
                } catch (EmptyListException ex) {
                    ex.printStackTrace();
                }
            }            
    });    
        
    }
    
    public void styleActionPerformed(ActionEvent ae) throws IOException, EmptyListException{

        this.playListPane.getPlayList().clear();        
        for(int i = 0; i < this.trackByStyle.getSize(); i++)
        this.playListPane.getPlayList().add((MusicTrack) this.trackByStyle.toArray()[i]);
        
        this.playListPane.update();
        
        this.play();       
    }     
    
    public void play() throws IOException, EmptyListException{
        
        if(trackByStyle.getHead() == null)
        throw new EmptyListException("Album.");    
        else
        {   
            MusicTrack[] musicTracks = new MusicTrack[trackByStyle.toArray().length];
            
            MusicTrack firstTrack = (MusicTrack) trackByStyle.getHead().getValue();
            MediaPlayer player = firstTrack.getSimpleAudioPlayer().getMediaPlayer();
            firstTrack.play(1, 0);            
            player.play();

            this.mostRecentlyPlayedListPane.update();
            
            for(int i = 0; i < trackByStyle.toArray().length; i++)
            musicTracks[i] = (MusicTrack) trackByStyle.toArray()[i];
            
            
            for(int i = 0; i < musicTracks.length; i++)
            {
                player = musicTracks[i].getSimpleAudioPlayer().getMediaPlayer();
                final MusicTrack nextTrack = musicTracks[(i + 1) % musicTracks.length];

                player.setOnEndOfMedia(new Runnable() {
                  @Override public void run() {
                      try 
                      {
                          nextTrack.play(1, 0);
                          
                      } catch (IOException ex) {
                         ex.printStackTrace();
                      }
                  }
                });     
                
            this.mostRecentlyPlayedListPane.update(); 
            }
        } 
    }    
    
}

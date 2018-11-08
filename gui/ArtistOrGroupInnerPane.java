package dj2.gui;

import dj2.core.MusicTrack;
import java.awt.FlowLayout;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * This is used to generate some components of the ArtistOrGroupPane class, and as its name suggests,
 * it is an inner class which means that the class that contains it uses it multiple times to generate
 * its content.
 * @author Aymane Chaoui
 */

public class ArtistOrGroupInnerPane extends JPanel {

    private JTextArea tracksTextArea;
    private JButton playButton;
    private JButton addToPlayListButton;
    
    private MusicTrack track;
    
    private MostRecentlyPlayedListPane mostRecentlyPlayedListPane;
    private PlayListPane playListPane;
    
    public ArtistOrGroupInnerPane(MusicTrack track, PlayListPane playListPane, MostRecentlyPlayedListPane mostRecentlyPlayedListPane){

    this.setLayout(new FlowLayout(FlowLayout.LEFT));
    this.track = track;
    this.mostRecentlyPlayedListPane = mostRecentlyPlayedListPane;
    this.playListPane = playListPane;            
    
    
    tracksTextArea = new JTextArea(1, 60);
    tracksTextArea.setEnabled(false);
    tracksTextArea.setFont(new Font("Verdana", Font.BOLD, 12));
    tracksTextArea.setLineWrap(true);
    tracksTextArea.setWrapStyleWord(true);            
    tracksTextArea.setText(track.getTitle());
    this.add(tracksTextArea);

    addToPlayListButton = new JButton("Add to PlayList");
    this.add(addToPlayListButton);     
    
    addToPlayListButton.addActionListener(new ActionListener()
    {      
            public void actionPerformed(ActionEvent ae)
            {
                try {
                    addToPlayListActionPerformed(ae);
                } catch (MalformedURLException ex) {
                    // Do nothing.
                } catch (IOException ex) {
                    // Do nothing.
                }
            }            
    });
    
    playButton = new JButton("Play");
    this.add(playButton); 
    
    playButton.addActionListener(new ActionListener()
    {      
            public void actionPerformed(ActionEvent ae)
            {
                try {
                    playActionPerformed(ae);
                } catch (MalformedURLException ex) {
                    ex.printStackTrace();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }            
    });
   
    
    }

    public void addToPlayListActionPerformed(ActionEvent ae) throws MalformedURLException, IOException{

        this.playListPane.getPlayList().add(this.track);
        this.playListPane.update();        
    }     
    
    public void playActionPerformed(ActionEvent ae) throws MalformedURLException, IOException{

        this.playListPane.getPlayList().clear();
        this.playListPane.getPlayList().add(this.track);        
        this.playListPane.update();
        
        this.track.play(1, 0);
        this.mostRecentlyPlayedListPane.update(); 
    }    
}

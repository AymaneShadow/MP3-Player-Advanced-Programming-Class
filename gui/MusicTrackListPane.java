package dj2.gui;

import dj2.core.LinkedList;
import dj2.core.MusicTrack;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JButton;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

/**
 * This class is inherited by PlayListPane and MostRecentlyPlayedListPane that use its content since
 * they have common attributes with it. It is abstract because it has the update method that will be 
 * implemented differently depnding on the class that extends it.
 * @author Aymane Chaoui
 */
public abstract class MusicTrackListPane extends JTabbedPane {
    
    protected LinkedList <MusicTrack> musicTrackList;
    protected JPanel pane;
    protected JPanel southPane;    
    protected JTextArea textArea;
    protected JButton playButton;
    protected JButton clearButton;
    
    public MusicTrackListPane(String title, LinkedList <MusicTrack> musicTrackList){
        
        setFont(new Font("Verdana", Font.BOLD, 12));
        
        this.musicTrackList = musicTrackList;
        
        pane = new JPanel();
        add(title, pane);
        pane.setLayout(new BorderLayout());
        
        textArea = new JTextArea();
        textArea.setEnabled(false);
        textArea.setFont(new Font("Verdana", Font.BOLD, 12));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setPreferredSize(new Dimension(250, 285));
        
        southPane = new JPanel();
        southPane.setLayout(new FlowLayout(FlowLayout.LEFT));
                
        playButton = new JButton("Play");
        playButton.setPreferredSize(new Dimension(115, 23));
        southPane.add(playButton);
        
        clearButton = new JButton("Clear");
        clearButton.setPreferredSize(new Dimension(115, 23));        
        southPane.add(clearButton);
        
        pane.add(southPane, BorderLayout.SOUTH);
        pane.add(new JScrollPane(textArea), BorderLayout.NORTH);        
    }
    
    protected abstract void update();

    public LinkedList <MusicTrack> getMusicTrackList() {
        return musicTrackList;
    }    
}

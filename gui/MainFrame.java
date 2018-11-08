package dj2.gui;

import dj2.core.MostRecentlyPlayedList;
import dj2.core.MusicTrackCatalog;
import dj2.core.PlayList;

import java.awt.*;
import javax.swing.*;

/**
 * This is the mainFrame of the program, it is used by the OS as a first container. It contains all the
 * panels that are used in this program.
 * @author Aymane
 */
public class MainFrame extends JFrame {
    
    private JPanel mainPanel = new JPanel();
    private JPanel eastPanel = new JPanel();    
    
    private MusicTrackCatalogPane musicTrackCatalogPane;
    
    private JLabel infoLabel;
    
    private PlayListPane playListPane;
    private MostRecentlyPlayedListPane mostRecentlyPlayedListPane;
    
    public MainFrame (MusicTrackCatalog catalog, PlayList playList, MostRecentlyPlayedList mostRecentlyPlayedList){
     
     mostRecentlyPlayedListPane = new MostRecentlyPlayedListPane(mostRecentlyPlayedList);
     playListPane = new PlayListPane(playList);     
     musicTrackCatalogPane = new MusicTrackCatalogPane(catalog, this.playListPane, this.mostRecentlyPlayedListPane);        


     
     infoLabel = new JLabel("DJ² by Aymane Chaoui.");
     infoLabel.setFont(new Font("Verdana", Font.BOLD, 12));
     
     this.getContentPane().setLayout(new BorderLayout());
     this.getContentPane().add(infoLabel, BorderLayout.SOUTH);
     this.getContentPane().add(mainPanel, BorderLayout.CENTER);

     mainPanel.setLayout(new BorderLayout());
     mainPanel.add(musicTrackCatalogPane, BorderLayout.CENTER);
     mainPanel.add(eastPanel, BorderLayout.EAST);
     
        eastPanel.setLayout(new BorderLayout());
        eastPanel.add(playListPane, BorderLayout.NORTH);
        eastPanel.add(mostRecentlyPlayedListPane, BorderLayout.SOUTH);
        eastPanel.setPreferredSize(new Dimension(250, 700));
        
        
        this.setTitle("DJ² Multiplayer by Aymane Chaoui");
        setJMenuBar(new MenuBar(playListPane, mostRecentlyPlayedListPane));
        this.setVisible(true);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     
    }
}

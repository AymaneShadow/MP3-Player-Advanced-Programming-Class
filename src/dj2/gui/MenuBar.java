package dj2.gui;

import dj2.persistence.PersistentMostRecentlyPlayedList;
import dj2.persistence.PersistentPlayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.IOException;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 * This is the menuBar Pane, it is used to contain the components needed for our menu, which
 * contains two components: save and exit.
 * @author Aymane
 */
class MenuBar extends JMenuBar {
    private JMenu menuFile = new JMenu("File");
    private JMenuItem menuFileSave = new JMenuItem("Save");
    private JMenuItem menuFileExit = new JMenuItem("Exit");
    
    private PlayListPane playListPane;
    private MostRecentlyPlayedListPane mostRecentlyPlayedListPane;
    
    public MenuBar(PlayListPane playListPane, MostRecentlyPlayedListPane mostRecentlyPlayedListPane){
        
        this.playListPane = playListPane;
        this.mostRecentlyPlayedListPane = mostRecentlyPlayedListPane;

        menuFile.add(menuFileSave);
        menuFile.add(menuFileExit);
        add(menuFile);
        
        menuFileSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

                try
                {
                    
                    PersistentPlayList.save(playListPane.getPlayList());
                    JOptionPane.showMessageDialog(null, "Playlist saved successfuly.");
                }
                catch(IOException ioe)
                {
                    ioe.printStackTrace();
                    JOptionPane.showMessageDialog(null, "There was a problem saving your Playlist.", "Error", JOptionPane.ERROR_MESSAGE);
                }   

                try
                {
                    PersistentMostRecentlyPlayedList.save(mostRecentlyPlayedListPane.getMostRecentlyPlayedList());
                    JOptionPane.showMessageDialog(null, "MostRecentlyPlayedList saved successfuly.");
                }
                catch(IOException ioe)
                {
                    JOptionPane.showMessageDialog(null, "There was a problem saving your MostRecentlyPlayedList.", "Error", JOptionPane.ERROR_MESSAGE);
                }                   
                
            } 
                
            });
            
        menuFileExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });            
    }         
    
}

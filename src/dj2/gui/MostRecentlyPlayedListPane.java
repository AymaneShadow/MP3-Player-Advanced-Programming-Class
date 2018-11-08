package dj2.gui;

import dj2.core.MostRecentlyPlayedList;
import exceptions.EmptyListException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * This is a Pane used to display the content of the most recently played list as it changes by
 * calling the update() method. It also extends the abstract class MusicTrackListPane because it
 * has got some common components that it uses with it, and also implements the update() method.
 * @author Aymane Chaoui
 */
public class MostRecentlyPlayedListPane extends MusicTrackListPane {

    private MostRecentlyPlayedList mostRecentlyPlayedList;
    
    public MostRecentlyPlayedListPane(MostRecentlyPlayedList mostRecentlyPlayedList) {
        
        super("Most Recently Played List", mostRecentlyPlayedList);
        
        this.mostRecentlyPlayedList = mostRecentlyPlayedList;

        textArea.setText(mostRecentlyPlayedList.toString());
        
        playButton.addActionListener(new ActionListener()
        {      
                public void actionPerformed(ActionEvent ae)
                {
                    try {
                        playActionPerformed(ae);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    } catch (EmptyListException ex) {
                        ex.printStackTrace();
                    }
                }            
        });  
        
        clearButton.addActionListener(new ActionListener()
        {      
                public void actionPerformed(ActionEvent ae)
                {
                        clearActionPerformed(ae);
                }            
        });        
    }

    public MostRecentlyPlayedList getMostRecentlyPlayedList() {
        return mostRecentlyPlayedList;
    }

    public void setMostRecentlyPlayedList(MostRecentlyPlayedList mostRecentlyPlayedList) {
        this.mostRecentlyPlayedList = mostRecentlyPlayedList;
    }
    
    public void clearActionPerformed(ActionEvent ae){
        
        this.getMostRecentlyPlayedList().clear();
        this.update();

    }       
    
    public void playActionPerformed(ActionEvent ae) throws IOException, EmptyListException {
        
        this.getMostRecentlyPlayedList().play();

    }      
    
    @Override
    protected void update() {
        
        textArea.setText(this.mostRecentlyPlayedList.toString());
    }    
    
}

package dj2.gui;

import dj2.core.PlayList;
import exceptions.EmptyListException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * This is a Pane used to display the content of the playlist as it changes by
 * calling the update() method. It also extends the abstract class MusicTrackListPane because it
 * has got some common components that it uses with it, and also implements the update() method.
 * @author Aymane Chaoui
 */
public class PlayListPane extends MusicTrackListPane {

    PlayList playList;
    
    public PlayListPane(PlayList playList) {
        
        super("PlayList", playList);
        
        this.playList = playList;

        textArea.setText(playList.toString());
        
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

    public PlayList getPlayList() {
        return playList;
    }

    public void setPlayList(PlayList playList) {
        this.playList = playList;
    }
    
    @Override
    protected void update() {
        textArea.setText(this.playList.toString());
    }    

    public void clearActionPerformed(ActionEvent ae){
        
        this.getPlayList().clear();
        this.update();

    }     
    
    public void playActionPerformed(ActionEvent ae) throws IOException, EmptyListException {
        
        this.getPlayList().play();

    }        
    
}

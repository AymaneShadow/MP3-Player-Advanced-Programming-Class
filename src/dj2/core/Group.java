package dj2.core;

import java.io.Serializable;

/**
 * This is the group class, it extends Artist. Therefore, it has got all its attributes and behaviors. However, this
 * class has a linked list, it has group members as an extra attribute. The reason it has a linked list is because
 * I don't know how many people are in a given group, so the best solution is to add them as the group change.
 * @author Aymane Chaoui
 */
public class Group extends Artist implements Serializable {
    
    private LinkedList <String> GroupMembers = new LinkedList <String> ();

    public Group(String name, String picturePath, String history){
        super(name, picturePath, history);
    }    

    /**
     * This is the addMember method, it allows to add members to the group into a linked list.
     * @param gm should be a String, representing the group member's name.
     */
    public void addMember(String gm){
            
            this.GroupMembers.add(gm);
            
	}

        @Override
	public String toString(){
            return super.toString() + "\n\nGroup members are:\n" + GroupMembers + "\n";
	}    
    
}

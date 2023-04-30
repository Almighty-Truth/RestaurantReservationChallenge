/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicell;

/**
 *
 * @author Student
 */
public class WalkIns {
    private String firstName;
    private int partySize;
    private WalkIns newWalkin;
    
    public WalkIns(int partySize, String firstName, String lastName)
    {
        this.firstName = firstName;
        this.partySize = partySize;
        this.newWalkin = null;
    }
     public String getFirstName() {
        return firstName;
    }

    public int getPartySize() {
        return partySize;
    }
    
    public WalkIns getNewWalkin()
    {
        return newWalkin;
    }
    public void setNewWalkIn(WalkIns newWalkin)
    {
        this.newWalkin = newWalkin;
    }
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }
    public void setPartySize(int partySize)
    {
        this.partySize = partySize;
    }
    
    @Override
    public String toString()
    {
        return firstName + "(" + partySize + ")";
    }
    
}

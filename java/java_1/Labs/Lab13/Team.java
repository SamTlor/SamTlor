package Labs.Lab13;

public class Team {
    private String name;
    private int numGoals;
    private double numShots;

    public String getName(){
        return name;
    }
    public void setName(String aName){
        name = aName;
    }
    public int getNumGoals(){
        return numGoals;
    }
    public void setNumGoals(int aNumGoals){
        numGoals = aNumGoals;
    }
    public double getNumShots(){
        return numShots;
    }
    public void setNumShots(int aNumShots){
        numShots = aNumShots;
    }

    public Team(){
        name = "";
        numGoals = 0;
        numShots = 0;
    }
    public Team(String aName, int aNumGoals, double aNumShots){
        name = aName;
        numGoals = aNumGoals;
        numShots = aNumShots;
    }
}

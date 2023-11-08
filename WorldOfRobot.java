import java.lang.*;
import java.util.*;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * The WorldOfRobot class is a class that will create the world in which the robots will be displayed.
 * 
 * @Group 5
 * @version 18/10/2023
 */
public class WorldOfRobot
{
    //Define an ArrayList called worldList which the robot's position will be stored
    private ArrayList<Robot> worldList;
    //This attribute uses the CanvasRobot class to draw the robot on the canvas
    private CanvasRobot canvasRobot;
    //This attributes defines the x position of the robot
    private int x;
    //This attributes defines the y position of the robot
    private int y;
    //Define an instance variable with the number of robots in the world
    private int numberOfRobots;
  
    /**
     * Constructeur d'objets de classe WorldOfRobot
     */
    public WorldOfRobot()
    {
        this.worldList = new ArrayList<Robot>();        
    }
    
    /**
     * Returns the list of robots in the world     
     */
    public ArrayList<Robot> getList(){
        return this.worldList;
    }

    /**
     * Get the number of robot objects in the list
     * @return size
     */
    public int getNumberOfRobots(){
        numberOfRobots = worldList.size();
        return numberOfRobots;
    }
    
    /**
     * Tells if the position the robot tries to move in is already occupied
     * @param x, horizontal robot position
     * @param y, vertical robot position
     * @return true or false
     */
    public boolean canItMove(int x, int y){
        if (this.worldList != null){
            for (Robot r : this.worldList) {
                if (r.getXPosition() == x && r.getYPosition() == y){
                     return false;
                }
            }
        }
        return true;
    }
    
    /**
     * Give a robot valid coordinate to spawn (without Game Over)
     * @return x and y coordinate
     */
    public int[] getValidCoordinate() {
    int[] result = new int[2];
    boolean possible = false;
    
    Random randomX = new Random();
    Random randomY = new Random();

    try {
        do{
            x = randomX.nextInt(12);
            y = randomY.nextInt(12);

            int xp = x ;
            int yp = y ;

            if (canItMove(xp, yp)) {
                result[0] = xp;
                result[1] = yp;
                return result;
            }
        }while (true);
    } catch (Exception e) {
        e.printStackTrace();
    }
    return result;
}

    
    /**
     * Allows to move all the robots present in the world at the same time
     */
    public void moveAll(){
        for (Robot rob : worldList)
            rob.move();
    }
    
    /**
     * Allows to move all robots one by one, w times, according to their specifications
     * @param w, number of moves of each robot
     */
    public void moveAutomatic(int w){
        int cpt=0;
        while(cpt<w){
            for (int i =0; i< worldList.size(); i++){
                worldList.get(i).move();
                try
                {
                    TimeUnit.MILLISECONDS.sleep(500);
                }
                catch (InterruptedException ie)
                {
                    ie.printStackTrace();
                }
            }
            cpt++;
        }   
    }    
        
    /**
     * Add robots to the list of robots present in the world.
     */
    public void addRobot(Robot r){
        this.worldList.add(r);
        r.setWorld(this);
    }    
}


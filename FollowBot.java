import java.util.ArrayList;

/**
 * FollowBot is a kind of robot who follows the nearest robot in there world.
 *
 *
 * @author (Dutheil Kylian)
 * @version (31/10/2023)
 */

public class FollowBot extends Robot
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private boolean target = false;
    private ArrayList<Robot> worldList;
    private double disTarget = 1000.0;
    private int xTarget;
    private int yTarget;
    
    /**
     * FollowBot constructor
     */
    public FollowBot()
    {
        // initialisation des variables d'instance
        super();
        super.setColourBody("Yellow");
        super.redraw();
    }
    
    /**
     * compares the positions of each bot in the world and targets the nearest
     * else does not move
     */
    public void move()
    {
        //cherche le bot le plus proche de lui et le suit 
        //this.worldList = super.getWorld().getList();
        if (super.getWorld().getList() != null){
            for (Robot r : super.getWorld().getList()) {
                if (java.lang.Math.sqrt(((r.getXPosition()-getXPosition())*(r.getXPosition()-getXPosition())) + ((r.getYPosition()-getYPosition())*(r.getYPosition()-getYPosition()))) < disTarget && java.lang.Math.sqrt(((r.getXPosition()-getXPosition())*(r.getXPosition()-getXPosition())) + ((r.getYPosition()-getYPosition())*(r.getYPosition()-getYPosition()))) != 0) {
                    this.disTarget = java.lang.Math.sqrt(((r.getXPosition()-getXPosition())*(r.getXPosition()-getXPosition())) + ((r.getYPosition()-getYPosition())*(r.getYPosition()-getYPosition())));
                    this.xTarget = r.getXPosition();
                    this.yTarget = r.getYPosition();
                    this.target = true;
                }
            }
            if (this.target == true) {
                this.target=false;
                this.disTarget = 1000.0;
                if(this.yTarget - getYPosition() > 0 && (this.yTarget - (getYPosition()+1)) != 0){
                    super.setYPosition (getYPosition() + 1);
                }else if(this.yTarget - getYPosition() < 0 && (this.yTarget - (getYPosition()-1)) != 0){
                    super.setYPosition (getYPosition() - 1);
                }
                
                if(this.xTarget - getXPosition() > 0 && (this.xTarget - (getXPosition()+1)) != 0){
                    super.setXPosition (getXPosition() + 1);
                }else if(this.xTarget - getXPosition() < 0 && (this.xTarget - (getXPosition()-1)) != 0){
                    super.setXPosition (getXPosition() + 1);
                }
                super.redraw();
            }
        }
    }

}


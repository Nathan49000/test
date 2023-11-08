import java.util.Random;
/**
 *The RobotPompette moves diagonally. It can consume 'menthe pastille,' which makes it tipsy. 
 *The higher the robot's 'pompette' level, the greater the probability of it not moving. 
 *It can also become sober when it can't move anymore.
 * @Nathan Aubineau
 * @Group 5 18/10/2023
 */

public class RobotPompette extends Robot{
    private int pompette; //level of pompette
    private int x = getXPosition();
    private int y = getYPosition();

    /**
     * RobotPompette class object's contructor
     */
    public RobotPompette(){
        // initialisation des variables d'instance
        super();
        pompette = 0; //initial level of pompette
        setColourBody("BLUE"); //set the color of the robot
        redraw(); //draw the robot
    }
    /**
     * Being more pompette
     *for each method call: 20% of not moving
     */
    public void getMenthePastille()
    {
         pompette = pompette +2;
    }
    /**
     * Set the level of pompette
     */
    public void setPompette(int Pompette) {
    this.pompette = Pompette;
    }
    /**
     * Evaluate the level of pompette
     *
     * @return level of pompette
     */
    public int getPompette()
    {
        return pompette;
    }
    /**
     * Reset the level of pompette
     *
     */
    public void DevenirSobre()
    {
        this.pompette = 0;
    }
    /**
     * Move the robot in diagonal. There's a probability of not moving (pompette*10 %). The robot need to passed a random test 
     * to decide to move forth or back (the random number need to be superior then his percentage of pompette)
     *
     */
 public void move() {
    getMenthePastille();
        if (pompette >= 10) {
            DevenirSobre();
        }        
        int chanceDeNePasBouger = (pompette * 10); // probability of not moving 
        int randomNumber = new Random().nextInt(100) + 1; //number between 0 et 101
        if ((randomNumber > chanceDeNePasBouger)) { //test for moving or not
            //test for going forth
            if (randomNumber >= 50 && (getXPosition() < getMaxPosition() && getYPosition() < getMaxPosition())) {
                //move forth in diagonale
                if( getWorld() != null && getWorld().canItMove((getXPosition() + 1), (getYPosition() + 1))){           
                    System.out.println(getWorld().canItMove((getXPosition() + 1), (getYPosition() + 1)));
                    setYPosition(getYPosition() + 1);
                    setXPosition(getXPosition() + 1);
                    getCanvasRobot().drawRobot(getXPosition(), getYPosition());
                }               
            } else if (getXPosition() > getMinPosition() && getYPosition() > getMinPosition()) {
                //go back in diagonale if the test failed
                if( getWorld() != null && getWorld().canItMove((getXPosition() -1), (getYPosition() -1))){
                    setYPosition(getYPosition() - 1);
                    setXPosition(getXPosition() - 1);
                    getCanvasRobot().drawRobot(getXPosition(), getYPosition());
                }
            }
        }
    redraw();
    }
}